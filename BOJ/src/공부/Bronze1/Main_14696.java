package 공부.Bronze1;

import java.util.Scanner;

/*
  [입력]
표준 입력으로 다음 정보가 주어진다. 
첫 번째 줄에는 딱지놀이의 총 라운드 수를 나타내는 자연수 N이 주어진다. N 은 1 이상 1,000 이하이다. 
다음 줄에는 라운드 1에서 어린이 A가 내는 딱지에 나온 그림의 총 개수 a가 주어진다. a는 1 이상 100 이하이다. 
뒤따라 나오는 a개의 정수는 어린이 A가 낸 딱지의 그림을 나타내는데, 각각 4, 3, 2, 1 중 하나의 값이다. 
4, 3, 2, 1의 순서대로 주어지지 않을 수 있음에 주의하라. 
다음 줄에는 라운드 1에서 어린이 B가 내는 딱지에 나온 그림의 총 개수 b가 주어진다. b도 1 이상 100 이하이다. 
뒤따라 나오는 b개의 정수는 어린이 B가 낸 딱지의 그림을 나타내는데, 역시 4, 3, 2, 1 중 하나의 값이다. 
역시 4, 3, 2, 1의 순서대로 주어지지 않을 수 있음에 주의하라. 
다음 두 줄에는 라운드 2에서 어린이 A, B가 낸 딱지의 그림들을 같은 식으로 표현한다. 
위와 같은 식으로 매 라운드마다 두 어린이가 낸 딱지의 정보는 두 줄에 표현되며, N 라운드의 딱지 정보는 차례대로 총 2N 개의 줄에 주어진다.

  [출력]
표준 출력으로 총 N 줄을 출력한다. 출력의 i번째 (1 ≤ i ≤ N) 줄에 정확히 한 글자를 출력하는데, 출력하는 글자는 A, B, D 중 하나로 라운드 i의 결과를 나타낸다. 각 라운드의 결과는 A가 승자라면 A, B가 승자라면 B, 무승부라면 D이다.
 */
public class Main_14696 { // 딱지놀이

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int tc = 0; tc < N; tc++) {
			int A = sc.nextInt();
			int cardA[] = new int[5];
			for(int i=0; i<A; i++) {
				cardA[sc.nextInt()]++;
			}
			
			int B = sc.nextInt();
			int cardB[] = new int[5];
			for(int i=0; i<B; i++) {
				cardB[sc.nextInt()]++;
			}
			
			for(int i=4; i>0; i--) {
				if(cardA[i]>cardB[i]) {
					System.out.println("A");
					break;
				}
				else if(cardA[i]<cardB[i]) {
					System.out.println("B");
					break;
				}
				else if(i==1 && cardA[i] == cardB[i]) {
					System.out.println("D");
					break;
				}
			}
		}
	}

}
