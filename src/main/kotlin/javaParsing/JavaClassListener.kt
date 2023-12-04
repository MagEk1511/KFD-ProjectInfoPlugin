package javaParsing

import gen.antlr.JavaParser.AnnotationTypeDeclarationContext
import gen.antlr.JavaParser.ClassDeclarationContext
import gen.antlr.JavaParser.EnumDeclarationContext
import gen.antlr.JavaParser.InterfaceDeclarationContext
import gen.antlr.JavaParser.MethodDeclarationContext
import gen.antlr.JavaParser.RecordDeclarationContext
import gen.antlr.JavaParserBaseListener
import org.antlr.v4.runtime.ParserRuleContext

class JavaClassListener: JavaParserBaseListener() {

    var classCounter = 0
    var methodCounter = 0
    override fun enterEveryRule(ctx: ParserRuleContext?) {
        if (ctx is ClassDeclarationContext || ctx is EnumDeclarationContext
            || ctx is InterfaceDeclarationContext || ctx is AnnotationTypeDeclarationContext
            || ctx is RecordDeclarationContext) {
            classCounter++
        }
        if (ctx is MethodDeclarationContext) {
            methodCounter++
        }
        super.enterEveryRule(ctx)
    }
}