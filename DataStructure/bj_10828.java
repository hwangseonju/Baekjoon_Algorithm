import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_10828 {

	static int N;	// 명령어 개수
	static Stack<Integer> stack = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 스택
		N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			String act = st.nextToken();
			if(act.equals("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
				continue;
			} else if(act.equals("pop")) {
				if(stack.isEmpty())
					sb.append(-1);
				else
					sb.append(stack.pop());
			} else if(act.equals("size")) {
				sb.append(stack.size());
			} else if(act.equals("empty")) {
				if(stack.isEmpty())
					sb.append(1);
				else
					sb.append(0);
			} else if(act.equals("top")) {
				if(stack.isEmpty())
					sb.append(-1);
				else
					sb.append(stack.peek());
			}
			sb.append("\n");
		}
		
		sb.deleteCharAt(sb.lastIndexOf("\n"));
		System.out.println(sb);
	}
}