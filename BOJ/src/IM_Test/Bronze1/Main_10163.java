package IM_Test.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
입력의 첫 번째 줄에는 색종이의 장수를 나타내는 정수 N (1 ≤ N ≤ 100)이 주어진다. 
이어서 N장의 색종이에 관한 입력이 각 색종이마다 한 줄씩 차례로 주어진다. 
색종이가 놓이는 평면은 가로 최대 1001칸, 세로 최대 1001칸으로 구성된 격자 모양이다. 
격자의 각 칸은 가로, 세로 길이가 1인 면적이 1인 정사각형이다. 
편의상 가로 6칸, 세로 6칸으로 이루어진 격자의 예를 들어 설명하면, 각 칸에 표시된 값 (a,b)는 해당 칸의 번호를 나타낸다. 
가장 왼쪽 아래의 칸은 (0,0) 가장 오른 쪽 위의 칸은 (5,5)이다. 
색종이가 놓인 상태는 가장 왼쪽 아래 칸의 번호와 너비, 높이를 나타내는 네 정수로 표현한다. 
예를 들어, 위 그림에서 회색으로 표시된 색종이는 (1,4)가 가장 왼쪽 아래에 있고 너비 3, 높이 2이므로 1 4 3 2로 표현한다. 
색종이가 격자 경계 밖으로 나가는 경우는 없다. 

  [출력]
입력에서 주어진 순서에 따라 N장의 색종이를 평면에 놓았을 때, 입력에서 주어진 순서대로 각 색종이가 보이는 부분의 면적을 한 줄에 하나씩 하나의 정수로 출력한다. 
만약 색종이가 보이지 않는다면 정수 0을 출력한다. 
 */
public class Main_10163 {// 색종이

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[1001][1001];
		
		for(int tc = 1; tc<=N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int i=x; i<x+w; i++) {
				for(int j=y; j<y+h; j++) {
					map[i][j] = tc;
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=N; tc++) {
			int cnt = 0;
			for(int i=0; i<1001; i++) {
				for(int j=0; j<1001; j++) {
					if(map[i][j] == tc)
						cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}

}
