package IM_Test;

import java.util.Scanner;

/*
 * [입력]
  첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 
  이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다. 
  각 테스트 케이스는 다음과 같이 구성되었다.
  · 첫 번째 줄에 정수 n이 주어진다. (1≤ n ≤105)
  · 이후 7개의 정수 a1, a2, …, a7이 주어진다. (0 ≤ ai ≤ 1)
  
[출력]
  각 테스트 케이스마다 문제의 정답을 출력하라.
 */
public class Solution_13038 {//D3_교환학생

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int n = sc.nextInt();
			int min = Integer.MAX_VALUE;
			int arr[] = new int[7];
			
			for(int i=0; i<7; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<7; i++) {
				//수업이 시작하는 모든 요일 처리
				if(arr[i] == 0) continue;
				
				int cnt = 0;
				int day = i;
				while(true) {
					if(arr[day % 7]==1) cnt++; //수업이 열리면 카운팅
					
					++day; //하루지남
					if(cnt == n) { //머무른 최소일수
						min = Math.min(min, day-i);
						break;
					}
				}
			}
			System.out.println("#" + tc +" "+min);
		}
	}

}
