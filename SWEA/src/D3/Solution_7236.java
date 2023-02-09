package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [제약 조건]
저수지 구획의 크기(N)은 9<= N <= 100 이다.

  [입력]
첫줄은 테스트 케이스(T)가 입력된다. 
두번째 줄부터 T개의 테스케이스의 데이타가 다음과 같은 순서로 입력된다. 
각 테스트 케이스의 첫 줄에는 저수지 구획의 크기(N)이 주어진다. 
그 다음 줄 부터 N줄에 걸쳐 지역 정보가 입력된다. 

  [출력]
각 줄은 #Ti(테스트케이스 번호) 공백을 하나 둔 다음 문제의 답을 출력한다. 
 */
public class Solution_7236 {//저수지의 물의 총 깊이 구하기

	static int deltas[][] = { 
			{-1, -1},
			{-1, 0},
			{-1, 1},
			{0, 1},
			{1, 1},
			{1, 0},
			{1, -1},
			{0, -1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
//		================================  입력   ====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			char map[][] = new char[N][N]; //저수지 크기
			int cnt = 1; //물 깊이
			int max = Integer.MIN_VALUE;

			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}

//		================================  풀이   ====================================
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1;
					if (map[i][j] == 'W') { //물이면 탐색 시작
						for (int d = 0; d < 8; d++) {
							int dx = i + deltas[d][0];
							int dy = j + deltas[d][1];

							if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
								if (map[dx][dy] == 'W') { //탐색 위치가 물이면 물 깊이 증가
									cnt++;
								}
								max = max < cnt ? cnt : max; //물 깊이 최대값으로 업데이트
							}
						}

					}
				}
			}
			
//		================================  출력   ====================================
			if (max == 1) { //깊이가 1이면 그대로 출력
				System.out.println("#" + tc + " " + max);
			} else //그외엔 -1 후 출력
				System.out.println("#" + tc + " " + (max - 1));

		}

	}

}
