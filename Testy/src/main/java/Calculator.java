import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {

    public int add(int a, int b){
        return a+b;
    }
    public int subtract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        return a*b;
    }
    public int divide(int a, int b){
        if(b==0){
            throw new ArithmeticException("don't divide by zero, dumbass");
        }else{
        return a/b;
        }
    }
    public boolean greater(int a, int b){
        return a > b;
    }


    public double eval(String str) {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        try {
            return Double.parseDouble(engine.eval(str).toString());
        } catch (ScriptException ex) {
            throw new RuntimeException(ex);
        }
    }
}
