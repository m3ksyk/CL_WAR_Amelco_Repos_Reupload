import java.util.ArrayList;
import java.util.List;

public class Factors {

   public static Integer[] generatePrimeFactors(int n){
       List<Integer> list = new ArrayList<>();
       for(int i=1; i<=n; i++){
           if(n % i == 0){
               list.add(i);
           }
       }
       Integer[] resultArray = list.toArray(new Integer[list.size()]);
       return resultArray;
   }
}
