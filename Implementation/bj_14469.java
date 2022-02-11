import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_14469 {

	static int N;	// 소 마리수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 소가 길을 건너간 이유 3
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Cow> pq = new PriorityQueue<>();

		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		long time=0;
		while(!pq.isEmpty()) {
			Cow current = pq.poll();
			time = (time<current.in)? current.in+current.check:time+current.check;
		}
		System.out.println(time);
	}
	
	static class Cow implements Comparable<Cow>{
		int in, check;	// in:도착한 시간, check:검문시간

		public Cow(int in, int check) {
			super();
			this.in = in;
			this.check = check;
		}

		@Override
		public int compareTo(Cow o) {
			return Integer.compare(this.in, o.in);
		}
	}
}
