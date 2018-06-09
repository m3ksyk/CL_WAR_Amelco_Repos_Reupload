
public class Main14 {

    public static void main(String[] args) {
        int n = 5;
        for(int i = 1; i<=n; i++){
            String row = "";
            int rowNumber = n;
            for(int j = 1; j<= n; j++) {
                int k = i * j;
                String dzialanie = (i + " x " + j + " = " + k + "  ");
                if(rowNumber >= j - 1){
                    row += dzialanie;}

            }
            System.out.print(row + "\n");
        }
    }

}
