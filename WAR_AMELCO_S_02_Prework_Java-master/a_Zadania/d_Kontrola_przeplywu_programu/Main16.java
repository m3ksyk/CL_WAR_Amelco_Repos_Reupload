
public class Main16 {

    public static void main(String[] args) {
        int x = 420;
        int y = 168;
        int gdc = 0;

        if( x < 0 || y < 0){
            System.out.println(" x i y nie mogą być mniejsze od 0");
        }
        else {
            while (y != x) {
                if(x > y){
                    x = x - y;
                }
                else{
                    y= y -x;
                }
                gdc = x;

            }
            System.out.println("Dla liczb " + x + " i " + y + " GDC to: " + gdc);
        }
    }

}
