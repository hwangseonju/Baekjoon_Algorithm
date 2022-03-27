import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2753 {
	
	static int Y;	//연도
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 윤년
		Y = Integer.parseInt(br.readLine());
		if((Y%4==0 && Y%100!=0) || Y%400==0) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
