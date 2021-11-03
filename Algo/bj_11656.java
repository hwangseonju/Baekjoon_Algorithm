
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj_11656 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 접미사 배열
		String str = br.readLine();
		List<Character> origin = new ArrayList<>();	// 단어 - 알파벳으로 분리
		List<String> dic = new ArrayList<>();		// 사전순
		
		for(int s=0; s<str.length(); s++) {
			origin.add(str.charAt(s));
		}
		
		dic.add(str);
		for(int d=0; d<str.length()-1; d++) {
			origin.remove(0);
			String n = "";
			for(int o=0; o<origin.size(); o++) {
				n += origin.get(o);
			}
			
			dic.add(n);
		}
		
		Collections.sort(dic);
		
		for (String items : dic) {
			sb.append(items).append("\n");
		}
		
		System.out.print(sb);
	}

}
