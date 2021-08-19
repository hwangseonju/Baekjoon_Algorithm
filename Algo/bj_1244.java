import java.util.Scanner;

public class bj_1244 {

	public static void main(String[] args) {
		// 스위치 켜고 끄기
		Scanner scan = new Scanner(System.in);
		int S = scan.nextInt(); // 스위치
		int[] state = new int[S]; // 스위치 상태
		for (int i = 0; i < state.length; i++) {
			state[i] = scan.nextInt();
		}

		int student = scan.nextInt();
		int person[] = new int[2];
        
        // 학생 수만큼 실행
		for (int i = 0; i < student; i++) {
			person[0] = scan.nextInt();	// 성별
			person[1] = scan.nextInt();	// 받은 스위치 번호

			if (person[0] == 1) { 	// 남학생일때
            	// 배수이기 때문에 받은 스위치 번호 이전은 탐색이 필요하지않다.
				for (int num = person[1]; num <= S; num = num+person[1]) {
					state[num-1] = state[num-1] == 1 ? 0 : 1;
				}
			} else if(person[0]==2) {	// 여학생일때
				int left = person[1]-1;
				int right = person[1]+1;
				
				while(left>0 && right<=S && state[left-1]==state[right-1]) {
					int temp = state[left-1];
					if(temp==0) {
						state[left-1]=1;
						state[right-1]=1;
					} else {
						state[left-1]=0;
						state[right-1]=0;
					}
					left--;
					right++;
				}
				state[person[1]-1] = state[person[1]-1]==1?0:1;
			}
		}
		
		int count=0;
		for (int s = 0; s < S; s++) {
			count++;
			System.out.print(state[s]+" ");
			if(count%20==0) {	// 스위치는 한줄에 20개씩만 출력
				System.out.println();
			}
		}
	}
}