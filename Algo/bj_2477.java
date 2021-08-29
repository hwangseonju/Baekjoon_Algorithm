package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2477 {

	static int melon;	// 1m^2 - 참외수
	static int[][] data = new int[6][2];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 참외밭
		melon = Integer.parseInt(br.readLine());
		
		int xmax = Integer.MIN_VALUE;	// 세로 길이 중 가장 긴 길이
		int ymax = Integer.MIN_VALUE;	// 세로 길이 중 가장 긴 길이
		
		for(int n=0; n<6; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d= Integer.parseInt(st.nextToken());		// 방향
			int leng = Integer.parseInt(st.nextToken());	// 길이
			data[n][0] = d;
			data[n][1] = leng;
			if(d==4 || d==3) {	// 남쪽, 북쪽 방향일때 -> 세로
				if(xmax<leng) {
					xmax = leng;
				}
			}else {				// 동쪽, 서쪽 방향일 때 -> 가로
				if(ymax<leng) {
					ymax = leng;
				}
			}
		}
		
		int total = ((xmax*ymax)-(Check(xmax) * Check(ymax))) * melon;
		System.out.println(total);
				
	}
	
	static int Check(int max) {		// 가장 긴 가로와 세로 길이 앞뒤의 값의 차이 구하기
		int l = 0;
		for(int n=0; n<6; n++) {
			if(data[n][1] == max) {
				if(n==0) {
					l = Math.abs(data[1][1]-data[5][1]);
				}else if(n==5) {
					l = Math.abs(data[4][1]-data[0][1]);
				}else {
					l = Math.abs(data[n+1][1]-data[n-1][1]);
				}
				break;
			}
		}
		return l;
	}
}
