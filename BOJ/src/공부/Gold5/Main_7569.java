package 공부.Gold5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
  [입력]
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 
둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 
하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 
정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
토마토가 하나 이상 있는 경우만 입력으로 주어진다.

  [출력]
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 */
public class Main_7569 { //토마토 (3차원)

	static int deltas[][] = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } }; // 상 하 좌 우 위 아래

	public static void main(String[] args) throws IOException {
//		===============================  입력   ===================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); //가로
		int N = Integer.parseInt(st.nextToken()); //세로
		int H = Integer.parseInt(st.nextToken()); //높이
		int max = 0;

		int map[][][] = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

//		===============================  풀이   ===================================
		bfs(map, H, N, M);

//		===============================  출력   ===================================
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) { // 토마토가 못익었으면 -1
						System.out.println(-1);
						return;
					}
					max = Math.max(max, map[i][j][k]); // 마지막 날짜 저장
				}
			}
		}
		System.out.println(max - 1); // 마지막 날짜 출력(n일차 일때 map에는 n+1이 찍히니까 -1을 해줌)
	}

//	=======================  bfs  =======================
	private static void bfs(int[][][] map, int h, int n, int m) {
		Queue<Current> queue = new LinkedList<Current>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 1) { // 익은 토마토 위치 저장하기
						queue.add(new Current(i, j, k));
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			Current cur = queue.poll();

			for (int d = 0; d < 6; d++) {
				int dz = cur.z + deltas[d][0];
				int dx = cur.x + deltas[d][1];
				int dy = cur.y + deltas[d][2];

				if (dx >= 0 && dy >= 0 && dx < n && dy < m && dz >= 0 && dz < h && map[dz][dx][dy] == 0) { // 다음위치 토마토가
																											// 익지 않았으면
					map[dz][dx][dy] = map[cur.z][cur.x][cur.y] + 1; // 날짜를 구해야 하므로 +1 해줌 (하루씩 증가)
					queue.add(new Current(dz, dx, dy));
				}
			}
		}
	}

//	=======  Current  =======
	static class Current {
		int z;
		int x;
		int y;

		public Current(int z, int x, int y) {
			super();
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
}
