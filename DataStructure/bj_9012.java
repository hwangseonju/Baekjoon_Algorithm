package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_9012 {
	
	static int T;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 괄호
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			boolean flag = false;
			for(int s=0; s<str.length(); s++) {
				char data = str.charAt(s);
				if(data=='(') {
					stack.add(data);
				}else {
					if(stack.isEmpty()) {
						flag = true;
						break;
					}else {
						stack.pop();
					}
				}
			}
			
			if(!stack.empty() || flag)
				sb.append("NO");
			else
				sb.append("YES");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
