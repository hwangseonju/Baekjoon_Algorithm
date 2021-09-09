package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_9372 {
	
	static int T;	// 테스트 케이스
	static int N;	// 국가
	static int M;	// 비행기 종류
	static int[][] path;	// 왕복 비행기 가능 여부
	static int airplane;	// 최소 비행기 횟수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 상근이의 여행(bfs)
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			path = new int[N+1][N+1];
			int a = 0;
			int b = 0;
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				path[a][b] = 1;
				path[b][a] = 1;
			}
			airplane = 0;
			
			bfs();
			
			sb.append(airplane-1).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];

		visited[0] = true;
		visited[1] = true;
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			airplane++;
			for(int i=1; i<=N; i++) {
				if(visited[i]==false && path[cur][i]==1) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
