import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1051 {

	static int N;	// 행
	static int M;	// 열
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		// 숫자 정사각형
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean flag = false;		// 같은 숫자가 4개 있는지 확인
		int[] check = new int[10];	// 숫자 개수 count(0~9)
		int[][] num = new int[N][M];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				num[r][c] = str.charAt(c)-'0';
				check[num[r][c]]++;
				if(check[num[r][c]]>=4) flag = true;
			}
		}
		
		int max = 1;
		if(flag) {
			int size = Math.min(N, M);
			for(int s=size; s>0; s--) {
				for(int x1=0; x1<N; x1++) {
					for(int y1=0; y1<M; y1++) {
						if(check[num[x1][y1]]>=4) {
							int x2 = x1+s-1;
							int y2 = y1+s-1;
							if(isIn(x2,y2)) {
								if(check[num[x1][y1]]>=4) {
									if(num[x1][y1]==num[x1][y2]&&num[x2][y1]==num[x2][y2]&&num[x1][y1]==num[x2][y2]) {
										max = Math.max(max, s*s);
									}
								}
							}else {
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
