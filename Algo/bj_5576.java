import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class bj_5576 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 콘테스트
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());	// 우선순위큐 - 내림차순
		int sum = 0;
		for(int n=0; n<2; n++) {	// W대학, K대학 => 총 2번
			for(int i=0; i<10; i++) {
				pq.offer(Integer.parseInt(br.readLine()));
			}
			
			sum = 0;
			for(int s=0; s<3; s++) {	// 높은 점수 3명만 합산
				sum += pq.poll();
			}
			
			sb.append(sum).append(" ");
			pq.clear();
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));	// 마지막 공백 제거
		System.out.println(sb);
	}

}
