import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1158 {
	
	static int N;
	static int K;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 요세푸스 문제
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 앉을 사람 수
		K = Integer.parseInt(st.nextToken());	// 제거할 번호
		
		for(int n=1; n<=N; n++) {
			queue.offer(n);
		}
		
		int count=1;
		sb.append("<");
		while(!queue.isEmpty()) {
			if(count%K==0 || queue.size()==1) {
				sb.append(queue.poll()).append(", ");
			} else {
				queue.offer(queue.poll());
			}
			count++;
		}
		if(queue.isEmpty()) sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}
