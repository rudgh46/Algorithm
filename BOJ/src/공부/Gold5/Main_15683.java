package 공부.Gold5;
import java.util.Scanner;

/*
  [입력]
첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)
둘째 줄부터 N개의 줄에는 사무실 각 칸의 정보가 주어진다. 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다. 
CCTV의 최대 개수는 8개를 넘지 않는다.

  [출력]
첫째 줄에 사각 지대의 최소 크기를 출력한다.
 */
public class Main_15683 { //감시

	static int N,M,cnt,res;
	static int deltas[][] = {
			{-1,0}, //상
			{1,0},	//하
			{0,-1},	//좌
			{0,1}};	//우
	static int cctv[][][] = {
			{{0}}, //0번 (사용안함)
			{{0},{1},{2},{3}},	//1번 cctv
			{{0,1},{2,3}},	//2번 cctv
			{{0,2},{0,3},{1,2},{1,3}},	//3번 cctv
			{{0,2,3},{0,1,2},{0,1,3},{1,2,3}},	//4번 cctv
			{{0,1,2,3}}};	//5번 cctv
	
	static CCTV[] cctvs;
	
	public static void main(String[] args) {
//		====================  입력   =====================
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int map[][] = new int[N][M];
		cctvs = new CCTV[8];
		res = Integer.MAX_VALUE;
		
		int blank = N*M; //빈 공간 수
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				
//		====================  풀이   =====================
				if(map[i][j] >=1 && map[i][j]<=5) { //cctv인 경우
					cctvs[cnt++] = new CCTV(map[i][j], i, j);  //cctv 정보
				}
				else if(map[i][j] == 6) { //벽인경우
					blank--; // 벽 빼주기
				}
			}
		}
		
		check(0, blank-cnt, map); //blank - cnt : 빈 공간(cctv 빼준 값)
		
//		====================  출력   =====================
		System.out.println(res);

	}
	
//	==========================  check  ============================
	private static void check(int idx, int blank, int[][] map) {
		if(idx == cnt) { //cctv 다 확인한 경우
			res = Math.min(res, blank); // 사각지대 최소 값 업데이트
			
			return;
		}
		
		int map2[][] = new int[N][M];
		copy(map2,map);
		
		CCTV cc = cctvs[idx];
		
		for(int i = 0; i<cctv[cc.type].length; i++) { //cctv 감시, 감시 가능한 곳 감시
			int check = 0;
			
			for(int j = 0; j<cctv[cc.type][i].length; j++) { //감시 방향
				int d = cctv[cc.type][i][j];
				check += 감시(cc.r, cc.c, d, map2);
			}
			
			check(idx+1,blank-check,map2);
			
			copy(map2,map); //map 상태 복원 (다른방향 체크 때문)
		}
		
	}



//	==========================  감시  ============================
	public static int 감시(int r, int c, int d, int map[][]) {
		
		int cnt = 0;
		while(true) {
			r += deltas[d][0];
			c += deltas[d][1];
			
			
			if(r<0 || r>=N || c<0 || c>=M || map[r][c] == 6) return cnt; //범위 밖, 벽 있음
			
			if((map[r][c] >= 1 && map[r][c] < 6) || map[r][c] == -1) continue; //다른 cctv 있거나 이미 감시한 곳
			
			map[r][c] = -1; //빈칸이면
			cnt++;
			
			
			
		}
	}
//	====================  copy  ======================
	public static void copy(int map2[][], int map[][]){
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map2[i][j] = map[i][j];
			}
		}
	}
	
//	=============== CCTV ===============
	public static class CCTV {
		int type, r, c;
		public CCTV(int type, int r, int c) {
			this.type = type;
			this.c = c;
			this.r = r;
		}
	}
	
}
