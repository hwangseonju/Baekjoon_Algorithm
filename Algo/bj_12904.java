
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_12904 {

	static char[] S;
	static List<Character> T;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// A와 B
		String str1 = br.readLine();	// S
		String str2 = br.readLine();	// T
		T = new ArrayList<>();
		
		for(int t=0; t<str2.length(); t++) {
			T.add(str2.charAt(t));
		}
		
		int current = T.size()-1;
		while(true) {
			if(str1.length() == T.size()) {
				if(str1.equals(sb.toString())){
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			}
			
			if(T.get(current) == 'A') {
				T.remove(current);
				current = current==0? 0:T.size()-1;
			} else {
				T.remove(current);
				current = current==0? T.size()-1:0;
			}
		}
	}
	
	// T로 S를 만들 수 있는지 확인
	static void check(int cur) {
		if(cur==0) {	// T리스트의 가장 끝이 시작
			for(int i = T.size()-1; i>=0; i--) {
				sb.append(T.get(i));
			}
		}else {			// T리스트 가장 처음이 시작
			for(int i = 0; i<T.size(); i++) {
				sb.append(T.get(i));
			}
		}
	}
}
