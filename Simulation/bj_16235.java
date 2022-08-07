import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_16235 {
	
	static int N;	// 땅 크기
	static int M;	// 나무 개수
	static int K;	// 몇년 후
	static int[][] map;	// 땅
	static int[][] plus;	// 양분
	static HashMap<Dot, PriorityQueue<Integer>> trees;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		// 나무 재테크
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		plus = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0 ;c<N; c++) {
				plus[r][c] = Integer.parseInt(st.nextToken());
				map[r][c] = 5;
			}
		}
		
		trees = new LinkedHashMap<>();	// 위치(x,y) : key, 나이 : value
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			Dot tree = new Dot(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
			trees.put(tree, new PriorityQueue<>());;
			trees.get(tree).add(Integer.parseInt(st.nextToken()));
		}
		
		while(K-->0) {
			Spring();
		}
		
		System.out.println(trees.size());
	}
	
	static void Spring() {
		List<Tree> die = new LinkedList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				Dot current = new Dot(r,c);
				if(trees.containsKey(current)) {	
					List<Integer> temp = new LinkedList<>();
					for (int i = 0; i < trees.get(current).size(); i++) {
						int age = trees.get(current).poll();
						if (map[r][c] >= age) {
							map[r][c] -= age;
							temp.add(age + 1);
						} else {
							die.add(new Tree(r, c, (age / 2)));
						}
					}
					
					if(trees.)
					for (int t = 0; t < temp.size(); t++) {
						trees.get(new Dot(r, c)).add(temp.get(t));
					}
				}
			}
		}
		
		if(trees.size()==0) {
			K=0;
			return;
		}
		System.out.println("양분"+map[0][0]);
		System.out.println("봄"+trees.size());
		System.out.println("죽은 나무"+die.size());
		Summer(die);
	}
	
	static void Summer(List<Tree> die) {
		for(int d=0; d<die.size(); d++) {
			map[die.get(d).x][die.get(d).y] += die.get(d).a;
		}
		Autumn();
	}
	
	static void Autumn() {
		int[][] deltas = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]%5==0) {
					for(int d=0; d<deltas.length; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						
						if(isIn(nr,nc)){
							if(trees.containsKey(new Dot(nr,nc))) {
								trees.get(new Dot(nr, nc)).add(1);
							}else {
								trees.put(new Dot(nr,nc), new PriorityQueue<>());
								trees.get(new Dot(nr,nc)).add(1);
							}
						}
					}
				}
			}
		}
		Winter();
	}
	
	static void Winter() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] += plus[r][c];
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	static class Dot{
		int x, y;

		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Dot other = (Dot) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	
	static class Tree {
		int x,y,a;

		public Tree(int x, int y, int a) {
			super();
			this.x = x;
			this.y = y;
			this.a = a;
		}
	}
}
