package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_2164 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 카드2
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int n=1; n<=N; n++) {
			queue.add(n);
		}
		
		while(queue.size()>1) {
			queue.poll();
			int back = queue.poll();
			queue.add(back);
		}
		
		System.out.println(queue.poll());
	}

}
