package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_192385 {
	
	static int N;	// 활동 영역
	static int M;	// 승객수
	static int[][] map;	// 지도
	static Dot taxi;	// 택시 시작 위치
	static Dot[] destination;	// 도착 위치
	static int use;		// 사용한 연료
	static int result;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 스타트 택시
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.parseInt(st.nextToken());
		taxi = new Dot(0,0,0);
		
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		taxi.x = Integer.parseInt(st.nextToken())-1;
		taxi.y = Integer.parseInt(st.nextToken())-1;
		
		destination = new Dot[M+1];
		for(int m=1; m<=M; m++) {
			st = new StringTokenizer(br.readLine());
			
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = -m;
			destination[m] = new Dot(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, 0);
		}
		
		while(M!=0) {
			// 가까운 거리의 승객 찾기
			search();
			// 출발지 -> 도착지
			if(result<0) {
				result = -1;
				break;
			}else {
				driving();
				if(result<0) {
					result = -1;
					break;
				}else {
					result += (use*2);
					M--;
				}
			}
		}
		System.out.println(result);
	}
	
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	static void search() {
		PriorityQueue<Dot> pq = new PriorityQueue<>();
		
		if(map[taxi.x][taxi.y]!=0) {	// 현재 택시 위치가 승객 위치일 경우
			pq.add(taxi);
		}else {
			Queue<Dot> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			
			queue.add(taxi);
			visited[taxi.x][taxi.y] = true;
			
			while(!queue.isEmpty()) {
				Dot current = queue.poll();
			
				for(int d=0; d<4; d++) {
					int nr = current.x + deltas[d][0];
					int nc = current.y + deltas[d][1];
					
					if(isIn(nr,nc) && map[nr][nc]!=1 && !visited[nr][nc]) {
						if(map[nr][nc]!=0) {	// 도착지일 경우 우선순위 큐에 삽입
							pq.add(new Dot(nr, nc, current.cost+1));
						}
						queue.add(new Dot(nr, nc, current.cost+1));
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		if(pq.size()>0) {
			taxi = pq.poll();
			result = result - taxi.cost;
			taxi.cost = 0;
			return;
		}else {		// 승객이 한명도 없을 경우
			result = -1;
		}
	}
	
	static void driving() {
		Queue<Dot> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		queue.add(taxi);
		visited[taxi.x][taxi.y] = true;
		use = 0;
		
		while (!queue.isEmpty()) {
			Dot current = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = current.x + deltas[d][0];
				int nc = current.y + deltas[d][1];
				
				if (isIn(nr, nc) && map[nr][nc] != 1 && !visited[nr][nc]) {
					if (nr == destination[Math.abs(map[taxi.x][taxi.y])].x && nc == destination[Math.abs(map[taxi.x][taxi.y])].y) {	// 도착지 도착
						map[taxi.x][taxi.y] = 0;
						taxi.x = nr;
						taxi.y = nc;
						taxi.cost = 0;
						result = result - (current.cost+1);
						use = (current.cost+1);
						return;
					} else {
						queue.add(new Dot(nr, nc, current.cost+1));
						visited[nr][nc] = true;
					}
				}
			}
		}
		result = -1;	// 도착지에 도착하지 못했을 경우(ex. 도착지가 벽에 둘러쌓여있을때)
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	static class Dot implements Comparable<Dot>{
		int x, y, cost;

		public Dot(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Dot o) {
			if(this.cost==o.cost) {
				if(this.x==o.x) {
					return Integer.compare(this.y, o.y);
				}
				return Integer.compare(this.x, o.x);
			} else {
				return Integer.compare(this.cost, o.cost);
			}
		}
	}
}
