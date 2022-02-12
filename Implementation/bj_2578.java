import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2578 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		// 빙고
		Dot[] binggo = new Dot[26];
		for(int r=0; r<5; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<5; c++) {
				int num = Integer.parseInt(st.nextToken());
				binggo[num] = new Dot(r,c);
			}
		}
		
		int[] xcheck = new int[5];
		int[] ycheck = new int[5];
		boolean[][] check = new boolean[5][5];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				xcheck[binggo[num].x]++;
				ycheck[binggo[num].y]++;
				check[binggo[num].x][binggo[num].y] = true;
				if(i>1) {
					if(Check(xcheck, ycheck, check)) {
						System.out.println((i*5)+(j+1));
						System.exit(0);
					}
				}
			}
		}
	}
	
	static boolean Check(int[] xcheck, int[] ycheck, boolean[][] check) {
		//가로, 세로 일때
		int result = 0;
		boolean cnt1 = true;	// 오른쪽 아래로 향하는 대각선 확인
		boolean cnt2 = true;	// 왼쪽 안래로 향하는 대각선 확인
		int r = 4;
		for(int c=0; c<5; c++) {
			if(xcheck[c]>=5) result++;
			if(ycheck[c]>=5) result++;
			if(!check[c][c]) cnt1 = false;
			if(!check[c][r--]) cnt2 = false;
		}
		
		if(cnt1) result++;
		if(cnt2) result++;
		
		if(result>=3)
			return true;
		else
			return false;
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
