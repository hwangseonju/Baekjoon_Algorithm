
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_14502 {

	static int N;	// 세로
	static int M;	// 가로
	static int[][] map;	// 영역
	static int[][] copymap;	// 초기 영역 복사
	static List<Dot> zero;	// 빈칸인 위치 저장
	static List<Dot> virus;	// 바이러스 위치 저장
	static int safearea = Integer.MIN_VALUE;	// 안전지역
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 연구소
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		zero = new ArrayList<>();
		virus = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==0) {
					zero.add(new Dot(r, c));
				} else if(map[r][c]==2) {
					virus.add(new Dot(r, c));
				}
			}
		}
		
		WallCombination(3, new int[3], 0);
		
		System.out.println(safearea);
	}
	
	// 설치할 벽 위치 선택 - 조합 이용
	static void WallCombination(int wall, int[] choosed, int start) {
		if(wall==0) {
			//System.out.println(choosed);
			safearea = Math.max(safearea, zero.size() - safeCount(choosed) - 3);
			return;
		}
		
		for(int i=start; i<zero.size(); i++) {
			choosed[choosed.length-wall] = i;
			WallCombination(wall-1, choosed, i+1);
		}
	}
	
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우
	static int safeCount(int[] bWall) {
		Copy();
		// 복사한 map에 새로운 벽 설치
		for(int w=0; w<bWall.length; w++) {
			copymap[zero.get(bWall[w]).x][zero.get(bWall[w]).y] = 1;
		}
		
		// 바이러스 뿌리기
		Queue<Dot> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int virusarea = 0;
		
		for(int v=0; v<virus.size(); v++) {
			queue.offer(virus.get(v));
			visited[virus.get(v).x][virus.get(v).y] = true;
		}
		
		while(!queue.isEmpty()) {
			Dot current = queue.poll();
			
			for(int d=0; d<deltas.length; d++) {
				int nr = current.x + deltas[d][0];
				int nc = current.y + deltas[d][1];
				
				if(isIn(nr, nc) && visited[nr][nc]==false && copymap[nr][nc]==0) {
					visited[nr][nc] = true;
					queue.offer(new Dot(nr, nc));
					virusarea++;
				}
			}
		}
		
		return virusarea;
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	// 초기 배열 복사
	static void Copy() {
		copymap = new int[N][M];
		for(int r=0; r<map.length; r++) {
			for(int c=0; c<map[r].length; c++) {
				copymap[r][c] = map[r][c];
			}
		}
	}
	
	static class Dot{
		int x, y;

		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}