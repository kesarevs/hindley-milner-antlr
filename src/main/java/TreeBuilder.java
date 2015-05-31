import expression.*;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
/**
 * Created by derketzer on 13.03.15.
 */
public class TreeBuilder {

    public static Expression treeBuild(ParseTree ctx) {

        if (ctx.getClass() == HMParser.ParenthesisContext.class) {
            HMParser.ParenthesisContext parenthesisContext = (HMParser.ParenthesisContext)ctx;
            return treeBuild(parenthesisContext.getChild(1));
        }
        if (ctx.getClass() == HMParser.VarContext.class) {
            HMParser.VarContext varContext = (HMParser.VarContext)ctx;
            return new EVar(varContext.ID().toString());
        }
        if (ctx.getClass() == HMParser.AppContext.class) {
            HMParser.AppContext appContext = (HMParser.AppContext)ctx;
            return new EApp(treeBuild(appContext.getChild(0)), treeBuild(appContext.getChild(1)));
        }
        if (ctx.getClass() == HMParser.AbsContext.class) {
            HMParser.AbsContext absContext = (HMParser.AbsContext)ctx;
            String var = absContext.getChild(1).toString();
            return new EAbs(var, treeBuild(absContext.getChild(3)));
        }
        if (ctx.getClass() == HMParser.LetContext.class) {
            HMParser.LetContext letContext = (HMParser.LetContext)ctx;
            String var = letContext.getChild(1).toString();
            return new ELet(var, treeBuild(letContext.getChild(3)), treeBuild(letContext.getChild(5)));
        }

        throw new RuntimeException("no rule");
    }
}
