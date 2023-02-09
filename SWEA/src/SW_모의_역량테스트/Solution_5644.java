package SW_모의_역량테스트;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
  [제약사항]
1. 지도의 가로, 세로 크기는 10이다.
2. 사용자는 총 2명이며, 사용자A는 지도의 (1, 1) 지점에서, 사용자B는 지도의 (10, 10) 지점에서 출발한다.
3. 총 이동 시간 M은 20이상 100이하의 정수이다. (20 ≤ M ≤ 100)
4. BC의 개수 A는 1이상 8이하의 정수이다. (1 ≤ A ≤ 8)
5. BC의 충전 범위 C는 1이상 4이하의 정수이다. (1 ≤ C ≤ 4)
6. BC의 성능 P는 10이상 500이하의 짝수이다. (10 ≤ P ≤ 500)
7. 사용자의 초기 위치(0초)부터 충전을 할 수 있다.
8. 같은 위치에 2개 이상의 BC가 설치된 경우는 없다. 그러나 사용자A, B가 동시에 같은 위치로 이동할 수는 있다. 사용자가 지도 밖으로 이동하는 경우는 없다.
 
  [입력]
입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.
테스트 케이스의 첫 번째 줄에는 총 이동 시간(M), BC의 개수(A)가 주어진다.
그 다음 2개의 줄에는 각각 사용자 A와 B의 이동 정보가 주어진다.
한 사용자의 이동 정보는 M개의 숫자로 구성되며, 각각의 숫자는 다음과 같이 매초마다 이동 방향을 의미한다.
그 다음 줄에는 A개의 줄에 걸쳐 BC의 정보가 주어진다.
하나의 BC 정보는 좌표(X, Y), 충전 범위(C), 처리량(P)로 구성된다.

  [출력]
출력은 "#t"를 찍고 한 칸 띄운 다음 정답을 출력한다. (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
정답은 모든 사용자의 충전량 합의 최대값을 출력한다.
 */

public class Solution_5644 {//무선 충전

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수
		int deltas[][] = {
				{0,0},	//안움직임
				{0,-1},	//상
				{1,0},	//우
				{0,1},	//하
				{-1,0}};//좌
		
		for(int tc=1; tc<=T; tc++) {
			int M = sc.nextInt(); //총 이동시간
			int A = sc.nextInt(); //충전기 개수
			int userA[] = new int[M+1]; //초기위치(0초) 포함
			int userB[] = new int[M+1]; //초기위치(0초) 포함
			int userA_x=1, userA_y=1, userB_x=10, userB_y=10; //사용자 A,B 초기위치 
			int ans = 0;
			
			for(int i=1; i<=M; i++) userA[i] = sc.nextInt(); //사용자 A의 이동정보 
			
			for(int i=1; i<=M; i++) userB[i] = sc.nextInt(); //사용자 B의 이동정보
			
			int AP[][] = new int[A][4]; //충전기 정보 배열

			for(int i=0; i<A; i++) {
				AP[i][0] = sc.nextInt(); //충전기 x좌표
				AP[i][1] = sc.nextInt(); //충전기 y좌표
				AP[i][2] = sc.nextInt(); //충전범위
				AP[i][3] = sc.nextInt(); //처리량
			}
			
			
			Arrays.sort(AP, new Comparator<int[]>() { // 처리량이 높은 순서로 정렬

				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[3]-o1[3];
				}
			});
			
			for(int i=0; i<=M; i++) { //A와 B 이동시간동안 이동 (처음 위치(0)부터 계산해야함)
				userA_x += deltas[userA[i]][0];
				userA_y += deltas[userA[i]][1];
				userB_x += deltas[userB[i]][0];
				userB_y += deltas[userB[i]][1];
				
				int curA=-99899;
				int curB=-99999;
				
				for(int a=0; a<A; a++) {
					if(AP[a][2] >= (Math.abs(userA_x-AP[a][0]) + Math.abs(userA_y-AP[a][1]))) {
						curA = a; //A가 사용한 충전기
						break;
					}
				}
				
				for(int b=0; b<A; b++) {
					if(AP[b][2] >= (Math.abs(userB_x-AP[b][0]) + Math.abs(userB_y-AP[b][1]))) {
						curB = b; //B가 사용한 충전기
						break;
					}
				}
				if(curA==curB) {//같은 충전기 사용시
					int a = curA+1; //
					for(; a<A; a++) {// 다음으로 겹치는 큰 부분 찾기
						if(AP[a][2] >= (Math.abs(userA_x-AP[a][0]) + Math.abs(userA_y-AP[a][1])) ||  AP[a][2] >= (Math.abs(userB_x-AP[a][0]) + Math.abs(userB_y-AP[a][1]))) {
							curA = a; //값 저장
							break;
						}
					}
					if(a==A) { //충전할 곳 확인
						ans += AP[curA][3];
					}
					else { //충전할 곳 있으면 해당 값 각각 더해주기
						ans += AP[curA][3];
						ans += AP[curB][3];
					}
				}
				else { //같은 충전기 사용 안하고 초기값이 아니면 각각 더해주기
					if(curA!=-99899) ans += AP[curA][3];
					if(curB!=-99999) ans += AP[curB][3];
				}
				
			}
			System.out.println(ans);
		}
	}

}
