
public class Main1 {

	public static void main(String[] args) {
		boolean first = true;
		// boolean second = false;
		boolean second = true;
		boolean isFirstEqualSecond;
		isFirstEqualSecond = first == second;
		System.out.println(isFirstEqualSecond);
		/* za pierwszym razem zwraca false (bo first i second nie są sobie równe)
		 po zmianie wartości second na przeciwną zwraca oczywiście true (bo już są sobie równe)
		*/
	}

}
