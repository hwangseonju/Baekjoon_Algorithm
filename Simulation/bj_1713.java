package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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
		Student[] check = new Student[101];
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for(int s=0; s<S; s++) {
			int student = Integer.parseInt(st.nextToken());
			
			if(count<N) {
				if(check[student]==null) {
					count++;
					check[student] = new Student(s, student, 1);
				}else {
					check[student].cnt = check[student].cnt+1;
				}
			}else {
				if(check[student]!=null && check[student].cnt>0) {
					check[student].cnt = check[student].cnt+1;
				}else {
					Student current =null;
					while(true) {
						current = pq.poll();
						if(check[current.num].cnt==current.cnt && check[current.num].time == current.time) break;
					}
					check[current.num] = null;
					check[student] = new Student(s, student, 1);
				}
			}
			pq.add(check[student]);			
		}
		
		for(int s=0; s<check.length; s++) {
			if(check[s]!=null && check[s].cnt>0) {
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
