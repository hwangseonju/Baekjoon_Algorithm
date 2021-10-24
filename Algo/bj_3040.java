import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_3040 {
	
	static int[] p = new int[9];
	static int[] real = new int[7];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 백설공주와 일곱난쟁이(조합 이용)
		for(int n=0; n<9; n++) {
			p[n] = Integer.parseInt(br.readLine());
		}
		
		Combination(7,real, 0);
		
		for(int r:real) {
			sb.append(r).append("\n");
		}
		System.out.println(sb);
	}
	
	 static void Combination(int n, int [] choosed, int startIdx) {
	        if(n==0) {
	        	int sum=0;	// 모자의 숫자 합
	            for(int i=0; i<choosed.length; i++) {
	            	sum += choosed[i];
	            }
	            if(sum==100) {	// 합계가 100인 난쟁이 조합 찾기
	            	real = choosed.clone();
	            	return;
	            }
	            return;
	        }
	        for(int i=startIdx; i<p.length; i++) {
	            choosed[choosed.length-n] = p[i];
	            Combination(n-1, choosed, i+1);
	        }
	    }
}
