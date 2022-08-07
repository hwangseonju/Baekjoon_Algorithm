import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2748 {
	
	static int N;
	static long[] num = new long[91];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 피보나치 수 2
		N = Integer.parseInt(br.readLine());
		System.out.println(Fibonacci(N));
	}
	
	static long Fibonacci(int n) {
		if(n==0) {
			return 0;
		} else if(n==1 || n==2) {
			return 1;
		} else {
			if(num[n]>0)
				return num[n];
			num[n] = Fibonacci(n-1) + Fibonacci(n-2);
			return num[n];
		}
	}
}