import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_18258 {
	
	static int N;	// 명령어 수 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 큐 2
		N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dque = new LinkedList<>();
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("push")) {
				dque.addLast(Integer.parseInt(st.nextToken()));
			}else if(order.equals("pop")) {
				if(!dque.isEmpty())
					sb.append(dque.poll());
				else
					sb.append(-1);
				sb.append("\n");
			}else if(order.equals("size")) {
				sb.append(dque.size()).append("\n");
			}else if(order.equals("empty")) {
				if(!dque.isEmpty())
					sb.append(0);
				else
					sb.append(1);
				sb.append("\n");
			}else if(order.equals("front")) {
				if(!dque.isEmpty())
					sb.append(dque.peekFirst());
				else
					sb.append(-1);
				sb.append("\n");
			}else if(order.equals("back")) {
				if(!dque.isEmpty())
					sb.append(dque.peekLast());
				else
					sb.append(-1);
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
