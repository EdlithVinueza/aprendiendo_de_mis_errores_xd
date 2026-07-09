plugins {
    id("java")
    id("io.quarkus") version "3.35.2"
    id("io.freefair.lombok") version "9.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //---------------------------------------
    //Primera Parte
    //---------------------------------------

    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:3.35.2"))
    //---------------------------------------
    // REST y JSON
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-rest")
    implementation("io.quarkus:quarkus-rest-jsonb")
    // Base de Datos (PostgreSQL) y Panache
    implementation("io.quarkus:quarkus-hibernate-orm")
    implementation("io.quarkus:quarkus-hibernate-orm-panache")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    // Flyway no va aqui por que de eso se encarga el otro servicio

    // REST Client para llamar a préstamos
    implementation("io.quarkus:quarkus-rest-client-jsonb")

    //---------------------------------------
    //Segunda Parte
    //---------------------------------------
    // Service Discovery dinámico con Consul y Stork
    implementation("io.quarkus:quarkus-smallrye-stork")
    implementation("io.smallrye.reactive:smallrye-mutiny-vertx-consul-client")
   
    // El "traductor" de Stork para que pueda leer desde Consul
    implementation("io.smallrye.stork:stork-service-discovery-consul")
     
    // Telemetría / Métricas
    implementation("io.quarkus:quarkus-micrometer-registry-prometheus")
}

tasks.test {
    useJUnitPlatform()
}