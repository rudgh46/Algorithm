package D2;
import java.util.Scanner;
/*
  	방향 전환의 조건
  	1. 경계를 넘어갈 때
  	2. 진행 방향에 이미 숫자가 차 있을 때
  	
  	입력 (테스트 케이스 수, 테스트 케이스N(N*N배열크기))
  	2
  	3
  	4
 */


public class Solution_1954 { //달팽이 숫자

	public static void main(String[] args) {
		int deltas[][] = { 
				{ 0, 1 }, // 우
				{ 1, 0 }, // 하
				{ 0, -1 }, // 좌
				{ -1, 0 } }; // 상
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int N = sc.nextInt();
			int count = 1;
			int dx = 0;
			int dy = 0;	//탐색시 필요
			int r = 0;
			int c = 0;//행렬 숫자
			int map[][] = new int[N][N];
			map[r][c] = count; //0,0은 1부터 시작
			count++; 
			for (int i = 0; i < 2 * N - 1; i++) { // 방향이 바뀌는 횟수(맨 처음 우측이동 포함)
				while (true) {// 방향 바뀌기 전까지 반복하기
					dx = r + deltas[i % 4][0];
					dy = c + deltas[i % 4][1]; //우하좌상 순서
					if (dx >= 0 && dy >= 0 && dx < N && dy < N && map[dx][dy] == 0) { //배열이 밖을 안나가고 배열에 입력숫자가 없어야함
						map[dx][dy] = count;
						count++; //배열에 1씩 커지는 숫자 넣기
					} else
						break; //if문 조건 안맞을 시 while문 탈출,
					r = dx;
					c = dy; //현 위치
				}

			}
			System.out.println("#"+test);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}
