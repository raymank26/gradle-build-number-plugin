import io.github.raymank26.build.number.plugin.getBuildNumberVersion

plugins {
    id("java")
    id("io.github.raymank26.build-number")
}

group = "org.example"
version = project.getBuildNumberVersion()

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}