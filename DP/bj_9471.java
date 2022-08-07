package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9471 {

	static int P;	// 테스트케이스
	static int N;	// 테스트케이스 번호
	static int M;	// k(M)의 M값
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 피사노 주기
		P = Integer.parseInt(br.readLine());
		
		for(int p=0; p<P; p++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int start = 0;
			int next = 1;
			int turn = 0;
			
			while(true) {
				if(start==0 && next==1 && turn>0) break;
				
				int temp = start;
				start = next;
				next = (temp + start)%M;
				++turn;
			}
			
			sb.append(N).append(" ").append(turn).append("\n");
		}
		System.out.print(sb);
	}
}
