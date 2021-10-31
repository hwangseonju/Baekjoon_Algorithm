import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_10809 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 알파벳 찾기
		String str = br.readLine();
		
		int[] alph = new int[26];
		Arrays.fill(alph, -1);	// 알파벳이 포함되어있지 않으면 -1로 설정해야되기 때문에 처음에 설정해준다.
		
		for(int s=0; s<str.length(); s++) {
			if(alph[str.charAt(s)-97] == -1) {	// 처음 등장하는 위치이므로 -1인 곳만 값 설정
				alph[str.charAt(s)-97] = s;		// 아스키코드 : a=97
			}
		}
		
		for (int i : alph) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}

}
