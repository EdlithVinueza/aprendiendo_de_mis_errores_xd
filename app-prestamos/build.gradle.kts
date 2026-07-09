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
    // Flyway (Para correr el script .sql)
    implementation("io.quarkus:quarkus-flyway")
    runtimeOnly("org.flywaydb:flyway-database-postgresql:12.5.0")
}

tasks.test {
    useJUnitPlatform()
}