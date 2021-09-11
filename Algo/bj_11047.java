package algo;

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
		
		int[] coins = new int[N];
		for(int n=0; n<N; n++) {
			coins[n] = Integer.parseInt(br.readLine());
		}
		
		int start = 0;	// 비교를 시작할 값
		for (int i : coins) {
			if(i>K) {
				start = i-1;
				break;
			}
		}
		
		for(int i=0; i<coins.length; i++) {
			if(coins[i]>K) {
				start = i-1;
				break;
			}else {
				start = i;
			}
		}
		
		int cnt=0;	// 동전의 개수
		while(K!=0) {
			for(int c=start; c>0; c--) {
				cnt += K/coins[c];
				K = K%coins[c];
			}
		}
		
		System.out.println(cnt);

	}

}
