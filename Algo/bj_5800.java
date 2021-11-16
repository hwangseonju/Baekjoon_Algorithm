import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_5800 {

	static int K;	// 반의 수
	static int N;	// 학생 수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 성적 통계
		K = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq;
		for(int k=1; k<=K; k++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int n=0; n<N; n++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			
			sb.append("Class ").append(k).append("\n").append("Max ");
			int gap = 0;	// Largest gap
			for(int n=0; n<N-1; n++) {
				int num = pq.poll();
				gap = Math.max((num - pq.peek()), gap);
				if(n==0) sb.append(num);	// Min
			}
			sb.append(", Min ").append(pq.poll()).append(", Largest gap ").append(gap).append("\n");
		}
		System.out.println(sb);
	}
}