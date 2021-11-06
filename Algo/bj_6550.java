
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_6550 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 부분 문자열
		String str;
		outer:while((str=br.readLine())!=null) {
			st = new StringTokenizer(str);
			String str1 = st.nextToken();	// 문자열 s
			String str2 = st.nextToken();	// 문자열 t
			
			char[] keyword = new char[str1.length()];
			for (int s=0; s<keyword.length; s++) {	// 문자열 s 분리
				keyword[s] = str1.charAt(s);
			}
			
			int seq=0;
			for(int s=0; s<str2.length(); s++) {
				if(str2.charAt(s)==keyword[seq]) {
					if(seq==str1.length()-1) {	// 문자열 s를 모두 만족 시 "Yes"출력
						sb.append("Yes").append("\n");
						continue outer;
					}
					seq++;
				}
			}
			sb.append("No").append("\n");
		}
		System.out.print(sb);
	}
}