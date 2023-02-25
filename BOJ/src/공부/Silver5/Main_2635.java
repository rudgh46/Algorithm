package 공부.Silver5;

/*
  [입력]
첫 번째 수가 주어진다. 이 수는 30,000 보다 같거나 작은 양의 정수이다.

  [출력]
첫 번째 줄에는 입력된 첫 번째 수로 시작하여 위의 규칙에 따라 만들 수 있는 수들의 최대 개수를 출력한다.
둘째 줄에 그 최대 개수의 수들을 차례대로 출력한다. 이들 수 사이에는 빈칸을 하나씩 둔다.
 */
import java.util.Scanner;

public class Main_2635 { // 수 이어가기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int maxnum = 0;
		for (int i = N; i >= 0; i--) {
			int cnt = 2;
			int prev = N;
			int cur = i;
			int next = prev - cur;
			while (prev - cur >= 0) {
				next = prev - cur;
				prev = cur;
				cur = next;
				cnt++;
			}
			if (cnt > max) {
				max = cnt;
				maxnum = i;
			}
		}
		System.out.println(max);
		int prev = N, cur = maxnum, next = prev - cur;
		System.out.print(prev + " " + cur + " ");
		while (prev - cur >= 0) {
			next = prev - cur;
			prev = cur;
			cur = next;
			System.out.print(next + " ");
		}
	}

}
