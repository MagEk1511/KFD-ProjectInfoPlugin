package kotlinParsing

import antlr.KotlinParser.ClassDeclarationContext
import antlr.KotlinParser.FunctionDeclarationContext
import antlr.KotlinParser.ObjectDeclarationContext
import antlr.KotlinParserBaseListener
import org.antlr.v4.runtime.ParserRuleContext

class KotlinClassListener : KotlinParserBaseListener() {

    var classCounter = 0
    var methodCounter = 0
    override fun enterEveryRule(ctx: ParserRuleContext?) {
        if (ctx is ClassDeclarationContext || ctx is ObjectDeclarationContext) {
            classCounter++
        }
        if (ctx is FunctionDeclarationContext) {
            methodCounter++
        }
        super.enterEveryRule(ctx)
    }

}
