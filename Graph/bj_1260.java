import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1260 {
	
	static int N;	// 정점의 개수
	static int M;	// 간선의 개수
	static int V;	// 탐색 시작 정점
	static boolean[][] adjMatrix;	// 인접 행렬
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// DFS와 BFS
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new boolean[N][N];
		
		// 인접행렬 ( T / F )
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}

		// 정점은 1부터 시작하지만, 배열 index는 0부터 시작하기 때문에 -1을 해줌.
		dfs(V-1, new boolean[N]);	
		sb.append("\n");
		bfs(V-1);
		
		System.out.print(sb);
	}
	
	static void dfs(int v, boolean[] visited) {
		visited[v] = true;	// 방문 O
		sb.append(v+1).append(" ");	// 방문한 정점(노드)
		
		for(int i=0; i<N; i++) {
			if(!visited[i] && adjMatrix[v][i]) {	//  방문하지않은 정점 & 인접행렬이 true일 때
				dfs(i, visited);
			}
		}
		return;
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current+1).append(" ");
			
			for(int i=0; i<N; i++) {
				if(!visited[i] && adjMatrix[current][i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}