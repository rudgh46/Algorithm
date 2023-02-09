package IM_Test.Bronze2;
import java.util.Scanner;
/*
  [입력]
표준 입력으로 다음 정보가 주어진다. 
첫 번째 줄에는 수학여행에 참가하는 학생 수를 나타내는 정수 N(1 ≤ N ≤ 1,000)과 한 방에 배정할 수 있는 최대 인원 수 K(1 < K ≤ 1,000)가 공백으로 분리되어 주어진다. 
다음 N 개의 각 줄에는 학생의 성별 S와 학년 Y(1 ≤ Y ≤ 6)가 공백으로 분리되어 주어진다. 성별 S는 0, 1중 하나로서 여학생인 경우에 0, 남학생인 경우에 1로 나타낸다. 

  [출력]
표준 출력으로 학생들을 모두 배정하기 위해 필요한 최소한의 방의 수를 출력한다.
 */
public class Main_13300 { //방배정

	public static void main(String[] args) {
//		================  입력   ================
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 한 방에 배정할 수 있는 최대 수
		int cnt = 0; // 방 개수
		int student[][] = new int[2][7]; // 성별(0,1), 학년(1~6) 배열

		for (int i = 0; i < N; i++) {
			int S = sc.nextInt(); // 학생의 성별 (0 : 여성, 1 : 남성)
			int Y = sc.nextInt(); // 학년 (1~6)

//		================  풀이   ================
			if (S == 0)
				student[0][Y]++; // 성별별로, 학년별로 배열에 넣어주기
			else
				student[1][Y]++;
		}

		for (int i = 0; i < 2; i++) { // 성별
			for (int j = 1; j < student[i].length; j++) { // 학년
				if (student[i][j] == 0)
					continue; // 아무도 없을경우 패스(방 필요없음)

				if (student[i][j] % K != 0) { //인원수가 최대 수로 나누어 떨어지지 않으면
					cnt += student[i][j] / K + 1; // 방 개수 : 인원수를 최대 수로 나눈 몫에 +1
				} else { //나누어 떨어질때
					cnt += student[i][j] / K; 
				}

			}
		}
//		================  출력   ================
		System.out.println(cnt);
	}

}
