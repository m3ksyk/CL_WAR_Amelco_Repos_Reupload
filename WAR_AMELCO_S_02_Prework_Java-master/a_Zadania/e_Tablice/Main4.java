
public class Main4 {

	public static void main(String[] args) {
		int numbers[] = {1,2,3,4,5,6,7,8,9,10};
		int sumOdd = 0;
		for (int i = 0; i<numbers.length; i++){
			if ( numbers[i] % 2 == 0){
				System.out.println(numbers[i]);
			}
			else{
				sumOdd +=numbers[i];
			}
		}
		System.out.println("The sum of odd numbers is: " + sumOdd);

	}

}
