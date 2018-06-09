package pl.coderslab.lambdaExpressions;

public class Main4 {
    static void calculate(Object value, SRF<Object> f){
        f.calculate(value);
    }

    public static void main(String[] args) {
        calculate( 2.0, value -> {
            Double val = (Double) value;
            double powRes = Math.pow(val,2);
            double sqrtRes = Math.sqrt(val);
            int factorial = 1;
            for (int i=1; i<= val; i++){
                factorial*=i;
            }
            System.out.println("results for value: " + value);
            System.out.println("Power: " + powRes + " sqrt: " + sqrtRes + " factorial " + factorial);
        });
    }
}
