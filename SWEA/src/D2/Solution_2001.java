package D2;

import java.util.Scanner;
/*
  [제약 사항]

1. N 은 5 이상 15 이하이다.
2. M은 2 이상 N 이하이다.
3. 각 영역의 파리 갯수는 30 이하 이다.

  [입력]
가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,
다음 N 줄에 걸쳐 N x N 배열이 주어진다.
 */

public class Solution_2001 { //파리 퇴치

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test = 1; test<=T; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt(); //파리채
			int map[][] = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int sum = 0; //죽인 파리 수
			int max = 0; //최대
			
			for(int i=0; i<N-M+1; i++) {		//N-M+1 => 파리채가 몇번 이동하는지 횟수
				for(int j=0; j<N-M+1; j++) {
					sum = 0;
					for(int r=0; r<M; r++) {	//크기가 M인 파리채
						for(int c=0; c<M; c++) {
							sum += map[i+r][j+c];	//파리채 범위 안의 파리 수 더하기
						}
					}
					if(sum > max) {
						max = sum;
					}
				}
			}
			
			System.out.println("#" + test + " " + max);
		}
	}

}
