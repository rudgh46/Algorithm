package IM_Test.Bronze2;

import java.util.Scanner;

public class Main_1592 { //영식이와 친구들

	public static void main(String[] args) {
//		===============  입력    ===============
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //사람 수
		int M = sc.nextInt(); //게임 끝 조건, M번 받으면 끝
		int L = sc.nextInt(); //L만큼 움직임
		int cnt = 0;
		int start = 1;
		int arr[] = new int[N+1];
		
//		===============  풀이    ===============
		while(true) {
			arr[start] += 1;
			
			if(arr[start] == M) break;

			if(arr[start]%2 ==0) { //짝수면 반시계 방향
				start = (start-L) <= 0 ? N-Math.abs(start-L) : start-L;
			} else { //홀수면 시계 방향
				start = (start+L) > N ? (start+L)%N : start+L;
			}
			cnt++;
		}
		
//		===============  출력    ===============
		System.out.println(cnt);
	}

}
