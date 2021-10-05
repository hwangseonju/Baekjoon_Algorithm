import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class jg_2577 {

	static int N;		// 접시 수
	static int d;		// 초밥 가지수
	static int k;		// 연속된 k개
	static int c;		// 쿠폰 번호
	static int[] sushi;		// 초밥 종류
	static int[] visited;	// 방문
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		// 회전 초밥(고)
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		visited = new int[d+1];
		
		for(int r=0; r<N; r++) {
			sushi[r] = Integer.parseInt(br.readLine());
		}
		
		int eat[] = new int[N];
		int cnt = 0;
		
		for(int i=0; i<k; i++) {
			if(visited[sushi[i]]==0) cnt++;
			visited[sushi[i]]++;
		}
		
		eat[k-1] = cnt;
		
		if(visited[c]==0) {
			eat[k-1]++;
		}
		
		for(int s=k; s<k+N; s++) {
			int i = s%N;
			if(visited[sushi[i]]==0) cnt++;
			visited[sushi[i]]++;
			
			visited[sushi[s-k]]--;
			if(visited[sushi[s-k]]==0) cnt--;
			
			eat[i] = cnt;
			
			if(visited[c]==0) {
				eat[i]++;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i : eat) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}
}