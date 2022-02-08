package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class bj_14468 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// 소가 길을 건너간 이유 2
		int[] cows = new int[26];
		String circle = br.readLine();
		int cnt = 0;
		
		List<Integer> list = new LinkedList<>();
		for(int c=0; c<52; c++) {
			int num = circle.charAt(c) - 'A';
			if(cows[num]==0) {
				cows[num]++;
				list.add(num);
			}else {
				for(int i=list.size()-1; i>=0; i--) {
					if(list.get(i)==num) {
						list.remove(i);
						break;
					}
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}