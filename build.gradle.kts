plugins {
    kotlin("jvm") version "1.9.21"
    id("java-gradle-plugin")
    `maven-publish`
    application
    antlr
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(gradleApi())
    implementation("org.json:json:20231013")
    antlr("org.antlr:antlr4:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}


kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}

group = "io.github.magek1511"
version = "0.0.2"

gradlePlugin {
    plugins {
        create("projectinfo") {
            id = "io.github.magek1511"
            implementationClass = "ProjectInfoPlugin"
        }
    }

}