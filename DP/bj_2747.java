import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2747 {
	
	static int N;
	static int[] num = new int[46];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 피보나치 수

		N = Integer.parseInt(br.readLine());
		
		System.out.println(Fibonacci(N));
	}
	
	static int Fibonacci(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			if (num[n] > 0)
	            return num[n];
			
			num[n] = Fibonacci(n-1) + Fibonacci(n-2);
			return num[n];
		}
	}
}
