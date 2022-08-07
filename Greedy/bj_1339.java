import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1339 {
	
	static int N;	// 단어 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 단어 수학
		N = Integer.parseInt(br.readLine());
		
		int[] check = new int[26];
		for(int n=0; n<N; n++) {
			String word = br.readLine();
			int size = word.length();
			for(int w=0; w<word.length(); w++) {
				int alpa = word.charAt(w)-'A';
				check[alpa] += (int) Math.pow(10, --size);
			}
		}
		
		int sum = 0;
		int cnt = 9;
		Arrays.sort(check);
		for(int a=25; a>=0; a--) {
			if(check[a]==0)
				break;
			sum += (check[a] * cnt--);
		}
		
		System.out.println(sum);
	}
}
