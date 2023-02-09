package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 TC 가 주어진다.
이후 TC 개의 테스트 케이스가 새 줄로 구분되어 주어진다. 각 테스트 케이스는 다음과 같이 구성되었다.
첫 번째 줄에 과자 봉지의 개수와 무게 합 제한을 나타내는 자연수 N, M이 주어진다. (2 ≤ N ≤ 1000 , 2 ≤ M ≤ 2000000)
이후 N개의 줄에 각 과자봉지의 무게 가 주어진다. (1 ≤ ai ≤ 1000000) 

만약 한빈이가 두 과자를 들고 갈 방법이 없는 경우에는 -1을출력한다.
 */
public class Solution_9229 {// 한빈이와 Spot Mart

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			int sum = 0;
			int weight[] = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N-1; i++) {
				for (int j = i + 1; j < N; j++) {
					sum = weight[i] + weight[j];
					if (sum <= M && max < sum) {
						max = sum;
					}
				}
			}
			if (max == Integer.MIN_VALUE) {
				System.out.println("#" + test + " -1");
			} else {
				System.out.println("#" + test +" "+ max);
			}
		}
	}
}
