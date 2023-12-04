package internal

import javaParsing.JavaParserHandler
import kotlinParsing.KotlinParseHandler
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File


open class ProjectInfoTask: DefaultTask() {

    @TaskAction
    fun action() {
        val extension = project.extensions.run {
            findByName("infoConf") as ProjectInfoExtension
        }
        val output = File("${extension.outputDir}/info.json")

        val javaParserHandler = JavaParserHandler()
        val kotlinParserHandler = KotlinParseHandler()

        val totalCounter = mutableMapOf(
            "Lines" to 0,
            "Classes" to 0,
            "Methods" to 0
        )

        extension.dirs.forEach { dir ->
            File(dir).walkTopDown().forEach {file ->
                val fileResult = when(file.extension) {
                    "kt" ->  kotlinParserHandler.parseByFile(file)
                    "java" -> javaParserHandler.parseByFile(file)
                    else -> {
                        mapOf(
                            "Lines" to 0,
                            "Classes" to 0,
                            "Methods" to 0
                        )
                    }
                }
                fileResult.forEach { (key, value) ->
                    totalCounter[key] = totalCounter[key]!! + value
                }
            }
        }

        val jsonString = org.json.JSONObject(totalCounter).toString()
        output.writeText(jsonString)
        output.createNewFile()
    }
}