
public class Main5 {

	public static void main(String[] args) {
		int i, resultFor = 0 , resultWhile = 0;

		for (i = 1; i<=10; i++){
			//System.out.println(i);
			resultFor += i;
			//System.out.println(resultFor);
		}
		System.out.println("resultFor = " + resultFor);

		i = 0;

		while (i <10){
			i++;
			//System.out.println(i);
			resultWhile += i;
			//System.out.println(resultWhile);
		}
		System.out.println("resultWhile = " + resultWhile);
	}

}
