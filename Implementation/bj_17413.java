import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_17413 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st1 = null;	// 전체 문자열
	static StringTokenizer st2 = null;	// 괄호 밖에 있는 문자열
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 단어 뒤집기 2
		st1 = new StringTokenizer(br.readLine(), "<>", true);
		boolean check = false;
		while(st1.hasMoreTokens()) {
			String start = st1.nextToken();
			if(start.equals("<")) {
				sb.append(start);
				check = true;
			} else if(start.equals(">")) {
				sb.append(start);
				check = false;
			} else if(check) {	// <>괄호 안에 있는 단어(문자열)일 경우
				sb.append(start);
			} else if(!check) {	// <>괄호 밖에 있는 단어(문자열)일 경우
				st2 = new StringTokenizer(start," ", true);
				while(st2.hasMoreTokens()) {
					String word = st2.nextToken();
					for(int w=word.length()-1; w>=0; w--) {
						sb.append(word.charAt(w));
					}
				}
			}
		}
		System.out.print(sb);
	}

}
