import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11047 {
	
	static int N;	// 동전의 개수
	static int K;	// 값
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 동전 0
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];	// 동전의 종류
		for(int n=0; n<N; n++) {
			coins[n] = Integer.parseInt(br.readLine());
		}
		
		int cnt=0;	// 사용되는 최소 동전의 개수
		for(int c=coins.length-1; c>-1; c--) {	// 동전 종류가 하나이면서, 값이 동전크기와 같을 경우 -> coins 배열의 인덱스가 0이기 때문에 -1보다 작을 경우여야함
			cnt += K/coins[c];
			K = K%coins[c];
			if(K==0) {	// 불필요한 연산 줄이기
				break;
			}
		}
		
		System.out.println(cnt);

	}

}
