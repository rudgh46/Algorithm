package 공부.Gold4;
import java.util.HashSet;
import java.util.Scanner;

public class Main_1987 {//알파벳

	static char[][] map;
	static boolean[][] visit;
	static int R,C,ans;
	static HashSet<Character> set;

	static int deltas[][] = {
			{-1,0},
			{0,1},
			{0,-1},
			{1,0}};
	
	public static void main(String[] args) {
//		=================  입력   ================
		Scanner sc = new Scanner(System.in);
		set = new HashSet<>();
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			map[i] = sc.next().toCharArray();
		}
		
//		=================  풀이   ================
		dfs(0, 0, 1);
		
//		=================  출력   ================
		System.out.println(ans);
	}
	
//	===================  dfs  ======================
	private static void dfs(int r, int c, int d) {
		int size = set.size();	//0
		set.add(map[r][c]);		//1
		
		if(size == set.size())	//중복된 데이터 입력되었으면
			return;
		
		if(ans<d) ans = d;	//이동한 거리 값
		visit[r][c] = true;
		int dx,dy;
		
		for(int i=0; i<4; i++) {
			dx = r+deltas[i][0];
			dy = c+deltas[i][1];
			if(dx>=0 && dx<R && dy>=0 && dy<C) 
				if(!visit[dx][dy])
					dfs(dx,dy,d+1);
			
		}
		
		set.remove(map[r][c]);
		visit[r][c] = false;
		
	}

}
