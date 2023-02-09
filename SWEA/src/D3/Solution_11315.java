package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(5 ≤ N ≤ 20)이 주어진다.
다음 N개의 줄의 각 줄에는 길이 N인 문자열이 주어진다. 각 문자는 ‘o’또는 ‘.’으로, ‘o’는 돌이 있는 칸을 의미하고, ‘.’는 돌이 없는 칸을 의미한다.

  [출력]
각 테스트 케이스 마다 돌이 다섯 개 이상 연속한 부분이 있으면 “YES”를, 아니면 “NO”를 출력한다.
 */
public class Solution_11315 {//오목 판정

	static int deltas[][] = { //좌상 부터 시계방향으로 탐색 
			{-1, -1}, 
			{-1, 0}, 
			{-1, 1}, 
			{0, 1}, 
			{1, 1}, 
			{1, 0},
			{1, -1}, 
			{0, -1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
//		==============================  입력   =====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine()); //오목판 길이
			boolean check = false; //오목 가능한지 체크
			String line = "";
			
			char map[][] = new char[N][N]; //오목판 배열

			for (int i = 0; i < N; i++) {
				line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
				}
			}

//		==============================  풀이   =====================================
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'o') { //돌이면
						for (int d = 0; d < 8; d++) { //8방향 탐색
							for (int k = 1; k < 5; k++) { // 한 방향으로 4번 더 체크 (오목이 되는지 체크)
								
								//다음 좌표 업데이트
								int dx = i + deltas[d][0] * k;
								int dy = j + deltas[d][1] * k;

								if (dx < 0 || dy < 0 || dx >= N || dy >= N || map[dx][dy] != 'o') { //밖으로 나가거나 다음 위치에 오목알이 없으면 탈출
									break;
								}
								if (k == 4) { //탈출 안했을 경우에는 오목으로 판정
									check = true;
								}
							}

						}

					}
				}
			}
			
//		==============================  출력   =====================================
			if (check) {
				System.out.println("#" + tc + " YES");
			} else
				System.out.println("#" + tc + " NO");

		}
	}

}
