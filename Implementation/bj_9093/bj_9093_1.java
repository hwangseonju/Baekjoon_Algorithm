import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9093_1 {

	static int T; // 테스트케이스
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 단어 뒤집기 - charAt
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				String word = st.nextToken();
				for(int w=word.length()-1; w>=0; w--) {
					sb.append(word.charAt(w));
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.lastIndexOf("\n")).deleteCharAt(sb.lastIndexOf(" "));
		System.out.print(sb);
	}
}
