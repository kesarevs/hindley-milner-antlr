package type;

/**
 * Created with IntelliJ IDEA.
 * User: derketzer
 * Date: 20.05.2015
 */
public class Type {
    @Override
    public String toString() {
        if (this.getClass() == TVar.class) {
            return ((TVar)this).getVar();
        }
        if (this.getClass() == TFun.class) {
            if (((TFun)this).getT1().getClass() == TVar.class ){
                return ((TFun)this).getT1() + " -> " + ((TFun)this).getT2();
            }
        }
        return "(" + ((TFun)this).getT1() + ") -> " + ((TFun)this).getT2();
    }
}
