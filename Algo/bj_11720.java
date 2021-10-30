
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_11720 {
	
	static int N;	// 숫자 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 숫자의 합
		N = Integer.parseInt(br.readLine());
		String num = br.readLine();
		
		int sum = 0;	// 총 합계
		for(int n=0; n<N; n++) {
			sum += num.charAt(n) - '0';
		}
		
		System.out.println(sum);
	}

}
