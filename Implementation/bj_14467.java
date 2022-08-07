import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_14467 {
	
	static int N;	// 관찰 횟수
	static int[] visited = new int[11];		// 소 이동 확인
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 소가 길을 건너간 이유 1
		N = Integer.parseInt(br.readLine());
		
		Arrays.fill(visited, -1);
		int cnt = 0;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int check = Integer.parseInt(st.nextToken());
			
			if(visited[num]!=-1 && visited[num]!=check) {
				cnt++;
			}
			visited[num] = check;
		}
		System.out.println(cnt);
	}
}
