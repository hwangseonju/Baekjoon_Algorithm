import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jg_1169 {
	
	static int N;	// 던진 횟수
	static int M;	// 출력 형식
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 주사위 던지기1
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(M==1) {
			dice1(N, new int[N]);
		}else if(M==2) {
			dice2(N, new int[N], 1);
		}else if(M==3) {
			dice3(N, new int[N], new boolean[7]);
		}
		System.out.print(sb);
	}
	
	static void dice1(int n, int[] choosed) {
		if(n==0) {
			print(choosed);
			return;
		}
		
		for(int i=1; i<=6; i++) {
			choosed[choosed.length-n] = i;
			dice1(n-1, choosed);
		}
	}
	
	static void dice2(int n, int[] choosed, int startidx) {
		if(n==0) {
			print(choosed);
			return;
		}
		
		for(int i=startidx; i<=6; i++) {
			choosed[choosed.length-n] = i;
			dice2(n-1, choosed, i);
		}
	}
	
	static void dice3(int n, int[] choosed, boolean[] visited) {
		if(n==0) {
			print(choosed);
			return;
		}
		
		for(int i=1; i<=6; i++) {
			if(!visited[i]) {
				choosed[choosed.length-n] = i;
				visited[i] = true;
				dice3(n-1, choosed, visited);
				visited[i] = false;
			}
		}
	}
	
	static void print(int[] choosed) {
		for(int i=0; i<choosed.length; i++) {
			sb.append(choosed[i]).append(" ");
		}
		sb.append("\n");
	}
}
