package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2589 {
	
	static int R;	// 세로
	static int C;	// 가로
	static char[][] map;	// 보물 지도
	static int result;	// 최단 시간
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 보물섬
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		int max = Integer.MIN_VALUE;	// 최단 거리
		// 모든 육지에서 검사
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]=='L') {
					result = 0;
					bfs(r, c);
					max = Math.max(max, result);
				}
			}
		}
		
		System.out.println(max);
	}
	
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우
	static void bfs(int r, int c) {
		Queue<Ground> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		queue.add(new Ground(r,c, 0));
		visited[r][c] = true;
		
		Ground current = null;
		while(!queue.isEmpty()) {
			current = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = current.x + deltas[d][0];
				int nc = current.y + deltas[d][1];
				
				if(isIn(nr, nc) && map[nr][nc]=='L' && !visited[nr][nc]) {
					queue.add(new Ground(nr, nc, current.cost+1));
					visited[nr][nc]=true;
				}
			}
		}
		result = current.cost;	// 가장 마지막으로 큐에서 나온 거리값 = 보물이 있는 육지의 최단거리
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	static class Ground{
		int x, y, cost;

		public Ground(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}