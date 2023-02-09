package D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N (1 ≤ N ≤ 103)이 주어진다.
다음 N개의 줄에는 i번째 줄에는 N개의 정수 Ai, 1, … , Ai, N (1 ≤ Ai, j ≤ N2) 이 공백 하나로 구분되어 주어진다.
Ai, j는 모두 서로 다른 수이다.
 */
public class Solution_1861 { // 정사각형 방
	
	static int deltas[][] = { //탐색용
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}};
	static int square[][]; //사각형 배열
	static boolean visit[][]; //방문 확인용
	static int N,max,first; //사각형 크기, 방 이동 최대수, 방 이동 출발점

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트케이스
		
		for(int test = 1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());//사각형 크기
			square = new int[N][N]; //사각형 배열
			visit = new boolean[N][N]; //방문확인 배열
			max = 0; //방 이동 최대수
			first = 0; //방 이동 출발점
			for(int i=0; i<N; i++) {//사각형 배열 입력
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					square[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dfs(i, j, square[i][j], 1); //dfs 탐색, 출발점 번호, 방 이동 개수
				}
			}
			System.out.println("#"+test+" "+first+" "+max);
		}

	}

	public static void dfs(int i, int j, int start, int count) {
		visit[i][j] = true;
		
		for(int d=0; d<4; d++) {
			 int dx = i + deltas[d][0];
			 int dy = j + deltas[d][1];
			 
			 if(dx>=0 && dy>=0 && dx<N && dy<N) {
				 if(!visit[dx][dy] && (square[i][j] + 1 == square[dx][dy])) {
					 dfs(dx, dy, start, ++count);
					
				 }
			 }
		}
		
		if(count > max) { //max, first 업데이트
			max = count;
			first = start;
		}
		if(count == max) {//같을경우 작은것으로 업데이트 
			first = Math.min(first, start);
		}
		
		visit[i][j] = false;
		
	}

}
