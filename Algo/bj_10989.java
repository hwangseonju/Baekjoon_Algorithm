
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_10989 {

	static int N;	// 수의 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 수 정렬하기 3
		N = Integer.parseInt(br.readLine());
		int[] cnt = new int[10001];
		for(int n=0; n<N; n++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		
		for(int n=0; n<cnt.length; n++) {
			if(cnt[n]>0) {
				for(int i=0; i<cnt[n]; i++) {
					sb.append(n).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}