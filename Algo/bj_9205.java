import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9205 {

	static int T; // 테스트 케이스
	static int N; // 편의점 개수(경유지 최대값)
	static int[][] map; // 좌표
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 맥주 마시면서 걸어가기
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N + 2][2];
			int[][] beer = new int[N + 2][N + 2];

			for (int m = 0; m < N + 2; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[m][0] = Integer.parseInt(st.nextToken());
				map[m][1] = Integer.parseInt(st.nextToken());
			}

			for (int r = 0; r < beer.length; r++) {
				for (int c = 0; c < beer.length; c++) {
					if (r == c) {
						beer[r][c] = -1;
					} else {
						beer[r][c] = Math.abs(map[r][0] - map[c][0]) + Math.abs(map[r][1] - map[c][1])<=1000 ? 1:-1;
					}
				}
			}

			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
						if(i==j) continue;
						if(beer[i][k]==-1 || beer[k][j]==-1) continue;
						
						beer[i][j] = 1;
					}
				}
			}
			
			if(beer[0][N+1] == 1) {
				sb.append("happy").append("\n");
			}else {
				sb.append("sad").append("\n");
			}
		}
		System.out.print(sb);
	}
}