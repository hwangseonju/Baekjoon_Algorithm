package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_11729_PQ {

	static int N;	// 배열A
	static int M;	// 배열B
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 배열 합치기(우선순위큐 사용)
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int m=0; m<M; m++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}
		
		System.out.println(sb);
	}
}