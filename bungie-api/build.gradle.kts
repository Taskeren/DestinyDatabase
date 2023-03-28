plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    `maven-publish`
}

group = "com.github.taskeren"
version = "1.1"

repositories {
    mavenCentral()
}

dependencies {
    val ktor_version = "2.2.4"
    api("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-okhttp:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    implementation(project(":bungie-api-oauth"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    api("org.slf4j:slf4j-api:2.0.5")
    api("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.20.0")
    implementation("org.jline:jline:3.23.0")
    implementation("org.jline:jline-terminal-jansi:3.23.0")
    implementation("net.minecrell:terminalconsoleappender:1.3.0")
    implementation("org.fusesource.jansi:jansi:2.4.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    testImplementation("com.moandjiezana.toml:toml4j:0.7.2")
    testImplementation(kotlin("reflect"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.taskeren"
            artifactId = "bungie-api"
            version = "1.0"

            from(components["java"])
        }
    }
}