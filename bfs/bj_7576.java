import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_7576 {

	static int M;	// 창고 가로
	static int N;	// 창고 세로
	static int[][] box;	// 토마토 상자
	static boolean[][] visited;	// 익은 정도 확인
	static List<Tomato> list;	// 익은 토마토 위치 저장
	static int cnt;	// 방문한 개수
	static int time;	// 소요된 일수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		// 토마토
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				
				if(box[r][c]==1) {	// 익은 토마토 위치 저장
					list.add(new Tomato(r, c));
					++cnt;
				}
				
				if(box[r][c]==-1) {	// 빈 곳
					visited[r][c] = true;
					++cnt;
				}
			}
		}
		
		if(cnt==M*N) {	// 저장될 때부터 모든 토마토 익어있는 상태
			System.out.println(0);
		}else {
			System.out.println(bfs());
		}
	}
	
	static int[][] deltas = {{0,-1},{0,1},{-1,0},{1,0}};	// 상하좌우
	static int bfs() {
		Queue<Tomato> queue = new LinkedList<>();
		for(int t=0; t<list.size(); t++) {
			 queue.offer(list.get(t));
			 visited[list.get(t).x][list.get(t).y] = true;
		}
		
		outer:while(!queue.isEmpty()) {
			int size = queue.size();
			
			if(cnt==M*N) {	// 상자에 있는 토마토가 모두 익었을 경우
				return time;
			}
			
			while(size-->0) {
				Tomato head = queue.poll();
				for(int d=0; d<deltas.length; d++) {
					int nr = head.x + deltas[d][0];
					int nc = head.y + deltas[d][1];
					
					if(isIn(nr,nc) && !visited[nr][nc]) {
						++cnt;
						visited[nr][nc] = true;
						queue.offer(new Tomato(nr,nc));
					}
				}
			}
			time++;
		}
		return -1;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}



	static class Tomato{
		int x, y;

		public Tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
