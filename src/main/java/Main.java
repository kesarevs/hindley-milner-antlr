
import expression.Expression;
import types.Types;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by derketzer on 12.03.15.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        if (args.length == 0) {
            System.out.println("Usage: java -jar algow.jar <file_name>+");
            return;
        }
        for (String file : args) {
            System.out.println("============+" + file + "+============");
            HMLexer lexer = new HMLexer(new ANTLRFileStream(file));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            HMParser parser = new HMParser(tokens);
            ParseTree tree = parser.expr();
            Expression expression = TreeBuilder.treeBuild(tree);
            Types.count(expression);
        }
    }
}