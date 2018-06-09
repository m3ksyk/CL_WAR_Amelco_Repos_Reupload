
public class Main9 {

    public static void main(String[] args) {
        int n = 5;
        // int n = 3;
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
        //działa to tak: jeśli numer pozycji w wierszu, jest większy od numeru wiersza, wyświetla liczbę
        // w przypadku przeciwnym wyświetla gwiazdkę
    }

}
