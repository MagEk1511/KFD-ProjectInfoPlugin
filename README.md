# Project Info Plugin
This plugin provides you with information about number of lines, classes and functions of Koltin or
Java code.

## Connecting Plugin

Add plugin to your `build.gradle.kt` file

```kotlin
plugins {
    id("io.github.magek1511") version "1.0.0"
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
