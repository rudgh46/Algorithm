package 공부.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫줄에는 주사위의 개수가 입력된다. 
그 다음 줄부터는 한 줄에 하나씩 주사위의 종류가 1번 주사위부터 주사위 번호 순서대로 입력된다. 
주사위의 종류는 각 면에 적혀진 숫자가 그림1에 있는 주사위의 전개도에서 A, B, C, D, E, F 의 순서로 입력된다. 
입력되는 숫자 사이에는 빈 칸이 하나씩 있다. 
주사위의 개수는 10,000개 이하이며 종류가 같은 주사위도 있을 수 있다.

  [출력]
첫줄에 한 옆면의 숫자의 합이 가장 큰 값을 출력한다.
 */
public class Main_2116 { // 주사위 쌓기

	static int N, dice[][], ans;
	static int idx[] = { 0, 6, 4, 5, 2, 3, 1 };
	static boolean[][] used;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		dice = new int[N][7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		stackDice();

		System.out.println(ans);
	}

	private static void stackDice() {
		int up = 0;

		for (int num = 1; num <= 6; num++) { //1번 주사위의 윗 면이 1~6일 경우
			used = new boolean[N][7];

			for (int i = 1; i <= 6; i++) { //숫자 인덱스 찾고 up에 저장
				if (dice[0][i] == num) {
					up = dice[0][i];

					used[0][i] = used[0][idx[i]] = true; //윗면 아랫면 체크
					break;
				}
			}

			for (int i = 1; i < N; i++) { //1번 주사위 정해지면 위에 쌓기
				for (int j = 1; j <= 6; j++) { //숫자 인덱스 찾고 up에 맞은편 숫자 저장
					if (dice[i][j] == up) {
						up = dice[i][idx[j]];

						used[i][j] = used[i][idx[j]] = true;
						break;
					}
				}
			}

			ans = Math.max(ans, sum());
		}

	}

	private static int sum() { //옆면 최대값
		int sum = 0;

		for (int i = 0; i < N; i++) {
			int max = 0;

			for (int j = 1; j <= 6; j++) {//가장 큰 면 찾고 누적시키기
				if (!used[i][j]) {
					max = Math.max(max, dice[i][j]);
				}
			}
			sum += max;
		}
		return sum;
	}

}
