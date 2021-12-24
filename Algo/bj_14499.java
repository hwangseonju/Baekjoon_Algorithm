import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class bj_14499 {
	
	static int N;	// 세로
	static int M;	// 가로
	static int k;	// 명령 개수
	static int[][] map;	//지도
	static Queue<Integer> queue;	// 명령
	static int[] current;	// 현재 주사위 상태(위,뒤,오른쪽,왼쪽,앞,아래)
	static int[] before;	// 이전 주사위 상태
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 주사위 굴리기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		// 주사위 시작 좌표
		Dot start = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		k = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int q=0; q<k; q++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		before = new int[6];
		current = new int[6];
		
		int[][] deltas = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};	// 0-움직임x,1-동,2-서,3-남,4-북
		while(!queue.isEmpty()) {
			int dir = queue.poll();		// 방향
			Dot dice = new Dot(start.r+deltas[dir][0], start.c+deltas[dir][1]);		// 주사위가 굴러갈 다음 위치(좌표)
			
			if(isIn(dice.r, dice.c)) {
				start = dice;
				switch(dir) {
				case 1:
					current[0] = before[3];
					current[2] = before[0];
					current[3] = before[5];
					current[5] = before[2];
					break;
				case 2:
					current[0] = before[2];
					current[2] = before[5];
					current[3] = before[0];
					current[5] = before[3];
					break;
				case 3:
					current[0] = before[1];
					current[1] = before[5];
					current[4] = before[0];
					current[5] = before[4];
					break;
				default:
					current[0] = before[4];
					current[1] = before[0];
					current[4] = before[5];
					current[5] = before[1];
				}
				
				if(map[dice.r][dice.c]!=0) {	// 지도 칸이 0이 아닐경우, 지도 칸의 값이 주사위 아래에 복사
					current[5] = map[dice.r][dice.c];
					map[dice.r][dice.c] = 0;
				}else {							// 지도 칸이 0일 경우, 주사위 아래가 지도에 복사
					map[dice.r][dice.c] = current[5];
				}
				
				for(int i=0; i<6; i++) {	// 배열 복사
					before[i] = current[i];
				}
				sb.append(current[0]).append("\n");
			}else {		// 지도 밖으로 나갈경우 명령전 위치에 존재해야함
				dice = start;
			}
		}
		System.out.println(sb);
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	// 현재 주사위 위치
	static class Dot{
		int r, c;

		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
