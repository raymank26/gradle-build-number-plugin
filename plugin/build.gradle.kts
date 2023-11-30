plugins {
    kotlin("jvm") version "1.9.20"
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "io.github.raymank26"
version = "0.0.1"

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
    website = "https://github.com/raymank26/gradle-build-number-plugin"
    vcsUrl = "https://github.com/raymank26/gradle-build-number-plugin.git"

    plugins {
        create("buildNumberPlugin") {
            id = "io.github.raymank26.build-number"
            displayName = "Plugin for configuring a project version in build.number file"
            description = "Plugin for configuring a project version in build.number file"
            tags = listOf("release", "version")
            implementationClass = "io.github.raymank26.build.number.plugin.BuildNumberPlugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}