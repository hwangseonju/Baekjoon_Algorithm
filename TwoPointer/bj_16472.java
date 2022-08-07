import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_16472 {

	static int N;	// 인식할 수 있는 알파벳 종류
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 고냥이
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int[] check = new int[26];	// 알파벳 개수 확인
		int s = 0;		// 시작 포인터
		int use = 0;	// 사용한 알파벳 개수
		int max = Integer.MIN_VALUE;	// 최대 문자열 길이
		
		for(int e=0; e<str.length(); e++) {	// 끝 포인터
			int current = str.charAt(e)-'a';
			
			check[current]++;
			
			if (check[current]==1) use++;
			
			while(use>N) {	// 사용한 알파벳 개수가 N개를 초과했을 경우
				int next = str.charAt(s) - 'a';
				check[next]--;
				
				if(check[next]==0) use--;
				
				s++;
			}
			max = Math.max(max, e-s+1);
		}
		
		System.out.println(max);
	}
}
