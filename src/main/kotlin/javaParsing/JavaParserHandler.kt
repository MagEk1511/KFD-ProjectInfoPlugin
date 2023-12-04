package javaParsing

import gen.antlr.JavaLexer
import gen.antlr.JavaParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.io.File

class JavaParserHandler {
    fun getParser(inputString: String): JavaParser {
        val inputStream = CharStreams.fromString(inputString)
        val lexer = JavaLexer(inputStream)
        val tokenStream = CommonTokenStream(lexer)
        return JavaParser(tokenStream)
    }

    fun parseByFile(file: File): Map<String, Int> {
        val result = mutableMapOf<String, Int>()

        result["Lines"] = file.readLines().size

        val parser = getParser(file.readText())
        val listener = JavaClassListener()
        val walker = ParseTreeWalker()
        walker.walk(listener, parser.compilationUnit())
        result["Classes"] = listener.classCounter
        result["Methods"] = listener.methodCounter
        return result
    }
}
