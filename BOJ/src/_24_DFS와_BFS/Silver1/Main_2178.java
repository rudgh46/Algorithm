package _24_DFS와_BFS.Silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
  [입력]
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

  [출력]
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 */
public class Main_2178 {//미로탐색

	static int N,M,map[][];
	static boolean visit[][];
	static int deltas[][] = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		visit = new boolean[N][M];
		visit[0][0] = true;
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
		
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nX = now[0];
			int nY = now[1];
			
			for(int d=0; d<4; d++) {
				int dx = nX + deltas[d][0];
				int dy = nY + deltas[d][1];
				
				if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
				if(visit[dx][dy] || map[dx][dy] == 0) continue;
				
				q.add(new int[] {dx,dy});
				map[dx][dy] = map[nX][nY] +1;
				visit[dx][dy] = true;
			}
		}
	}

}
