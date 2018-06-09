
public class Main3 {

	public static void main(String[] args) {
		int nr1;
		double nr2, result;
		nr1 = 15;
		nr2 = 25.5;
		result = 0;
		result = nr1 + nr2;
		System.out.println(result);
		//zmienna result powinna byc typu double, gdyby byla typu int, to po dodaniu
		// do siebie zmiennej typu int i zmiennej typu double stracilibysmy rozszerzenie
		//dziesietne i wynik operacji bylby niedokladny
	}

}
