package etc.시뮬레이션.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {

	static int N,L,R,map[][];
	static boolean visit[][];
	static int deltas[][] = {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}};
	static ArrayList<People> people;
	
	public static class People{
		int x;
		int y;
		
		public People(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = move();
		System.out.println(ans);
	}

	private static int move() {
		int res = 0;
		while(true) {
			boolean moveCheck = false;
			visit = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j]) {
						int sum = bfs(i,j);
						
						if(people.size()>1) {
							change(sum);
							moveCheck = true;
						}
					}
				}
			}
			if(!moveCheck) return res;
			res++;
		}
	}

	private static void change(int sum) {
		// TODO Auto-generated method stub
		
	}

	private static int bfs(int x, int y) {
		Queue<People> q = new LinkedList<>();
		people = new ArrayList<>();
		
		q.offer(new People(x,y));
		people.add(new People(x,y));
		visit[x][y] = true;
		
		int sum = map[x][y];
		while(!q.isEmpty()) {
			People cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int dx = cur.x + deltas[d][0];
				int dy = cur.y + deltas[d][1];
				
				if(dx>=0 && dy>=0 && dx<N && dy<N && visit[dx][dy] != false) {
					int diff = Math.abs(map[cur.x][cur.y]- map[dx][dy]);
					if(L<=diff && R>=diff) {
						q.offer(new People(dx,dy));
						people.add(new People(dx,dy));
						sum += map[dx][dy];
						visit[dx][dy] = true;
					}
				}
			}
		}
		
		return sum;
	}

}
