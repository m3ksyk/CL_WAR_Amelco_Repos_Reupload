
public class Circle {
    public static double circleArea(double r){
        if(r < 0){
            throw  new IllegalArgumentException("Radius of a circle cannot be less than Zero");
        }
        double result = Math.PI * Math.pow(r,2);
        result = roundOff(result);
        return result;
    }
    private static double roundOff(double x) {
        return Math.round(x * 100) / 100.0;
    }
}
