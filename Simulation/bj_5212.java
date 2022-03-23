import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_5212 {
	
	static int R;
	static int C;
	static char[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 지구 온난화
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		Queue<Dot> queue = new LinkedList<>();
		List<Dot> list = new LinkedList<>();
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c]=='X')
					queue.offer(new Dot(r,c));
			}
		}
		
		int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
		int rmin = 11;
		int rmax = -1;
		int cmin = 11;
		int cmax = -1;
		while(!queue.isEmpty()) {
			Dot current = queue.poll();
			
			int cnt = 0;
			for(int d=0; d<4; d++) {
				int nr = current.x + deltas[d][0];
				int nc = current.y + deltas[d][1];
				
				if(!isIn(nr,nc) || map[nr][nc]=='.') {
					cnt++;
				}
			}
			
			if(cnt<3) {
				list.add(current);
				rmin = Math.min(current.x, rmin);
				rmax = Math.max(current.x, rmax);
				cmin = Math.min(current.y, cmin);
				cmax = Math.max(current.y, cmax);
			}
		}
		
		R = rmax-rmin+1;
		C = cmax-cmin+1;
		
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(map[i], '.');
		}
		
		for(int l=0; l<list.size(); l++) {
			map[list.get(l).x-rmin][list.get(l).y-cmin] = 'X';
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	static class Dot{
		int x,y;

		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
