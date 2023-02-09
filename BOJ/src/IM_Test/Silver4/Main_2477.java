package IM_Test.Silver4;

import java.util.Scanner;

/*
  [입력]
첫 번째 줄에 1m2의 넓이에 자라는 참외의 개수를 나타내는 양의 정수 K (1 ≤ K ≤ 20)가 주어진다. 
참외밭을 나타내는 육각형의 임의의 한 꼭짓점에서 출발하여 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 
길이 (1 이상 500 이하의 정수) 가 둘째 줄부터 일곱 번째 줄까지 한 줄에 하나씩 순서대로 주어진다. 
변의 방향에서 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4로 나타낸다.

  [출력]
첫째 줄에 입력으로 주어진 밭에서 자라는 참외의 수를 출력한다.
 */
public class Main_2477 {//참외밭

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int len[][] = new int[2][6];
		int max = 0;
		int idx = 0;
		
		for(int i=0; i<6; i++) {
			len[0][i] = sc.nextInt(); //방향
			len[1][i] = sc.nextInt(); //길이
		}
		
		for(int i=0; i<6; i++) {//반시계 방향으로 가로 세로 반복
			if(max < len[1][i] * len[1][(i+1)%6]) {
				max = len[1][i] * len[1][(i+1)%6];
				idx = i;
			}
		}
		
		max = max - len[1][(idx+3)%6]*len[1][(idx+4)%6];
		System.out.println(max*K);
			
		
	}

}
