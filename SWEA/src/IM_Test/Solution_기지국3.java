package IM_Test;
import java.util.Scanner;

public class Solution_기지국3 {//기지국

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int deltas[][] = {
				{0,1},
				{0,-1},
				{1,0},
				{-1,0}};

		for(int test = 1; test<=T; test++) {
			
			int N = sc.nextInt();

			int map[][] = new int[N][N];
			int count = 0;


			for(int i=0; i<N; i++) {
				String line = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == 'H') {
						count++;
					}
				}
			}
			int r=0,c=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] !='X' && map[i][j] != 'H') {
						for(int a=1; a<map[i][j] -'A' + 2; a++) { //A - A + 2 => A 기지국은 1개 커버, B일경우 2 .....
							if(i + a < N && map[i+a][j] == 'H') {
								map[i+a][j] = 'X';
								count--;
							}
							if(i - a > -1 && map[i-a][j] == 'H') {
								map[i-a][j] = 'X';
								count--;
							}
							if(j + a < N && map[i][j+a] == 'H') {
								map[i][j+a] = 'X';
								count--;
							}
							if(j - a > -1 && map[i][j-a] == 'H') {
								map[i][j-a] = 'X';
								count--;
							}
//							if(r>=0 && r<N && c>=0 && c<N && map[r][c] == 'H') {
//								count--;
//							}
						}
					}
				}
			}
			System.out.println("#"+test+" "+count);
			
		}
	}

}
/*
 * IM = group function
 *  sum avg max min count 다루기
 *  + soritng
 *  A = simulation 시간 경과에 따라 변함
 */