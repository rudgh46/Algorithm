package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스 별로 첫 줄에는 자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고,
둘째 줄에는 각 날의 매매가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다.
각 날의 매매가는 10,000이하이다.

  [출력]
각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 최대 이익을 출력한다.
 */
public class Solution_1859 { //백만 장자 프로젝트

	public static void main(String[] args) throws NumberFormatException, IOException {
//		===============================  입력   =====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int price[] = new int[N + 1]; // 매매가
			long sum = 0;
			long max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

//		===============================  풀이   =====================================
			for (int i = N - 1; i >= 0; i--) { //최고치가 뒤에 있을수록 이익이 많아지니까 뒤에서부터 계산
				if (max < price[i]) { //최대 매매가 갱신
					max = price[i];
				} else {
					long num = max - price[i]; //이익 계산
					sum += num;
				}
			}
			
//		===============================  출력   =====================================
			System.out.println("#"+tc+" "+sum);
		}
	}

}
