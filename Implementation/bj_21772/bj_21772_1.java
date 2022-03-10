import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_21772_1 {
	
	static int R;	// 세로 크기
	static int C;	// 가로 크기
	static int T;	// 소요 시간
	static char[][] map;
	static int max = 0;
	static int sweetpotato;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 가희의 고구마 먹방 - bfs(제자리에 있는 경우 제거, 고구마 개수 count해서 시간이 다 되기전에 다 먹으면 끝내는 방식) -> count안했을때보다 느림..
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		int nr = 0, nc = 0;
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c]=='G') {
					nr = r;
					nc = c;
				}
				if(map[r][c]=='S')
					sweetpotato++;
			}
		}
		
		Eat(nr,nc, 0, 0);
		System.out.println(max);
	}
	
	static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1}};
	static void Eat(int r, int c, int cnt, int time) {	// DFS
		if(time==T || cnt==sweetpotato) {
			max = Math.max(cnt, max);
			return;
		}
		
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr,nc) && map[nr][nc] != '#') {
				if(map[nr][nc]=='S') {
					map[nr][nc] = '.';
					Eat(nr, nc, cnt+1, time+1);
					map[nr][nc] = 'S';
				} else {
					Eat(nr, nc, cnt, time+1);
				}
				
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}