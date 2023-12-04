pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "KFD-ProjectInfoPlugin"
include("src:main:untitled")
findProject(":src:main:untitled")?.name = "untitled"
