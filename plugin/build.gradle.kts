plugins {
    kotlin("jvm") version "1.9.20"
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "com.github.raymank26"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
    testImplementation(gradleTestKit())
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

gradlePlugin {
    website = "https://github.com/ysb33r/gradleTest"

    plugins {
        create("buildNumberPlugin") {
            id = "com.github.raymank26.build-number"
            displayName = "Plugin for configuring a project version in build.number file"
            tags = listOf("release", "version")
            implementationClass = "com.github.raymank26.build.number.plugin.BuildNumberPlugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}