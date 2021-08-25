import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_10026 {

	static int N; // 배열 크기
	static int area; // 구역의 수
	static char[][] color;
	static boolean[][] visited; // 방문 여부
	static char first;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 적록색약
		N = Integer.parseInt(br.readLine());

		color = new char[N][N];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			color[r] = str.toCharArray();
		}

		for(int n=0; n<2; n++) {
			area = 0;
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {    // 구역의 개수 구하기
					if (!visited[r][c]) {
						first = color[r][c];
						dfs(r, c);
						area++;
					}
				}
			}
			
			sb.append(area).append(" ");
			
			for(int r=0; r<N; r++) {	// 적록색약일 경우를 위해 G -> R로 변경
				for(int c=0; c<N; c++) {
					if(color[r][c]=='G') {
						color[r][c]='R';
					}
				}
			}
		}
		System.out.print(sb);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];

			if (isIn(nr, nc) && color[nr][nc] == first && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
		return;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
