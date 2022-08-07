package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_21918 {
	
	static int N;	// 전구 개수
	static int M;	// 명령어 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder(); 

	public static void main(String[] args) throws IOException {
		// 전구
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] lights = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int l=1; l<=N; l++) {
			lights[l] = Integer.parseInt(st.nextToken());
		}
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==1) {	// 명령어1
				lights[b] = c;
			}else if(a==2) {	// 명령어2
				for(int l=b; l<=c; l++) {
					lights[l] = (lights[l]==1) ? 0:1; 
				}
			}else if(a==3) {	// 명령어3
				for(int l=b; l<=c; l++) {
					lights[l] = 0;
				}
			}else {			// 명령어4
				for(int l=b; l<=c; l++) {
					lights[l] = 1;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(lights[i]).append(" ");
		}
		System.out.println(sb);
	}
}
