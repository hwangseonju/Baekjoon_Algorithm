package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_11728 {

	static int N;	// 배열A
	static int M;	// 배열B
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 배열 합치기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> A = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			A.offer(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> B = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int m=0; m<M; m++) {
			B.offer(Integer.parseInt(st.nextToken()));
		}
		
		while(true) {
			if(A.peek() >= B.peek()) {
				sb.append(B.poll()).append(" ");
			}else {
				sb.append(A.poll()).append(" ");
			}
			if(A.isEmpty() || B.isEmpty())
				break;
		}
		
		if(!A.isEmpty()) {
			while(!A.isEmpty())
				sb.append(A.poll()).append(" ");
		}else {
			while(!B.isEmpty())
				sb.append(B.poll()).append(" ");
		}
		System.out.println(sb);
	}
}