
public class Main5 {

	public static void main(String[] args) {
		//int numbers[] = {1,2,3,4,5,16,7,8,9,10};
		int numbers[] = {-12,-21,-3,-4,-5,-6,-7,-8,-9,-10};
		int max = numbers[0];
		/*
		wykombinowałem tak:
		jeśli max był ustawiony na zero, to przy liczbach ujemnych zawsze podawał zero,
		 ponieważ nie miał w tabeli wartośći większej od niego. Jeśli jednak ustawi się
		 dla max wartość jednego dowolnego elementu tabeli, to niezaleźnie od tego,
		 czy wartości są dodatnie czy ujemne, zostanie sprawdzone tabela

		 Jeśli takie rozwiązanie nie jest satysfakcjonujące, proszę i informację
		 */
		for (int i = 1; i<numbers.length; i++){
			if (numbers[i] > max){
				max = numbers[i];
			}
		}
		System.out.println("Highest number is: " + max);
	}

}
