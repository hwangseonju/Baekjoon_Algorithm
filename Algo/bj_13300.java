package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_13300 {

	static int N; // 참가 전체 수
	static int K; // 최대 인원수
	static int[][] student = new int[7][2];	// 1~6학년 남,여 인원수
	static int room = 0;	// 최소 방 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 방 배정
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());		// 성별(0=여자, 1=남자)
			int grade = Integer.parseInt(st.nextToken());	// 학년
			if(s==0) {
				student[grade][0]++;
			}else{
				student[grade][1]++;
			}
		}
		
		// 방 개수 구하기
		for(int r=0; r<student.length; r++) {
			for(int c=0; c<student[r].length; c++) {
				if(student[r][c]>0) {
					room += (student[r][c]/K);
					if(student[r][c]%K>0) {	// K인원의 배수의 값보다 많거나 K인원보다 적을 경우 방이 1개가 필요함
						room++;
					}
				}
			}
		}
		
		System.out.println(room);
	}
}
