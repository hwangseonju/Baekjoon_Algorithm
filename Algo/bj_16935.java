import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16935 {
	static int N;
	static int M;
	static int R;
	static int C;
	static int[][] num;
	static int[][] result;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 배열 돌리기3
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // NxM 배열(N,M은 짝수)
		R = Integer.parseInt(st.nextToken()); // 연산 개수

		num = new int[N][M]; // 변경 전 배열
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				num[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		result = new int[N][M]; // 변경 후 배열
		for (int c = 0; c < R; c++) { // 연산 횟수만큼
			C = Integer.parseInt(st.nextToken()); // 입력받은 연산 방법
			Result(C);
			copy();	// 변경 후 배열 num에 재저장하기
		}

		for (int r = 0; r < result.length; r++) { // 변경 후 배열의 크기가 다를 수 있기 때문에 length를 이용하여 처리
			for (int c = 0; c < result[r].length; c++) {
				sb.append(result[r][c]).append(" ");
			}
			sb.append("\n");
		}
		 System.out.println(sb);
	}

	static int[][] deltas5 = {{1,0},{0,1},{-1,0},{0,-1}};	// 하우상좌
	static int[][] deltas6 = {{0,1},{1,0},{0,-1},{-1,0}};	// 우하좌상
	private static void Result(int cir) {
		if (cir == 1) { // 상하반전
			for (int r = result.length - 1, nr = 0; r >= 0; r--) {
				for (int c = 0; c < result[r].length; c++) {
					result[nr][c] = num[r][c];
				}
				nr++;
			}
			return;
		} else if (cir == 2) { // 좌우반전
			for (int r = 0; r < result.length; r++) {
				for (int c = result[r].length - 1, nc = 0; c >= 0; c--) {
					result[r][nc++] = num[r][c];
				}
			}
			return;
		} else if (cir == 3) { // 오른쪽으로 90도
			result = new int[num[0].length][num.length];
			for(int c = 0; c<result.length; c++) {
				for(int r=result[c].length-1, nr=0; r>=0; r--) {
					result[c][nr++] = num[r][c];
				}
			}
			return;
		} else if (cir == 4) { // 왼쪽으로 90도
			result = new int[num[0].length][num.length];
			for(int c = result.length-1, nr=0; c>=0; c--) {
				for(int r=0; r<result[c].length; r++) {
					result[nr][r] = num[r][c];
				}
				nr++;
			}
			return;
		} else  { // 5, 6번 연산
			int xhalf = result.length/2;
			int yhalf = result[0].length/2;
			int[][] first = new int[xhalf][yhalf];
			int[][] second = new int[xhalf][yhalf];
			int[][] third = new int[xhalf][yhalf];
			int[][] fourth = new int[xhalf][yhalf];
			
			for(int r=0; r<result.length; r++) {
				for(int c=0; c<result[r].length; c++) {
					if(r<xhalf&&c<yhalf) first[r][c]=num[r][c];	// 1구역
					else if(r<xhalf&&c>=yhalf) second[r][c-yhalf]=num[r][c];	// 2구역
					else if(r>=xhalf&&c>=yhalf) third[r-xhalf][c-yhalf]=num[r][c];	// 3구역
					else fourth[r-xhalf][c]=num[r][c];	// 4구역
				}
			}
			if(cir ==5) {	// 4그룹으로 나눠서 시계방향으로 1회전
				for(int r=0; r<result.length; r++) {
					for(int c=0; c<result[r].length; c++) {
						if(r<xhalf&&c<yhalf) result[r][c]=fourth[r][c];	// 4구역이 1구역으로 이동
						else if(r<xhalf&&c>=yhalf) result[r][c]=first[r][c-yhalf];	// 1구역이 2구역으로 이동
						else if(r>=xhalf&&c>=yhalf) result[r][c]=second[r-xhalf][c-yhalf];	// 2구역이 3구역으로 이동
						else result[r][c]=third[r-xhalf][c];	// 3구역이 4구역으로 이동
					}
				}
				return;
			}else {	 // 4그룹으로 나눠서 반시계방향으로 1회전
				for(int r=0; r<result.length; r++) {
					for(int c=0; c<result[r].length; c++) {
						if(r<xhalf&&c<yhalf) result[r][c]=second[r][c];	// 2구역이 1구역으로 이동
						else if(r<xhalf&&c>=yhalf) result[r][c]=third[r][c-yhalf];	// 3구역이 2구역으로 이동
						else if(r>=xhalf&&c>=yhalf) result[r][c]=fourth[r-xhalf][c-yhalf];	// 4구역이 3구역으로 이동
						else result[r][c]=first[r-xhalf][c];	// 1구역이 4구역으로 이동
					}
				}
				return;
			}
		}
	}
	
	private static void copy() {
		num = new int[result.length][result[0].length];
		for (int r = 0; r < result.length; r++) {
			for (int c = 0; c < result[r].length; c++) {
				num[r][c] = result[r][c];
			}
		}
	}
}