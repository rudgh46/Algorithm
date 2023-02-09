package D2;
import java.util.Scanner;

public class Solution_1974 { // 스도쿠 검증

	static int map[][], answer;
	
	public static void main(String[] args) {
//		=================  입력   =================
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			answer = 1;
			map = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}

//		=================  풀이   =================
			int sum1, sum2;

			for (int i = 0; i < 9; i++) { // 가로줄 세로줄 검사
				sum1 = 0;
				sum2 = 0;
				for (int j = 0; j < 9; j++) {
					sum1 += map[i][j];
					sum2 += map[j][i];
				}

				// 더한 값을 검사
				if (sum1 != 45 || sum2 != 45) {
					answer = 0;
					break;
				}
			}

			// 3*3 검사

				for (int i = 0; i < 6; i+=3) {
					for (int j = 0; j < 6; j+=3) {
						smallSquare(i,j);
					}
				}


//		=================  출력   =================
			System.out.println("#" + tc + " " + answer);
		}
	
	}

static void smallSquare(int r, int c) {

	int sum = 0;
	for(int i=r; i<r+3; i++) {
		for(int j=c; j<c+3; j++) {
			sum += map[i][j];
		}
	}
	if(sum !=45) answer = 0;
}
}
