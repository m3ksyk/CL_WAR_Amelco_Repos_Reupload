
public class Main8 {

	public static void main(String[] args) {
		double[] temps = {30, 29, 14, 42, -4, -10, 8, 14, 32, 11, 8, 0, 0};
		double avg = 0;
		double sum = 0;
		for (int i =0; i<temps.length; i++){
			temps[i] = (temps[i]*1.8 +32);
			sum += temps[i];
			avg = sum / temps.length;
		}
		// String.format("%.2f", avg);
		System.out.printf( "%.2f", avg);
	}

}
