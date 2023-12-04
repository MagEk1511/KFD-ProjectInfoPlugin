plugins {
    kotlin("jvm") version "1.9.21"
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.2.1"
    `maven-publish`
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(gradleApi())
    implementation("org.json:json:20231013")
    implementation("org.antlr:antlr4:4.13.1")
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
version = "1.0.0"

gradlePlugin {
    website = "https://github.com/MagEk1511/KFD-ProjectInfoPlugin.git"
    vcsUrl = "https://github.com/MagEk1511/KFD-ProjectInfoPlugin.git"
    plugins {
        create("projectinfo") {
            id = "io.github.magek1511"
            displayName = "Project Info Plugin"
            description = "Shows number of lines, classes and methods"
            tags.set(listOf("Info", "Lines", "Classes", "Methods"))
            implementationClass = "ProjectInfoPlugin"
        }
    }

}