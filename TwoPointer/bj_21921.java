import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_21921 {

	static int N;	// 블로그 시작 일수
	static int X;	// 최대 방문자 확인 기간
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		// 블로그
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int[] visitor = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			visitor[n] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;	// 최대 방문자 확인 기간 개수
		long max = 0;	// X기간 동안 최대 방문자
		long sum = 0;	// X기간 동안 방문자의 총합
		for(int n=0; n<N; n++) {
			sum += visitor[n];
			if(n<X-1)
				continue;
			if(max<sum) {
				max = sum;
				cnt = 1;
			}else if(max==sum) {
				cnt++;
			}
			sum -= visitor[n-X+1];
		}
		if(max==0)	// 최대방문자가 0명인 경우
			System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}