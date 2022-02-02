import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_10825 {

	static int N;	// 학생수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// 국영수
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Student> pq = new PriorityQueue<>();
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll().name).append("\n");
		}

		System.out.println(sb);
	}
	
	static class Student implements Comparable<Student>{
		String name;
		int kor, eng, math;
		
		public Student(String name, int kor, int eng, int math) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if(this.kor==o.kor) {
				if(this.eng==o.eng) {
					if(this.math==o.math) {
						return this.name.compareTo(o.name);
					}
					return Integer.compare(o.math, this.math);
				}
				return Integer.compare(this.eng, o.eng);
			}
			return Integer.compare(o.kor, this.kor);
		}
	}
}
