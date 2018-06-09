
public class Main10 {

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
                    row += "";
                }
            }
            System.out.print(row + "\n");
        }
        //tutaj jest podobnie jak w tasku 9, tyle, że jeśli numer liczby jest większy od numeru wiersza
        // to nic nie dodaje (pusty string);
    }

}
