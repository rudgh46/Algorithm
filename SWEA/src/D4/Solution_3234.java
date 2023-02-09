package D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스마다 첫 번째 줄에 N(1 ≤ N ≤ 9)가 주어진다.
두 번째 줄에는 각 무게추의 무게를 의미하는 N개의 자연수가 공백으로 구분되어 주어진다. 무게는 1이상 999이하이다.

  [출력]
각 테스트 케이스마다 무게추를 올리는 과정에서 오른쪽 위에 올라가있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 커지지 않는 경우의 수를 출력한다.
 */
public class Solution_3234 {// 준환이의 양팔저울
	static int N, res, weight[], weight_perm[];
	static boolean used[];

	public static void main(String[] args) throws NumberFormatException, IOException {
//		================================  입력   ===================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			used = new boolean[N];
			weight = new int[N];
			weight_perm = new int[N];
			res = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

//		================================  풀이   ===================================
			permutaion(0);

//		================================  출력   ===================================
			System.out.println("#" + tc + " " + res);

		}
	}
//	=============  permutation  ==============
	public static void permutaion(int cnt) {

		// 순열 완성
		if (cnt == N) {
			subset(0, 0, 0);
			return;
		}

		// 순열 구하기
		for (int i = 0; i < N; i++) {
			if (used[i])
				continue;
			{
				used[i] = true;
				weight_perm[cnt] = weight[i];
				permutaion(cnt + 1);
				used[i] = false;
			}
		}
	}

//	==========================  subset  ============================
	public static void subset(int cnt, int sumLeft, int sumRight) {

		if (cnt == N) { // 추 다 올렸으면
			res++;
			return;
		}

		subset(cnt + 1, sumLeft + weight_perm[cnt], sumRight); //왼쪽 저울

		if (sumRight + weight_perm[cnt] <= sumLeft) {	//오른쪽 저울, 왼쪽이 더 무거워야함
			subset(cnt + 1, sumLeft, sumRight + weight_perm[cnt]);
		}

	}

}
