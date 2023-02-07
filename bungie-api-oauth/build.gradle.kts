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
	val ktorVersion = "2.2.3"
	implementation("io.ktor:ktor-server-core:$ktorVersion")
	implementation("io.ktor:ktor-server-netty:$ktorVersion")
	implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
	implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
	implementation("io.ktor:ktor-network-tls-certificates:$ktorVersion")

	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
	testImplementation("org.slf4j:slf4j-simple:2.0.6")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
	useJUnitPlatform()
}