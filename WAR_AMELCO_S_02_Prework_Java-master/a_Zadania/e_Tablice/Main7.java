
import java.util.Random;

public class Main7 {

	public static void main(String[] args) {
		Random generator = new Random();
		generator.nextInt(20);
		int[] randNumbers = new int[100];
		int sum = 0;
		for (int i =0; i<randNumbers.length; i++){
			randNumbers[i]=(generator.nextInt(20));
			System.out.print(randNumbers[i] + ",");
			sum += randNumbers[i];
		}
		System.out.println("\nThe sum of 100 random numbers from 0 to 20 is: " + sum);
	}

}
