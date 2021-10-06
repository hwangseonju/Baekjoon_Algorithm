import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17471 {

	static int N; // 구역 수
	static int[] people; // 인구
	static int[][] graph; // 인접행렬
	static int min;		// 최소 인구수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 게리맨더링
		N = Integer.parseInt(br.readLine());

		people = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int p = 0; p < N; p++) {
			people[p] = Integer.parseInt(st.nextToken());
		}

		graph = new int[N][N];
		for (int r = 0; r < N; r++) {	// 인접 행렬 생성
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			while (n-- > 0) {
				int c = Integer.parseInt(st.nextToken()) - 1;
				graph[r][c] = 1;
				graph[c][r] = 1;
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int n=1; n<N; n++) {	// A마을 구역 선택 - 조합 ( 최소1 ~ 최대 N-1 )
			combination(n, new int[n], 0);
		}
		
		if(min == Integer.MAX_VALUE) {	// 2개의 선거구로 나눌 수 없을 경우 -1 출력
			min = -1;
		}
		System.out.println(min);
	}

	// A마을 구역 선택 - 조합
	static void combination(int n, int[] choosed, int idx) {
		if(n==0) {
			//System.out.println(Arrays.toString(choosed));
			check(choosed);
			return;
		}
		
		for(int i=idx; i<N; i++) {
			choosed[choosed.length-n] = i;
			combination(n-1, choosed, i+1);
		}
	}

	
	static void check(int[] select) {
		boolean[] choosed = new boolean[N];
		boolean[] unchoosed = new boolean[N];	// 다른 선거구(B구역)
		Arrays.fill(choosed, true);
		
		for(int i=0; i<select.length; i++) {	// A구역에서 선택되지않은 마을로 B구역 구성
			unchoosed[select[i]] = true;
			choosed[select[i]] = false;
		}
		
		boolean[] a = new boolean[N];	// A구역 복사배열
		boolean[] b = new boolean[N];	// B구역 복사배열
		for(int c=0; c<N; c++) {
			if(choosed[c]) {
				a[c] = true;
			}
			if(unchoosed[c]) {
				b[c] = true;
			}
		}
		
		int A = 0;
		int B = 0;
		if(bfs(choosed) && bfs(unchoosed)) {	// A구역과 B구역 모두 각자 인접해있을 경우만 인구 최소차이값 구하기
			for(int i=0; i<N; i++) {
				if(a[i] == true) {
					A += people[i];
				}
				if(b[i] == true) {
					B += people[i];
				}
			}
			min = Math.min(Math.abs(A-B), min);
		}
	}
	
	// 각 구역의 인접 여부 확인
	static boolean bfs(boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				queue.offer(i);
				break;
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int n=0; n<N; n++) {
				if(graph[current][n]==1 && !visited[current]) {
						queue.offer(n);
				}
			}
			if(!visited[current]) visited[current] = true;
		}
		
		// 1개라도 false가 존재하면 인접하지않는다는 의미
		for(int v=0; v<N; v++) {
			if(!visited[v]) return false;
		}
		return true;
	}
}
