plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "com.github.taskeren"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":bungie-api"))

    api("org.mongodb:mongodb-driver-sync:4.7.1")
    api("org.litote.kmongo:kmongo-serialization:4.7.0")

    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("org.apache.logging.log4j:log4j-api:2.18.0")
    implementation("org.apache.logging.log4j:log4j-core:2.18.0")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.18.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}