import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class bj_2015 {
	
	static int N;	// 정수 개수
	static int K;	// 부분합
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 수들의 합 4
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] prefix = new int[N];		// 누적합
		prefix[0] = Integer.parseInt(st.nextToken());
		for(int n=1; n<N; n++) {
			prefix[n] += prefix[n-1] + Integer.parseInt(st.nextToken());
		}
		
		long cnt = 0;
		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		map.put(0, 1);	// 누적합이 0일 경우 count되지않기 때문에 처음에 따로 넣어줌
		for (int n=0; n<N; n++) {
			cnt += map.getOrDefault(prefix[n]-K, 0);	// prefix[i]-prefix[j-1] == K ---> prefix[i]-K == prefix[j-1]
			map.put(prefix[n], map.getOrDefault(prefix[n], 0)+1);
		}
		
		System.out.println(cnt);
	}
}
