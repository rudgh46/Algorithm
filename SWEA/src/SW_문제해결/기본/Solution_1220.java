package SW_문제해결.기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [제약 사항]
자성체는 테이블 앞뒤 쪽에 있는 N극 또는 S극에만 반응하며 자성체끼리는 전혀 반응하지 않는다.
테이블의 크기는 100x100으로 주어진다. (예시에서는 설명을 위해 7x7로 주어졌음에 유의)

  [입력]
각 테스트 케이스의 첫 번째 줄에는 정사각형 테이블의 한 변의 길이가 주어진다. 그리고 바로 다음 줄에 테스트 케이스가 주어진다.
총 10개의 테스트 케이스가 주어진다.
1은 N극 성질을 가지는 자성체를 2는 S극 성질을 가지는 자성체를 의미하며 테이블의 윗 부분에 N극이 아랫 부분에 S극이 위치한다고 가정한다.

  [출력]
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 교착 상태의 개수를 출력한다.
 */
public class Solution_1220 {// D3_Magnetic

	public static void main(String[] args) throws NumberFormatException, IOException {
//		=============================  입력   ======================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine()); //테이블 한 변의 길이
			int table[][] = new int[N][N]; //테이블
			int cnt = 0; //교착상태 카운트
			int check = 0; //교착 가능성 체크
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken()); //테이블 상태 입력
				}
			}
//		=============================  풀이   ======================================
			for (int j = 0; j < N; j++) { //열 탐색
				check = 0; //열 탐색할때마다 교착 0으로 초기화
				for (int i = 0; i < N; i++) {
					if (table[i][j] == 1) { //1을 만날경우
						check = 1; //교착 1로 업데이트 (교착 가능)
					} else if (table[i][j] == 2 & check == 1) { //2를 만나고 교착 가능한 경우
						cnt++; //교착상태 카운트 증가
						check = 0; //교착 했으니까 다시 0으로
					}
				}
			}
//		=============================  출력   ======================================
			System.out.println("#" + tc + " " + cnt);

		}
	}

}
