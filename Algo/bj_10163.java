package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_10163 {

	static int N; // 색종이수
	static int[][] papers = new int[1001][1001];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 색종이
		N = Integer.parseInt(br.readLine());
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // 시작점 x좌표
			int y = Integer.parseInt(st.nextToken()); // 시작점 y좌표
			int width = x + Integer.parseInt(st.nextToken()); // 너비
			int height = y + Integer.parseInt(st.nextToken()); // 높이

			// 색종이 위치 표시
			for (int r = x; r < width; r++) {
				for (int c = y; c < height; c++) {
					papers[r][c] = n;
				}
			}
		}

		int[] result = new int[N];	// 색종이 크기
		for (int i = 0; i < papers.length; i++) {
			for (int j = 0; j < papers[i].length; j++) {
				if(papers[i][j]>0) {
					result[papers[i][j]-1]++;
				}
			}
		}
		
		for (int i : result) {
			sb.append(i).append("\n");
		}
		
		System.out.print(sb);
	}
}
