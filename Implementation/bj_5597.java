package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_5597 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 과제 안 내신 분..?
		boolean[] student = new boolean[31];
		for(int s=0; s<28; s++) {
			student[Integer.parseInt(br.readLine())] = true;
		}
		
		for(int s=1; s<=30; s++) {
			if(!student[s])
				System.out.println(s);
		}
	}
}
