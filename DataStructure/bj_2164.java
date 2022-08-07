import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_2164 {

	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 카드2
		Queue<Integer> queue = new LinkedList<>();
		N = Integer.parseInt(br.readLine());
		for(int n=1; n<=N; n++) {
			queue.add(n);
		}
		
		int num = 0;
		int i = 0;
		while(!queue.isEmpty()) {
			num = queue.poll();
			if(i%2!=0) 
				queue.add(num);
			i++;
		}
		System.out.print(num);
	}
}
