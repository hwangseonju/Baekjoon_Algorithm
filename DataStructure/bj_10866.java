import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_10866 {

	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 덱
		N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("push_back")) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			}else if(order.equals("push_front")) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
			}else if(order.equals("pop_front")) {
				if(!deque.isEmpty())
					sb.append(deque.pollFirst());
				else
					sb.append(-1);
				sb.append("\n");
			}else if(order.equals("pop_back")) {
				if(!deque.isEmpty())
					sb.append(deque.pollLast());
				else
					sb.append(-1);
				sb.append("\n");
			}else if(order.equals("size")) {
				sb.append(deque.size()).append("\n");
			}else if(order.equals("empty")) {
				if(deque.isEmpty())
					sb.append(1);
				else
					sb.append(0);
				sb.append("\n");
			}else if(order.equals("front")) {
				if(!deque.isEmpty())
					sb.append(deque.peekFirst());
				else
					sb.append(-1);
				sb.append("\n");
			}else {
				if(!deque.isEmpty())
					sb.append(deque.peekLast());
				else
					sb.append(-1);
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
