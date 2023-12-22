plugins {
    java
    war
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "ru.nsu.ooad"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.springframework.boot:spring-boot-starter-web")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.flywaydb:flyway-core")

//    implementation ("org.apache.logging.log4j:log4j-api:2.x.x")
//    implementation ("org.apache.logging.log4j:log4j-core:2.x.x")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
