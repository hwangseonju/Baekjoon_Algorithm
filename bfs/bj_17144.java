package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17144 {

	static int R; // 방 가로
	static int C; // 방 세로
	static int T; // 시간
	static int[][] dust; // 미세먼지
	static List<Dust> list; // 미세먼지 위치
	static int total; // 방에 있는 미세먼지 양
	static int top = -1; // 위쪽 공기청정기 - 행
	static int bottom = -1; // 아래쪽 공기청저기 - 행
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 미세먼지 안녕!
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		dust = new int[R][C];
		list = new ArrayList<>();

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				dust[r][c] = Integer.parseInt(st.nextToken());
				if (dust[r][c] > 0) { // 미세먼지 위치 저장
					list.add(new Dust(r, c, dust[r][c]));
					dust[r][c] = 0; // 확산된 미세먼지로 값을 뿌려주기 위해 위치만 저장
				}

				if (dust[r][c] == -1) { // 공기청정기 위치 저장
					if (top == -1) { // 먼저 입력된 줄이 위쪽
						top = r;
					} else { // 나중에 입력된 줄이 아래쪽
						bottom = r;
					}
				}
			}
		}

		bfs();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(dust[i][j]>0) {
					total += dust[i][j];
				}
			}
		}

		System.out.println(total);
	}

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// 미세먼지 확산
	static void bfs() {
		Queue<Dust> queue = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			queue.offer(list.get(i));
		}
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			if (T == 0) {
				return;
			}
			
			// 다시 미세먼지 확산을 위해 0으로 값 초기화
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(dust[i][j]>0) {
						
						dust[i][j]=0;
					}
				}
			}
			
			while (size-- > 0) {
				int div = 0; // 미세먼지가 확산된 정도(A(r,c)에서 몇군데로 나눠졌는지 확인)
				Dust head = queue.poll();

				for (int d = 0; d < deltas.length; d++) {
					int nr = head.x + deltas[d][0];
					int nc = head.y + deltas[d][1];

					if (isIn(nr, nc) && dust[nr][nc] != -1) {
						++div;
						dust[nr][nc] += head.w / 5;
					}
				}
				dust[head.x][head.y] += head.w - ((head.w / 5) * div);
			}

			--T;
			
			airClean();
			
			// 미세먼지 확산 + 공기청정기 가동 후의 위치값을 큐에 저장
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(dust[i][j]>0) {
						queue.offer(new Dust(i, j, dust[i][j]));
					}
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static int[][] topMove = {{ -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }}; 	// 위쪽 공기청정기 - 상우하좌
	static int[][] bottomMove = { { 1, 0 }, { 0, 1 },{ -1, 0 }, { 0, -1 } }; // 아래쪽 공기청정기 - 하우상좌

	// 공기청정기 가동
	static void airClean() {

		int d = 0; // 방향
		int r = top; // 행
		int c = 0; // 열
		
		// 위쪽 - 반시계 방향 회전
		while (d < 4) {
			int nr = r + topMove[d][0];
			int nc = c + topMove[d][1];
			if (nr>=0 && nr<=top && nc>=0 && nc<C) {
				if(dust[r][c]==-1) {
					dust[r][c]=-1;
				}else if(dust[nr][nc] == -1){
					dust[r][c]=0;
				}else {
					dust[r][c] = dust[nr][nc];
				}
				r = nr;
				c = nc;
			} else {
				d++;
			}
		}
		
		d = 0;
		r = bottom;
		
		// 아래쪽 - 시계 방향 회전
		while (d < 4) {
			int nr = r + bottomMove[d][0];
			int nc = c + bottomMove[d][1];
			if (nr>=bottom && nr<R && nc>=0 && nc<C) {
				if(dust[r][c]==-1) {
					dust[r][c]=-1;
				}else if(dust[nr][nc] == -1){
					dust[r][c]=0;
				}else {
					dust[r][c] = dust[nr][nc];
				}
				r = nr;
				c = nc;
			} else {
				d++;
			}
		}
	}

	static class Dust {
		int x, y, w;

		public Dust(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
}
