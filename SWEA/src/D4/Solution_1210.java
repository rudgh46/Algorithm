package D4;
import java.util.Scanner;

/*
  [제약 사항]
한 막대에서 출발한 가로선이 다른 막대를 가로질러서 연속하여 이어지는 경우는 없다.

  [입력]
입력 파일의 첫 번째 줄에는 테스트 케이스의 번호가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
총 10개의 테스트 케이스가 주어진다.
 */
public class Solution_1210 { //Ladder1

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int deltas[][] = { // 사다리 밑에서 부터 시작, 좌 우 상 으로 탐색
				{ 0, -1 }, { 0, 1 }, { -1, 0 } };

		for (int test = 1; test <= 10; test++) {
			int T = sc.nextInt();
			int r = 0; // 도착 행열 좌표
			int c = 0;
			int res = 0;
			int 사다리[][] = new int[100][100];

			for (int i = 0; i < 100; i++) { // 사다리 입력 후 도착지점 좌표 r,c에 저장
				for (int j = 0; j < 100; j++) {
					사다리[i][j] = sc.nextInt();
					if (사다리[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}

			while (true) {
				if (r == 0) { // 사다리가 최상단(r)일때의 c가 출발점의 x좌표, break로 탈출
					res = c;
					break;
				}

				for (int i = 0; i < 3; i++) {
					int dx = r + deltas[i][0];
					int dy = c + deltas[i][1];

					if (dx >= 0 && dx < 100 && dy >= 0 && dy < 100 && 사다리[dx][dy] == 1) { //사다리 타고 가면서 갔던곳 숫자를 바꿔주고 r,c 좌표 업데이트
						사다리[r][c] = 0;
						r = dx;
						c = dy;
					}
				}
			}
			System.out.println("#" + T + " " + res);
		}
	}

}
