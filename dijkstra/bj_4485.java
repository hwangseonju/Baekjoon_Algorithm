import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_4485 {

	static int N;	// 동굴 크기
	static int[][] cave;	// 도둑루피가 존재하는 동굴
	static boolean[][] visited;	// 방문 확인
	static int lose[][];	// 잃은 루피 최소값 갱신
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 녹색 옷 입은 애가 젤다지?
		int tc = 0;	// 테스트케이스 번호
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {	// 0 이 입력되면 종료
				break;
			}else {
				tc++;
			}
			
			cave = new int[N][N];
			visited = new boolean[N][N];
			lose = new int[N][N];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c=0; c<N; c++) {
					cave[r][c] = Integer.parseInt(st.nextToken());
					lose[r][c] = Integer.MAX_VALUE;
				}
			}
			
			go();
			
			/*for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					System.out.print(lose[r][c]+" ");
				}
				System.out.println();
			}*/
			
			sb.append("Problem ").append(tc).append(": ").append(lose[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
	}
	
	// 잃는 루피 금액 최소 -> 다익스트라 이용
	static int deltas[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static void go() {
		PriorityQueue<dot> pq = new PriorityQueue<>();
		pq.offer(new dot(0, 0, cave[0][0]));	// 출발 정점(cave[0,0])은 무조건 넣고 시작
		visited[0][0] = true;
		lose[0][0] = cave[0][0];
		
		while(!pq.isEmpty()) {
		dot head = pq.poll();
		
			for(int d=0; d<4; d++) {
				int nr = head.x + deltas[d][0];
				int nc = head.y + deltas[d][1];
				
				if(isIn(nr, nc) && !visited[nr][nc]) {
					if(lose[nr][nc] > lose[head.x][head.y] + cave[nr][nc]) {
						lose[nr][nc] = lose[head.x][head.y] + cave[nr][nc];
						pq.offer(new dot(nr, nc, lose[nr][nc]));
						visited[nr][nc] = true;
					}
				}
				
				if(nr==N-1 && nc==N-1) {	// 도착 정점에 도착하면 끝
					return;
				}
			}
		}
	}
	
	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

	static class dot implements Comparable<dot>{
		int x, y, rupee;

		public dot(int x, int y, int rupee) {
			super();
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(dot o) {
			return Integer.compare(this.rupee, o.rupee);
		}
	}
}
