package 공부.Bronze1;

import java.util.Scanner;

/*
  [입력]
입력은 네 줄이며, 각 줄은 직사각형의 위치를 나타내는 네 개의 정수로 주어진다. 
첫 번째와 두 번째의 정수는 사각형의 왼쪽 아래 꼭짓점의 x좌표, y좌표이고 
세 번째와 네 번째의 정수는 사각형의 오른쪽 위 꼭짓점의 x좌표, y좌표이다.
모든 x좌표와 y좌표는 1이상이고 100이하인 정수이다.

  [출력]
첫 줄에 네개의 직사각형이 차지하는 면적을 출력한다.
 */
public class Main_2669 {// 직사각형 네개의 합집합의 면적 구하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int map[][] = new int[101][101];
		int cnt = 0;

		for (int tc = 1; tc <= 4; tc++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();

			for (int i = x; i < x1; i++) {
				for (int j = y; j < y1; j++) {
					map[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
