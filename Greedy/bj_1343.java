import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1343 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 폴리오미노
		String board = br.readLine();
		
		int cnt = 0;
		for(int b=0; b<board.length(); b++) {
			if(board.charAt(b) == 'X') {
				cnt++;
			}else {
				if(cnt!=0) {
					Change(cnt);
					cnt=0;
				}
				sb.append('.');
			}
		}
		Change(cnt);
		System.out.println(sb);
	}
	
	static void Change(int cnt) {	// 폴리오미노로 덮기
		if(cnt%2==1) {
			System.out.println(-1);
			System.exit(0);
		}else {
			for(int i=0; i<(cnt/4); i++)
				sb.append("AAAA");
			if(cnt%4!=0)
				sb.append("BB");
		}
	}
}
