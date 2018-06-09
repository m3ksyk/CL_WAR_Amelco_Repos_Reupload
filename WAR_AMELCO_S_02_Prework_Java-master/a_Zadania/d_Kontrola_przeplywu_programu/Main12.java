
public class Main12 {

    public static void main(String[] args) {
        int a = 10;
        int b = 12;
        int c = 15;
        if( a + b > c && c + b > a && a + c > b){
            System.out.println("Z podanych boków " + a + ", " + b + ", " + c +
            " można zbudować trójkąt");
        }
        else{
            System.out.println("Z podanych boków " + a + ", " + b + ", " + c +
                    " nie można zbudować trójkąta");
        }
    }

}
