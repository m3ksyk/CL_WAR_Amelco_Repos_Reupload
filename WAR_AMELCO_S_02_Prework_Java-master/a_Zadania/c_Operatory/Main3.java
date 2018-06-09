
public class Main3 {

	public static void main(String[] args) {
		String str1, str2, joinedStrings;
		str1 = "Kurs";
		str2 = "Java";
		joinedStrings = "";
		joinedStrings = str1 + str2;
		// w tej postaci wypisuje się bez spacji między słowami
		System.out.println(joinedStrings);
		//teraz jest lepiej
		joinedStrings = str1 + " " + str2;
		System.out.println(joinedStrings);


	}

}
