package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_3029 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 경고
		String current = br.readLine();
		String na = br.readLine();
		
		if(current.equals(na)) {
			System.out.println("24:00:00");
		}else {
			int[] ctime = new int[3];	// 현재 시간
			int[] ntime = new int[3];	// 나트륨 던질 시간
			int[] result = new int[3];	// 결과
			
			st = new StringTokenizer(current, ":");
			for(int i=0; i<3; i++) {
				ctime[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(na, ":");
			for(int i=0; i<3; i++) {
				ntime[i] = Integer.parseInt(st.nextToken());
			}
			
			// 초, 분 처리
			for(int t=2; t>0; t--) {
				if(ntime[t]<ctime[t]) {
					ntime[t-1]--;
					ntime[t] += 60;
				}
				result[t] = ntime[t]-ctime[t];
			}
			
			// 시 처리
			ntime[0] += ntime[0]<ctime[0] ? 24:0;
			result[0] = ntime[0] - ctime[0];
			
			for (int i : result) {
				if(i<10)
					sb.append(0);
				sb.append(i).append(":");
			}
			sb.deleteCharAt(sb.lastIndexOf(":"));	// 마지막 문자열 자르기
			
			System.out.println(sb);
		}
	}
}