package 공부.Silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [입력]
첫째 줄에 배열의 크기 N, M과 수행해야 하는 연산의 수 R이 주어진다.
둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.
마지막 줄에는 수행해야 하는 연산이 주어진다. 연산은 공백으로 구분되어져 있고, 문제에서 설명한 연산 번호이며, 순서대로 적용시켜야 한다.
  [제한]
2 ≤ N, M ≤ 100
1 ≤ R ≤ 1,000
N, M은 짝수
1 ≤ Aij ≤ 108
 */
public class Main_16935 { // 배열 돌리기3
	static int map2[][];
	static int num = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 배열 행
		int M = Integer.parseInt(st.nextToken()); // 배열 열
		int map[][] = new int[N][M]; // 배열

		int R = Integer.parseInt(st.nextToken()); // 연산 횟수
		int temp = 0; // 배열 90도 회전시 N,M 바꿔줄 임시장소

		for (int i = 0; i < N; i++) { // 배열 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < R; i++) {
			num = Integer.parseInt(st.nextToken()); // 수행해야 하는 연산 번호

			if (num == 1) { // 상하 반전
				map2 = new int[N][M];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						map2[N - r - 1][c] = map[r][c];
					}
				}

				map = map2; // map을 저장해줘야 다음 연산할때 저장된 맵으로 됨

			} else if (num == 2) { // 좌우 반전

				map2 = new int[N][M];

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						map2[r][M - c - 1] = map[r][c];
					}
				}

				map = map2;

			} else if (num == 3) { // 90도 회전

				map2 = new int[M][N];

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						map2[c][N - 1 - r] = map[r][c];
					}
				}

				temp = N; // 행 열이 바뀌기 때문에 N,M 숫자 바꿔야함
				N = M;
				M = temp;
				map = map2;

			} else if (num == 4) { // -90도 회전

				map2 = new int[M][N];

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						map2[M - 1 - c][r] = map[r][c];
					}
				}

				temp = N; // 행 열이 바뀌기 때문에 N,M 숫자 바꿔야함
				N = M;
				M = temp;
				map = map2;

			} else if (num == 5) { // 1->2, 2->3, 3->4, 4->1 이동, 배열을 4등분으로 쪼개서 시계방향으로 돌리기

				map2 = new int[N][M];

				// 행 열 중앙값으로 쪼개서 범위 설정
				for (int r = 0; r < N / 2; r++) { // 1->2
					for (int c = 0; c < M / 2; c++) {
						map2[r][M / 2 + c] = map[r][c];
					}
				}

				for (int r = 0; r < N / 2; r++) { // 2->3
					for (int c = M / 2; c < M; c++) {
						map2[N / 2 + r][c] = map[r][c];
					}
				}

				for (int r = N / 2; r < N; r++) { // 3->4
					for (int c = M / 2; c < M; c++) {
						map2[r][c - M / 2] = map[r][c];
					}
				}

				for (int r = N / 2; r < N; r++) { // 4->1
					for (int c = 0; c < M / 2; c++) {
						map2[r - N / 2][c] = map[r][c];
					}
				}

				map = map2;
			} else if (num == 6) { // 1->4, 4->3, 3->2, 2->1 이동, 배열을 4등분으로 쪼개서 반시계방향으로 돌리기

				map2 = new int[N][M];

				// 행 열 중앙값으로 쪼개서 범위 설정
				for (int r = 0; r < N / 2; r++) { // 1->4
					for (int c = 0; c < M / 2; c++) {
						map2[N / 2 + r][c] = map[r][c];
					}
				}

				for (int r = N / 2; r < N; r++) { // 4->3
					for (int c = 0; c < M / 2; c++) {
						map2[r][M / 2 + c] = map[r][c];
					}
				}

				for (int r = N / 2; r < N; r++) { // 3->2
					for (int c = M / 2; c < M; c++) {
						map2[r - N / 2][c] = map[r][c];
					}
				}

				for (int r = 0; r < N / 2; r++) { // 2->1
					for (int c = M / 2; c < M; c++) {
						map2[r][c - M / 2] = map[r][c];
					}
				}
			}

			map = map2;
		}
		StringBuilder sb = new StringBuilder();

		if (num != 3 || num != 4) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(map2[i][j]).append(" ");
				}
				sb.append("\n");
			}
		} else {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map2[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

}
