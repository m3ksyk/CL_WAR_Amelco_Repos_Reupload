
public class Main11 {

    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            String row = "";
            int rowNumber = i;

            for (int j = 1; j <= n; j++) {
                if(rowNumber >= j - 1) {
                    row += "*";
                }
                else{
                    row += j;
                }
            }
            System.out.print(row + "\n");

        }

        for(int i = n; i > 0; i--){
            String row = "";
            int rowNumber = i;

            for (int j = 1; j <= n; j++) {
                if(rowNumber >= j ) {
                    row += "*";
                }
                else{
                    row += j;
                }
            }
            System.out.print(row + "\n");
        }

        //jeśli takie rozwiązanie nie jest akceptowane, proszę o informację
        // spróbuję jeszcze pokombinować, jak to napisać, żeby całość stanowiła
        //jedną pętlę

    }

}
