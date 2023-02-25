package 공부.Silver5;

import java.util.Scanner;

/*
  [입력]
첫째 줄부터 다섯째 줄까지 빙고판에 쓰여진 수가 가장 위 가로줄부터 차례대로 한 줄에 다섯 개씩 빈 칸을 사이에 두고 주어진다. 
여섯째 줄부터 열째 줄까지 사회자가 부르는 수가 차례대로 한 줄에 다섯 개씩 빈 칸을 사이에 두고 주어진다. 
빙고판에 쓰여진 수와 사회자가 부르는 수는 각각 1부터 25까지의 수가 한 번씩 사용된다.

  [출력]
첫째 줄에 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지 출력한다.
 */
public class Main_2578 { //빙고

	static int map[][], bingo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		bingo = 0;

		for (int k = 1; k <= 25; k++) {
			int check = sc.nextInt();

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == check) {
						map[i][j] = -9;
					}
				}
			}

			checkL();
			checkR();
			checkLRDown();
			checkRLDown();

			if(bingo>=3) {
				System.out.println(k);
				break;
			}
			bingo = 0;
		}

	}

	private static void checkRLDown() {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {

			if (map[i][4-i] == -9) {
				cnt++;
			}
			
			if (cnt == 5) {
				bingo++;
			}
		}
	}

	private static void checkLRDown() {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {

			if (map[i][i] == -9) {
				cnt++;
			}
			
			if (cnt == 5) {
				bingo++;
			}
		}
	}

	private static void checkR() {
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (map[j][i] == -9) {
					cnt++;
				}
			}
			if (cnt == 5) {
				bingo++;
			}
		}
	}

	private static void checkL() {
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == -9) {
					cnt++;
				}
			}
			if (cnt == 5) {
				bingo++;
			}
		}
	}

}
