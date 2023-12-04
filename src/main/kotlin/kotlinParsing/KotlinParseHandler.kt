package kotlinParsing

import antlr.KotlinLexer
import antlr.KotlinParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.io.File

class KotlinParseHandler {
    fun getParser(inputString: String): KotlinParser {
        val inputStream = CharStreams.fromString(inputString)
        val lexer = KotlinLexer(inputStream)
        val tokenStream = CommonTokenStream(lexer)
        return KotlinParser(tokenStream)
    }

    fun parseByFile(file: File): Map<String, Int> {
        val result = mutableMapOf<String, Int>()

        result["Lines"] = file.readLines().size

        val parser = getParser(file.readText())
        val listener = KotlinClassListener()
        val walker = ParseTreeWalker()
        walker.walk(listener, parser.kotlinFile())
        result["Classes"] = listener.classCounter
        result["Methods"] = listener.methodCounter
        return result
    }
}