package IM_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_기지국2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int deltas[][] = {
				{-1,0},
				{1,0},
				{0,-1},
				{0,1}};
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] map = new char[N][];
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int dx,dy;
			
			for(int i = 0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] >= 'A' && map[i][j] <='C') {
						//기지국 주변 4방 탐색(한쪽 방향 다 처리하고 다른 방향 처리)
						for(int k=1; k<=(map[i][j]-'A')+1; k++) {
							for(int d=0; d<4;d++) {
								dx = i + k*deltas[d][0];
								dy = j + k*deltas[d][1];
								if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx][dy] =='H') {
									map[dx][dy] = 'X';
								}
							}				
						}
					}
				}
			}		
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'H') cnt++;
				}
			} 
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
