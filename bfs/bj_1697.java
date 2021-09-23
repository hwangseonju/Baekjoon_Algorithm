import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1697 {

	static int N;	// 수빈
	static int K;	// 동생
	static boolean[] visited = new boolean[100001];	// 방문 여부
	static int time;	// 소요 시간
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		// 숨바꼭질
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		time = 0;
		bfs();
		
		System.out.println(time);
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		visited[N]=true;
		
		outer:while(true) {
			int size = queue.size();
			
			while(size-->0) {
				int head = queue.poll();
				
				if(head==K) {	// 수빈이와 동생의 위치가 같을 경우
					break outer;
				}
				
				if(head-1 >= 0 && visited[head-1]==false) {		// X-1인 경우
					visited[head-1] = true;
					queue.offer(head-1);
				}
				
				if(head+1 < 100001 && visited[head+1]==false) {	// X+1인 경우
					visited[head+1] = true;
					queue.offer(head+1);
				}
				
				if(head*2 < 100001 && visited[head*2]==false) {	// X*2인 경우
					visited[head*2] = true;
					queue.offer(head*2);
				}
			}
			time++;
		}
		return;
	}
}
