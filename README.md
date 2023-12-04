# Project Info Plugin
Thi plugin provides ypu with information about number of lines, classes and functions of Koltin or
Java code.
## Installation
Download this repository and enter to it's directory
```bash
git clone https://github.com/MagEk1511/KFD-ProjectInfoPlugin.git
cd KFD-ProjectInfoPlugin
```
After that build plugin and publish to Maven Local repository

For Windows
```bash
./gradlew.bat pTML
```
For MacOS/Linux
```bash
./gradlew pTML
```

## Connecting Plugin

Add plugin to your `build.gradle.kt` file

```kotlin
plugins {
    id("io.github.magek1511") version "1.0.0"
}
```
and turn on Maven Local in `settings.gradle.kts`
```kotlin
pluginManagement {
    repositories {
        mavenLocal()
    }
}
```

## Usage

To configure plugin you need to set all changes in `build.gradle.kt`
```kotlin
infoConf {
    dirs = arrayOf("/* Put here directories for analyze */")
    outputDir = "/* Put here output directory */"
}
```
