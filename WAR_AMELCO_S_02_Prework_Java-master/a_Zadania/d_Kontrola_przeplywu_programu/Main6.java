

public class Main6 {

	public static void main(String[] args) {
		//int n = 5;
		int n = 10;
		int	i;
		System.out.println("pętla for:");
		for(i = 0; i <= n ; i++){
			if( i % 2 == 0){
				System.out.println(i + " - parzysta (even)");
			}
			else {
				System.out.println(i + " - nieparzysta (odd)");
			}
		}
		System.out.println("Pętla while:");
		int j = 0;
		while( j <= n){
			if( j % 2 == 0){
				System.out.println(j + " - parzysta (even)");
			}
			else {
				System.out.println(j + " - nieparzysta (odd)");
			}
			j++;
			// inkrementacje zmiennej umieszczam za pętlą, żeby najpierw
			// sprawdzony był warunek, a dopiero potem zwiększona wartość zmiennej
			// (bez tego pętla nie sprawdzała warunku dla zera

		}
	}

}
