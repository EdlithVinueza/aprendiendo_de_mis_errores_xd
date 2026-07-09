package org.programacion.distribuida;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.vertx.core.Vertx;
import io.vertx.ext.consul.CheckOptions;
import io.vertx.ext.consul.ConsulClient;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.ServiceOptions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import java.net.InetAddress;
import java.util.List;

@ApplicationScoped
public class ClienteLifecycle {
    @Inject
    @ConfigProperty(name = "consul.host", defaultValue = "127.0.0.1")
    String consulHost;
    @Inject
    @ConfigProperty(name = "consul.port", defaultValue = "8500")
    Integer consulPort;
    @Inject
    @ConfigProperty(name = "quarkus.http.port", defaultValue = "8080")
    Integer appPort;
    private ConsulClient client;
    private String serviceId;
    public void init(@Observes StartupEvent event, Vertx vertx) {
        try {
            ConsulClientOptions options = new ConsulClientOptions().setHost(consulHost).setPort(consulPort);
            this.client = ConsulClient.create(vertx, options);
            String ipAddress = InetAddress.getLocalHost().getHostAddress();

            // Le ponemos app-clientes
            this.serviceId = "app-clientes-" + java.util.UUID.randomUUID().toString();
            CheckOptions checkOptions = new CheckOptions()
                    .setHttp("http://" + ipAddress + ":" + appPort + "/ping")
                    .setInterval("10s")
                    .setDeregisterAfter("10s");
            List<String> tags = java.util.List.of(
                    "traefik.enable=true",
                    "traefik.http.routers.app-clientes.rule=PathPrefix(`/clientes`)",
                    "traefik.http.services.app-clientes.loadbalancer.server.port=" + appPort
            );

            ServiceOptions serviceOptions = new ServiceOptions()
                    .setName("app-clientes") // Este es el nombre con el que se registra en Consul
                    .setId(serviceId)
                    .setAddress(ipAddress)
                    .setPort(appPort)
                    .setCheckOptions(checkOptions)
                    .setTags(tags);
            client.registerService(serviceOptions)
                    .onSuccess(it -> System.out.println("Service registered in Consul with ID: " + serviceId))
                    .onFailure(it -> System.out.println("Failed to register in Consul: " + it.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void destroy(@Observes ShutdownEvent event, Vertx vertx) {
        if (client != null && serviceId != null) {
            client.deregisterService(serviceId)
                    .onSuccess(it -> System.out.println("Service deregistered from Consul"));
        }
    }
}