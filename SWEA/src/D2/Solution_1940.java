package D2;

import java.util.Scanner;

/*
  [제약사항]
1. N은 2이상 30이하의 정수이다. (2 ≤ N ≤ 30)
2. 가속도의 값은 1 m/s2 혹은 2 m/s2 이다.
3. 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0 m/s 가 된다.

  [입력]
입력은 첫 줄에 총 테스트 케이스의 개수 T, 다음 줄부터 각 테스트 케이스가 주어진다.
테스트 케이스 첫 줄에는 Command 의 수 N이 주어지고, 둘째 줄부터, 매 줄마다 각각의 Command가 주어진다.

  [출력]
테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */
public class Solution_1940 {//가랏! RC카!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 명령어 수
			int v = 0; //가속도의 변화
			int distance = 0;
			
			for (int i = 0; i < N; i++) {
				int command = sc.nextInt(); // 가속, 감속, 속도 유지 명령어
				switch (command) {
				case 1: // 가속
					v += sc.nextInt(); // 가속도의 변화값 *주의 : 0의 명령어인 경우 입력받을 값 없음!!
					break;
				case 2: // 감속
					v -= sc.nextInt(); // 가속도의 변화값 *주의 : 0의 명령어인 경우 입력받을 값 없음!!
					break;
				}
				if(v<0) v=0;
				
				distance += v;
			}
			System.out.println("#"+tc+" "+distance);
		}
	}

}
