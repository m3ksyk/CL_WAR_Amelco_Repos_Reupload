
public class Main8 {

	public static void main(String[] args) {
		int x = 16 , y = 15;
		boolean x_y = x < y; //false
		boolean t = true;
		boolean f = false;
		boolean t_f = t || f; //true
		boolean last = x_y == t_f; //false
		System.out.println(x_y);
		System.out.println(t_f);
		System.out.println(last);
		/*  sprawdzenie x < y = false , x nie jest mniejsze od y
			sprawdzenie t || f = true , jeden z elementów jest prawdziwy (t)
			sprawdzenie last x_y == t_f = false , ponieważ false nie jest równe true (false != true)
		*/
	}

}
