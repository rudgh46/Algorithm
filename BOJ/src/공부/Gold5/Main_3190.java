package 공부.Gold5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_3190 {

	static int map[][];
	static int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static List<int[]> snake;
	static int N,L,ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		int K = sc.nextInt();
		for(int i=0; i<K; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			map[R-1][C-1] = -1;
		}
		
		L = sc.nextInt();
		int dir[][] = new int[L][2];
		for(int i=0; i<L; i++) {
			dir[i][0] = sc.nextInt();
			char C = sc.next().charAt(0);
			if(C == 'D') dir[i][1] = 1;
			else dir[i][1] = -1;
		}
		
		snake = new LinkedList<>();
		snake.add(new int[] {0,0});
		int ans = go(0,0,0,dir);
		
		System.out.println(ans);
	}

	private static int go(int r, int c, int d, int[][] dir) {
		int time = 0;
		int turn = 0;
		
		while(true) {
			time++;
			int dx = r + deltas[d][0];
			int dy = c + deltas[d][1];
			
			if(dx<0 || dy<0 || dx>=N || dy>=N) break;
			
			if(check(dx,dy)) break;
			
			if(map[dx][dy] == -1) {
				snake.add(new int[] {dx,dy});
			}else {
				snake.add(new int[] {dx,dy});
				snake.remove(0);
			}
			
			r = dx;
			c = dy;
			
			if(turn<L) {
				if(time == dir[turn][0]) {
					d = (d+dir[turn][1])%4;
					if(d == -1) d = 3;
					turn++;
				}
			}
		}
		return time;
	}
	
	private static boolean check(int dx, int dy) {
		for(int i=0; i<snake.size(); i++) {
			int s[] = snake.get(i);
			if(s[0] == dx && s[1] == dy) return true;
		}
		
		return false;
	}

}
