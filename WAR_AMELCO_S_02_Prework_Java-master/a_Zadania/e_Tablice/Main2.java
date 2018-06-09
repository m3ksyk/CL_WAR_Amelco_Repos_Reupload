
public class Main2 {

	public static void main(String[] args) {
		String fruits[] = {"apple", "banana", "orange", "pear", "watermellon"};
		//printing the first element of the table
		System.out.println("First fruit is " + fruits[0]);
		//printing the last element of the table
		System.out.println("Last fruit is " + fruits[(fruits.length - 1)]);
		/*
			had to do -1 otherwise received "array out of bounds" exception
			(because the last element in the table is #4 and the program would be
			looking for #5)
		*/

		System.out.println("----");

		//printing all table elements using loop
		for (int i=0; i < fruits.length; i++){
			System.out.println(fruits[i]);
		}
	}

}
