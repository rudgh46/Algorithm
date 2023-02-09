package 공부.Gold5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  [입력]
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
둘째 줄부터 N개 줄에는 그림이 주어진다.

  [출력]
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
 */
public class Main_10026 {//적록색약
	static int deltas[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map, map2;
	static boolean[][] visit, visit2;
	static int N, cnt, cnt2;

	public static void main(String[] args) throws IOException {
//		================================  입력   ======================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N]; //적록색약 X
		map2 = new char[N][N]; //적록색약 O
		visit = new boolean[N][N]; //적록색약 X
		visit2 = new boolean[N][N]; //적록색약 O
		int cnt = 0, cnt2 = 0; //구역 수

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);

				if (line.charAt(j) == 'G')
					map2[i][j] = 'R';
				else
					map2[i][j] = line.charAt(j);
			}
		}

//		================================  풀이   ======================================
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) { //적록색약 X
					dfs(i, j, visit, map, map[i][j]);
					cnt++;
				}
				if (!visit2[i][j]) { //적록색약 O
					dfs(i, j, visit2, map2, map2[i][j]);
					cnt2++;
				}
			}
		}

//		================================  출력   ======================================
		System.out.println(cnt + " " + cnt2);

	}

//	======================================= dfs ==========================================
	private static void dfs(int r, int c, boolean visit[][], char map[][], char color) {
		visit[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int dx = r + deltas[d][0];
			int dy = c + deltas[d][1];

			//범위체크, 방문체크, 색 체크
			if (dx >= 0 && dy >= 0 && dx < N && dy < N && !visit[dx][dy] && map[dx][dy] == color) {
				dfs(dx, dy, visit, map, color);
			}
		}

	}

}
