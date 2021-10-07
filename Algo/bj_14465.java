import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_14465 {
	
	static int N;	//횡단보도
	static int K;	// 연속된 K
	static int B;	// 고장난 개수
	static int result;	// 최소 수리해야되는 신호등
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 소가 길을 건너간 이유 5
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int[] state = new int[N+1];		// 신호등 상태
		int[] ps = new int[N+1];		// state배열의 누적합 배열
		Arrays.fill(state, 1);
		state[0] = 0;
		
		for(int b=0; b<B; b++) {	// 고장난 신호등 = 0, 나머지 = 1
			int num = Integer.parseInt(br.readLine());
			state[num] = 0;
		}
		
		ps[0] = 0;
		for(int p=1; p<=N; p++) {	// 누적합 배열 만들기
			ps[p]=ps[p-1]+state[p];
		}
		
		result = Integer.MAX_VALUE;
		for(int s=K; s<ps.length; s++) {	// K번째부터 시작해서 (K-K칸의 합)들 중에 가장 값이 작은것 구하기
			int need = K-(ps[s]-ps[s-K]);
			result = Math.min(need, result);
		}
		
		System.out.println(result);
	}
}
