plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    `maven-publish`
}

group = "com.github.taskeren"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":bungie-api"))

    api("org.mongodb:mongodb-driver-sync:4.9.0")
    api("org.litote.kmongo:kmongo-serialization:4.8.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.taskeren"
            artifactId = "destiny-database"
            version = "1.0"

            from(components["java"])
        }
    }
}