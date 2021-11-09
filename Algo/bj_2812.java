
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_2812 {

	static int N;	// 전체 자리 숫자
	static int K;	// 지울 수 있는 숫자
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 크게 만들기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		String str = br.readLine();
		for(int s=0; s<N; s++) {
			int num = str.charAt(s) - '0';
			
			while (!stack.isEmpty() && stack.peek() < num && K > 0) {
				stack.pop();
				K--;
			}
			stack.add(str.charAt(s) - '0');
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		if(K>0) {
			sb.delete(0, K);
			System.out.println(sb.reverse());
		}else {
			System.out.print(sb.reverse());
		}
	}
}
