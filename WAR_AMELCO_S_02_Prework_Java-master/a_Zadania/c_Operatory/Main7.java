
public class Main7 {

	public static void main(String[] args) {
		int nr1 = 7 , nr2 = 4, result;
		result = nr1 + nr2;
		System.out.println(result);
		nr1 = 10;
		result = nr1 + nr2;
		System.out.println(result);
		/*wynik zmienił się, ponieważ zmiennej nr1 przypisaliśmy nową wartość
		  od tego miejsca w wykonywanych działaniach będzie używana właśnie ta wartość
		*/
	}

}
