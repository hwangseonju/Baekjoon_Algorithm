package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_3055 {

	static int R; // 행
	static int C; // 열
	static char[][] map; // 숲
	static boolean[][] visited; // 방문여부
	static XY D; // 비버 집 위치
	static List<XY> water; // 물위치 저장
	static int time; // 최소 소요시간
	static Queue<XY> Squeue = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 탈출
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		water = new ArrayList<>();

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == 'X')	// 돌멩이 위치
					visited[r][c] = true;
				if (map[r][c] == '*')	// 물 위치
					water.add(new XY(r, c));
				if (map[r][c] == 'S') { // 고슴도치 시작 위치(출발지)
					Squeue.offer(new XY(r, c));
					visited[r][c] = true;
				}
				if (map[r][c] == 'D')
					D = new XY(r, c); // 비버의 굴(도착지)
			}
		}
		time = 0;
		flood();
	}

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// 물 차오름(bfs)
	static void flood() {
		Queue<XY> queue = new LinkedList<>();
		int watersize = water.size();
		for (int ws = 0; ws < watersize; ws++) {
			queue.offer(new XY(water.get(ws).x, water.get(ws).y));
			visited[water.get(ws).x][water.get(ws).y] = true;
		}

		int size = queue.size();

		while (size-- > 0) {
			XY current = queue.poll();
			int a = current.x;
			int b = current.y;

			for (int d = 0; d < 4; d++) {
				int nr = a + deltas[d][0];
				int nc = b + deltas[d][1];

				if (isIn(nr, nc) && !visited[nr][nc]) {
					if (nr == D.x && nc == D.y) {
						continue;
					}
					visited[nr][nc] = true;
					water.add(new XY(nr, nc));
				}
			}
		}
		go();
	}

	// 고슴도치 움직이기
	static void go() {
		int size = Squeue.size();
		while (size-- > 0) {
			XY head = Squeue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = head.x + deltas[d][0];
				int nc = head.y + deltas[d][1];

				if (nr == D.x && nc == D.y) { // 비버집 도착
					System.out.println(time + 1);	// 도착지까지 가는 1분 더하기
					return;
				}

				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'o') {	// 문자 o는 임시방문으로 표시해서 반복된 곳이 큐에 들어오지않도록 함
					Squeue.offer(new XY(nr, nc));
					map[nr][nc] = 'o';
				}
			}
		}

		if (Squeue.isEmpty()) {	// 큐가 비어있다 = 더이상 갈 곳이 없다
			System.out.println("KAKTUS");
			return;
		}
		time++;
		flood();
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static class XY {
		int x, y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
