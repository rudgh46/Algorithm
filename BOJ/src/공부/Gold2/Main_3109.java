package 공부.Gold2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [입력]
첫째 줄에 R과 C가 주어진다. (1 ≤ R ≤ 10,000, 5 ≤ C ≤ 500)
다음 R개 줄에는 빵집 근처의 모습이 주어진다. '.'는 빈 칸이고, 'x'는 건물이다. 처음과 마지막 열은 항상 비어있다.

  [출력]
첫째 줄에 원웅이가 놓을 수 있는 파이프라인의 최대 개수를 출력한다. 
 */
public class Main_3109 {//빵집

	static int R,C,ans;
	static char map[][];
	static int deltas[][] = { //우상, 우, 우하 탐색
			{-1,1},
			{0,1},
			{1,1}};
	
	public static void main(String[] args) throws IOException {
//		================================  입력   ===================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		ans = 0;
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
//		================================  풀이   ===================================
		for (int i = 0; i < R; i++) {
			dfs(i,0); //i행 부터 검사
		}
		
//		================================  출력   ===================================
		System.out.println(ans);
		
	}

//	================================  dfs  ===================================
	public static boolean dfs(int r, int c) {
		
		if(c == C-1) { //마지막 열 도착하면 
			ans++;
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int dx = r+deltas[i][0];
			int dy = c+deltas[i][1];
			
			if(dx>=0 && dx<R && dy>=0 && dy<C) { //범위체크, 못가는곳 체크 후  x 표시해줘서 방문체크
				if(map[dx][dy] !='x') {
					map[dx][dy] = 'x';
					if(dfs(dx,dy)) return true; //파이프 놓기 성공하면 리턴
				}
			}
		}
		return false; //파이프 놓기 실패
		
		
		
	}
	
}
