package types;

import expression.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import subst.Subst;
import type.*;
import typeenv.TypeEnv;

import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: derketzer
 * Date: 06.03.2015
 */
public class Types {

    public static int count = 0;
    public static int level = 0;
    public static ArrayList<String> unboundVars;

    public static String indent(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }

    public static Map<String, Type> mguOk(Type t1, Type t2) {
        if (t1.getClass() == TFun.class && t2.getClass() == TFun.class) {
            TFun tFun1 = (TFun)t1;
            TFun tFun2 = (TFun)t2;
            Map<String, Type> s1 = mguOk(tFun1.getT1(), tFun2.getT1());
            Map<String, Type> s2 = mguOk(TypesType.applyOk(s1, tFun1.getT2()), TypesType.applyOk(s1, tFun2.getT2()));
            return Subst.composeOk(s2, s1);
        }
        if (t1.getClass() == TVar.class) {
            return varBindOk(((TVar) t1).getVar(), t2);
        }
        if (t2.getClass() == TVar.class) {
            return varBindOk(((TVar) t2).getVar(), t1);
        }
        throw new RuntimeException("types do not unify");
    }

    public static Map<String, Type> varBindOk(String var, Type type) {
        if (type.getClass() == TVar.class) {
            TVar tVar = (TVar)type;
            if (tVar.getVar().equals(var)) {
                return new HashMap<>();
            }
        }
        if (TypesType.ftvOk(type).contains(var)) {
            throw new WrongMethodTypeException("occurs check fails " + var + " vs. " + type);
        }
        Map<String, Type> map = new HashMap<>();
        map.put(var, type);
        return map;
    }

    public static Pair ti(Map<String, Scheme> envGet, Expression expr) {
        Map<String, Scheme> env = new HashMap<>(envGet);
        if (expr.getClass() == EVar.class) {
            level++;
            EVar eVar = (EVar) expr;
            if (env.containsKey(eVar.getVar())) {
                Map<String, Type> s = new HashMap<>();
                for (String var : env.get(eVar.getVar()).getVars()) {
                    s.put(var, new TVar("a"));
                }
                level--;
                Pair p = new Pair(new HashMap<String, Type>(), TypesType.applyOk(s, env.get(eVar.getVar()).getType()));
                return new Pair(new HashMap<String, Type>(), TypesType.applyOk(s, env.get(eVar.getVar()).getType()));
            } else {
                Pair p = new Pair(new HashMap<String, Type>(), new TVar("a"));
                unboundVars.add(eVar.getVar());
                return p;
            }
        }
        if (expr.getClass() == EAbs.class) {
            level++;
            EAbs eAbs = (EAbs) expr;
            TVar tv = new TVar("a");
            env.put(eAbs.getVar(), new Scheme(new ArrayList<String>(), tv));
            Pair pair = ti(env, eAbs.getLambdaBody());
            level--;
            return new Pair(pair.getSubst(), new TFun(TypesType.applyOk(pair.getSubst(), tv), pair.getType()));
        }
        if (expr.getClass() == EApp.class) {
            level++;
            EApp eApp = (EApp) expr;
            TVar tv = new TVar("a");
            Pair pair1 = ti(env, eApp.getE1());
            Pair pair2 = ti(TypesTypeEnv.applyOk(pair1.getSubst(), env), eApp.getE2());
            Map<String, Type> s3 = mguOk(TypesType.applyOk(pair2.getSubst(), pair1.getType()), new TFun(pair2.getType(), tv));
            level--;
            return new Pair(Subst.composeOk(s3, Subst.composeOk(pair2.getSubst(), pair1.getSubst())), TypesType.applyOk(s3, tv));
        }
        if (expr.getClass() == ELet.class) {
            level++;
            ELet eLet = (ELet) expr;
            Pair pair1 = ti(env, eLet.getDefExpr());
            Map<String, Scheme> env1 = new HashMap<>(env);
            env1.remove(eLet.getVar());
            Scheme scheme = TypeEnv.generalizeOk(TypesTypeEnv.applyOk(pair1.getSubst(), env), pair1.getType());
            Map<String, Scheme> env2 = new HashMap<>(env1);
            env2.put(eLet.getVar(), scheme);
            Pair pair2 = ti(TypesTypeEnv.applyOk(pair1.getSubst(), env2), eLet.getInExpr());
            level--;
            return new Pair(Subst.composeOk(pair1.getSubst(), pair2.getSubst()), pair2.getType());
        }
        throw new RuntimeException("ti");
    }

    public static void count(Expression expression) {
        HashMap<String, Scheme> hm = new HashMap<>();
        try {
            unboundVars = new ArrayList<>();
            TVar.resetCounter();
            Type t = Types.typeInference(hm, expression);
            System.out.println(t);
        } catch (WrongMethodTypeException t) {
            System.out.println("Лямбда-выражение не имеет типа.");
        }
    }

    public static Type typeInference(Map<String, Scheme> env, Expression expr) {
        Pair pair = ti(env, expr);
        return TypesType.applyOk(pair.getSubst(), pair.getType());
    }
}
