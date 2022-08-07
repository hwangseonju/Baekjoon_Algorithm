import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj_10826 {
	
	static int n;
	static BigInteger[] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 피보나치 수 4
		n = Integer.parseInt(br.readLine());
		num = new BigInteger[10001];
		num[0] = BigInteger.ZERO;
		num[1] = BigInteger.ONE;
		if(n>=2) {
			System.out.print(Fibonacci(n));
		}else {
			System.out.print(num[n]);
		}
		
	}

	static BigInteger Fibonacci(int n) {
		for(int i=2; i<=n; i++) {
			num[i] = num[i-1].add(num[i-2]);
		}
		
		return num[n];
	}
}