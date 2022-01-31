import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_14916 {

	static int n;	// 거스름돈 액수
	static int coin;	// 최소 동전 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 거스름돈
		n = Integer.parseInt(br.readLine());
		if(n/5==0) {
			coin = (n%2==1) ? -1:(n/2);
		}else {
			if((n%5)%2==1) {	// 5원으로 나눴을때 홀수인 경우
				coin = (n/5) - 1;
				coin += (((n%5)+5)/2);
			}else {				// 짝수인 경우
				coin = n/5;
				coin += ((n%5)/2);
			}
		}
		System.out.println(coin);
	}
}
