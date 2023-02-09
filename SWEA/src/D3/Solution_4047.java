package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  [입력]
맨 위 줄에 테스트케이스의 개수가 주어진다.
각 테스트케이스 별로 순서대로 첫 번째 줄에 지금 영준이가 가지고 있는 카드에 대한 정보 S (1 ≤ |S| ≤ 1000)가 주어진다.
S는 각각 3자리로 표현되는 카드들의 정보를 붙여서 만든 하나의 문자열인데 각 카드는 TXY 꼴로 표현되며,
T는 카드의 무늬(S, D, H, C)이며 XY는 카드의 숫자 (01 ~ 13)이다.

  [출력]
각 테스트케이스 별로 순서대로 한 줄씩 답을 출력하는데, 문자열 S를 보고 지금 무늬 별로(S, D, H, C 순서로) 몇 장의 카드가 부족한지 출력하여라.
이미 겹치는 카드가 있다면 문자열 “ERROR” (쌍따옴표는 출력하지 않는다)를 출력한다
 */
public class Solution_4047 {//영준이의 카드 카운팅

	public static void main(String[] args) throws NumberFormatException, IOException {
//		===============================  입력   ====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			int cnt[][] = new int[4][14]; //모양,숫자 배열
			int Scnt = 13, Dcnt = 13, Hcnt = 13, Ccnt = 13; //카드 개수
			boolean flag = false; //중복체크

			String cardSet = br.readLine();

//		===============================  풀이   ====================================
			for (int i = 0; i < cardSet.length(); i += 3) { //3씩 증가
				String card = cardSet.substring(i, i + 3); //3개씩 끊어서 저장
				char shape = card.charAt(0); // 카드 모양
				int num = Integer.parseInt(card.substring(1, 3)); // 숫자
				
				if (shape == 'S') {	//모양체크  
					cnt[0][num]++;//0==S, 각 숫자에 해당하는 배열 값 증가
					Scnt--; //카드 사용했으니까 개수 줄여주기
				} else if (shape == 'D') {
					cnt[1][num]++;//1==D
					Dcnt--;
				} else if (shape == 'H') {
					cnt[2][num]++;//2==H
					Hcnt--;
				} else if (shape == 'C') {
					cnt[3][num]++;//3==C
					Ccnt--;
				}

			}
			for (int i = 1; i < 14; i++) {//숫자 배열 확인
				if (cnt[0][i] > 1 || cnt[1][i] > 1 || cnt[2][i] > 1 || cnt[3][i] > 1) { //1이 넘는 값은 중복값
					flag = true; //중복 체크
					break;
				}
			}

//		===============================  출력   ====================================
			if (flag == false) { //중복 없는경우
				System.out.println("#" + tc + " " + Scnt + " " + Dcnt + " " + Hcnt + " " + Ccnt);
			} else //중복 있는경우
				System.out.println("#" + tc + " " + "ERROR");

		}

	}

}
