package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_10828 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 스택
		
		int N = Integer.parseInt(br.readLine());	// 명령어 개수
		
		Stack<Integer> stack = new Stack<>();
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			
			String order = st.nextToken();
			int output = 0;
			if(order.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
				continue;
			} else if(order.equals("pop")) {
				if(!stack.isEmpty()) {
					output = stack.pop();
				} else {
					output = -1;
				}
			} else if(order.equals("size")) {
				output = stack.size();
			} else if(order.equals("empty")) {
				if(!stack.isEmpty()) {
					output = 0;
				} else {
					output = 1;
				}
			} else if(order.equals("top")) {
				if(!stack.isEmpty()) {
					output = stack.peek();
				} else {
					output = -1;
				}
			}
			sb.append(output).append("\n");
		}
		System.out.println(sb);
	}

}
