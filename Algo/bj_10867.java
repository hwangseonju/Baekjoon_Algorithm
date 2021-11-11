
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class bj_10867 {
	
	static int N;	// 숫자 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 중복 빼고 정렬하기
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Set<Integer> num = new HashSet<>();
		for(int n=0; n<N; n++) {
			num.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> numOrder = new ArrayList<>(num);
		Collections.sort(numOrder);
		
		for (Integer n : numOrder) {
			sb.append(n).append(" ");
		}
		
		System.out.println(sb);
	}
}
