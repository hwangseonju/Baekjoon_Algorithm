import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_20053_pq {
	
	static int T;	// 테스트 케이스
	static int N;	// 정수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 최대, 최소 2
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> up = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> down = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				int num = Integer.parseInt(st.nextToken());
				up.add(num);
				down.add(num);
			}
			sb.append(down.poll()).append(" ").append(up.poll()).append("\n");
		}
		System.out.print(sb);
	}

}
