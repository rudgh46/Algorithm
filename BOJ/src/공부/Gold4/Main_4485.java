package 공부.Gold4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
  [입력]
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스의 첫째 줄에는 동굴의 크기를 나타내는 정수 N이 주어진다. (2 ≤ N ≤ 125) N = 0인 입력이 주어지면 전체 입력이 종료된다.
이어서 N개의 줄에 걸쳐 동굴의 각 칸에 있는 도둑루피의 크기가 공백으로 구분되어 차례대로 주어진다. 
도둑루피의 크기가 k면 이 칸을 지나면 k루피를 잃는다는 뜻이다. 여기서 주어지는 모든 정수는 0 이상 9 이하인 한 자리 수다.

[출력]
각 테스트 케이스마다 한 줄에 걸쳐 정답을 형식에 맞춰서 출력한다. 형식은 예제 출력을 참고하시오.
 */
public class Main_4485 { //녹색 옷 입은 애가 젤다지?

	static int deltas[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Vertex implements Comparable<Vertex> {
		int x, y, cost;

		public Vertex(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		
		while (true) {

			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			int map[][] = new int[N][N];

			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] distance = new int[N][N];

			PriorityQueue<Vertex> PQ = new PriorityQueue<Vertex>();

			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			distance[0][0] = map[0][0];
			PQ.offer(new Vertex(0, 0, map[0][0]));

			while (!PQ.isEmpty()) {
				Vertex current = PQ.poll();

				if (current.x == N - 1 && current.y == N - 1) {
					System.out.println("Problem " + tc + ": " + current.cost);
					tc++;
					break;
				}

				for (int d = 0; d < 4; d++) {
					int dx = current.x + deltas[d][0];
					int dy = current.y + deltas[d][1];
					if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
						if (distance[dx][dy] > distance[current.x][current.y] + map[dx][dy]) {
							distance[dx][dy] = distance[current.x][current.y] + map[dx][dy];
							PQ.add(new Vertex(dx, dy, distance[dx][dy]));
						}
					}
				}
			}
		}
	}
}
