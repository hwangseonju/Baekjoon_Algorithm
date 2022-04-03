import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_4396 {

	static int N; // 맵 크기
	static char[][] map;
	static char[][] current;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 지뢰찾기
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		int[][] deltas = {{1,0},{1,1},{1,-1},{-1,0},{-1,1},{-1,-1},{0,-1},{0,1}};
		boolean check = false;
		int[][] result = new int[N][N];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				char state = str.charAt(c);
				if(state=='x' && map[r][c]=='*') {
					sb.append("*");
				}else if(state=='x'){
					int cnt = 0;
					for(int d=0; d<8; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
								
						if(isIn(nr,nc) && map[nr][nc]=='*') {
							cnt++;
						}
					}
					sb.append(cnt);
				} else {
					sb.append('.');
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}