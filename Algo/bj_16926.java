import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16926 {

	static int N;
	static int M;
	static int R;
	static int[][] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 배열 돌리기1
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // N x M 배열
		R = Integer.parseInt(st.nextToken()); // 회전수

		num = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				num[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우하좌상
		while (R-- > 0) {	// 회전 수만큼 돌리기
			int box = Math.min(N, M)/2; // 배열 테두리 개수
			int start = 0;
			for (int i = 0; i < box; i++) {
				int d = 0; // 방향
				int r = i;	// 행
				int c = i;	// 열
				start = num[r][c];	// 변하기 전의 시작값은 회전하면서 없어지기 때문에 따로 저장 후 마지막에 넣어준다.
				while (d < 4) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					if (nr < N - i && nc < M - i && nr >= i && nc >= i) {	// 배열 테두리마다의 범위값
						num[r][c] = num[nr][nc];
						r = nr;
						c = nc;
					} else {
						d++;
					}
				}
				num[i + 1][i] = start;
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(num[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
