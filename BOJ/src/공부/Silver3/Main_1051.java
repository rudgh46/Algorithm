package 공부.Silver3;

import java.util.Scanner;

public class Main_1051 { // 숫자 정사각형

	public static void main(String[] args) {
//		=================  입력   ================
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String line;
		int square[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			line = sc.next();
			for (int j = 0; j < M; j++) {
				square[i][j] = line.charAt(j) - '0';
			}
		}

//		=================  풀이   ================
		int res = 1; //초기 사각형 변 크기
		int size = Math.min(N, M); //정사각형을 만들기 위해 직사각형의 짧은 변 선택

		for (int i = 2; i <= size; i++) { //사각형 크기별로 탐색
			for (int j = 0; j < N - i + 1; j++) { //사각형 크기씩 탐색
				for (int k = 0; k < M - i + 1; k++) {
					if (square[j][k] == square[j + i - 1][k] && square[j][k] == square[j][k + i - 1] //사각형 각 꼭지점이 같으면
							&& square[j][k] == square[j + i - 1][k + i - 1]) {
						if (res < i) { //변 크기 업데이트 
							res = i;
						}
					}
				}

			}
		}
		
//		=================  출력   ================
		System.out.println(res * res);
		sc.close();
	}

}
