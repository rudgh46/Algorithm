package D3;
import java.util.LinkedList;
import java.util.Scanner;

/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 자연수 N(1 ≤ N ≤ 1,000)이 주어진다.
두 번째 줄에는 덱에 카드가 놓인 순서대로 N개의 카드 이름이 공백으로 구분되어 주어진다.
카드의 이름은 알파벳 대문자와 ‘-’만으로 이루어져 있으며, 길이는 80이하이다.
 */
public class Solution_3499 { //퍼펙트 셔플

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test = 1; test <= T; test++) {
			int N = sc.nextInt();
			LinkedList<String> card = new LinkedList<>();
			LinkedList<String> card2 = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				card.add(sc.next());
			}
			if (N % 2 == 0) {//짝수, 홀수 판단해서 card2에 card 절반 넣기
				for (int i = 0; i < N/2; i++) {
					card2.add(card.poll());
				}											
			}else
				for(int i=0; i<N/2+1; i++) {
					card2.add(card.poll());
				}
			System.out.print("#"+test+" ");
			for(int i=0; i<N; i++) {
				if(i%2==0) //짝수 홀수 번갈아 가면서 출력 
					System.out.print(card2.poll()+" ");
				else 
					System.out.print(card.poll()+" ");
			}System.out.println();
		}
	}

}
