package IM_Test.Silver3;

import java.util.Scanner;

/*
  [입력]
첫째 줄에는 스위치 개수가 주어진다. 스위치 개수는 100 이하인 양의 정수이다. 
둘째 줄에는 각 스위치의 상태가 주어진다. 켜져 있으면 1, 꺼져있으면 0이라고 표시하고 사이에 빈칸이 하나씩 있다. 
셋째 줄에는 학생수가 주어진다. 학생수는 100 이하인 양의 정수이다. 
넷째 줄부터 마지막 줄까지 한 줄에 한 학생의 성별, 학생이 받은 수가 주어진다. 
남학생은 1로, 여학생은 2로 표시하고, 학생이 받은 수는 스위치 개수 이하인 양의 정수이다. 
학생의 성별과 받은 수 사이에 빈칸이 하나씩 있다.

  [출력]
스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력한다. 
예를 들어 21번 스위치가 있다면 이 스위치의 상태는 둘째 줄 맨 앞에 출력한다. 
켜진 스위치는 1, 꺼진 스위치는 0으로 표시하고, 스위치 상태 사이에 빈칸을 하나씩 둔다.
 */
public class Main_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //스위치 개수
		int S[] = new int[N]; //스위치 개수만큼의 배열
		for (int i = 0; i < N; i++) { //배열에 초기 스위치정보 입력
			S[i] = sc.nextInt();
		}
		int students = sc.nextInt(); //학생수

		for (int i = 0; i < students; i++) { //학생 수 만큼 반복
			int gender = sc.nextInt(); //성별 남=1 여=2
			int num = sc.nextInt(); //학생이 받은 수
			
			if (gender == 1) { //성별 남
				for (int a = 0; a < N; a++) { 
					if ((a+1) % num == 0)  //배열은 0부터라 +1 해줌, 스위치 번호가 받은 수의 배수면
						S[a] = S[a] == 0? 1:0; //스위치 바꾸기
				}
					
				
			} else { // 성별 여
				if(S[num-1] == 0) { //배열이 0부터라 -1 해줌, ex) num=3이면 s[2] 가 3번째 스위치 
					S[num-1] = 1;
				}else {
					S[num-1] = 0;
				} //스위치 키고 끄기
				
				for(int a = 1; a<N; a++) {
					if((num - 1 + a) >= N || (num -1 - a) <0) //좌 우 살피기 배열 밖이면 브레이크
						break;
						
						if(S[num-1-a] == S[num-1+a]) { //좌우 스위치 상태가 같으면(대칭이면) 
							S[num-1-a] = S[num-1-a] == 0? 1:0; 
							S[num-1+a] = S[num-1+a] == 0? 1:0; //스위치 바꾸기
						}
					else break; //대칭이 아니면 브레이크
				}
			}
		}
		for(int i = 0; i<N; i++) {
			System.out.print(S[i] + " ");
			if((i+1)%20 ==0) //한 줄에 20개씩 출력
				System.out.println(); 
		}

	}

}
