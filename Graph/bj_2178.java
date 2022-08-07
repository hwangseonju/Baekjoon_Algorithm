import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2178 {
	
	static int N;	// 세로
	static int M;	// 가로
	static int[][] map;	// 미로
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 미로 탐색
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			String num = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = num.charAt(c) - '0';
			}
		}
		
		Queue<Dot> queue = new LinkedList<>();
		queue.offer(new Dot(0,0,1));
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우
		int result = 1;
		while(!queue.isEmpty()) {
			Dot current = queue.poll();
			
			if(current.x==N-1 && current.y==M-1) {	// 도착지 도착
				result = current.cost;				// 최소 이동횟수
				break;
			}
				
			for(int d=0; d<4; d++) {
				int nr = current.x + deltas[d][0];
				int nc = current.y + deltas[d][1];
				
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc]==1) {
					queue.add(new Dot(nr,nc,current.cost+1));
					visited[nr][nc] = true;
				}
			}
		}
		System.out.println(result);
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	static class Dot{
		int x,y,cost;

		public Dot(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
