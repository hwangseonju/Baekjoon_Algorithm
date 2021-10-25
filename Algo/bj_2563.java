package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2563 {
	static int N;
	static int[][] map = new int[100][100];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 색종이
		N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int r=x; r<x+10; r++) {
				for(int c=y; c<y+10; c++) {
					map[r][c] = 1;
				}
			}
		}
		int count=0;	// 색종이 전체 넓이
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(map[r][c]==1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
