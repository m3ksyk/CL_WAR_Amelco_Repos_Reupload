
public class Main5 {

	public static void main(String[] args) {
		int a=1, b;
		System.out.println(++a); //2
		System.out.println(a++); //2
		System.out.println(a); //3
		b=a++;
		System.out.println(b); //3
		b=++a;
		System.out.println(++a); //6
		/* program pokazuje różnice w działaniu preinkrementacji i postinkrementacji
			preinkrementacja - najpierw dodaje, potem używa zmiennej (np.wypisuje)
			postinkrementacja - odwrotnie (najpierw używa, potem dodaje)
		 */
	}

}
