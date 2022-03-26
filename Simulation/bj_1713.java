import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1713 {
	
	static int N;	// 사진 틀
	static int S;	// 추천 횟수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 후보 추천하기
		N = Integer.parseInt(br.readLine());
		S = Integer.parseInt(br.readLine());
		
		PriorityQueue<Student> pq = new PriorityQueue<>();
		int[] check = new int[101];
		st = new StringTokenizer(br.readLine());
		for(int s=0; s<S; s++) {
			int student = Integer.parseInt(st.nextToken());
			int size = pq.size();
			
			if(check[student]>0) {
				check[student]++;
				Queue<Student> temp = new LinkedList<>();
				while(true) {
					Student update = pq.poll();
					if(update.num==student) {
						pq.add(new Student(update.time, student, check[student]));
						while(!temp.isEmpty()) {
							pq.add(temp.poll());
						}
						break;
					}else {
						temp.add(update);
					}
				}
			}else {
				if(size>=N) {
					Student out = pq.poll();
					check[out.num] = 0;
				}
				check[student] = 1;
				pq.add(new Student(s, student, 1));
			}
		}
		
		for(int s=0; s<check.length; s++) {
			if(check[s]>0) {
				sb.append(s).append(" ");
			}
		}
		System.out.println(sb);	
	}
	
	static class Student implements Comparable<Student>{
		int time, num, cnt;

		public Student(int time, int num, int cnt) {
			super();
			this.time = time;
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Student o) {
			if(this.cnt==o.cnt) {
				return Integer.compare(this.time, o.time);
			}
			return Integer.compare(this.cnt, o.cnt);
		}
	}
}
