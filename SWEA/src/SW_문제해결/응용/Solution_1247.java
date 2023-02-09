package SW_문제해결.응용;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [제약사항]
고객의 수 N은 2≤N≤10 이다.
그리고 회사의 좌표, 집의 좌표를 포함한 모든 N+2개의 좌표는 서로 다른 위치에 있으며 좌표의 값은 0이상 100 이하의 정수로 이루어진다.

  [입력]
가장 첫줄은 전체 테스트케이스의 수이다.
이후, 두 줄에 테스트 케이스 하나씩이 차례로 주어진다.
각 테스트 케이스의 첫째 줄에는 고객의 수 N이 주어진다. 둘째 줄에는 회사의 좌표,집의 좌표, N명의 고객의 좌표가 차례로 나열된다.
좌표는 (x,y)쌍으로 구성되는데 입력에서는 x와 y가 공백으로 구분되어 제공된다.

  [출력]
총 10줄에 10개의 테스트 케이스 각각에 대한 답을 출력한다.
각 줄은 ‘#x’로 시작하고 공백을 하나 둔 다음 최단 경로의 이동거리를 기록한다. 여기서 x는 테스트 케이스의 번호다.
 */
public class Solution_1247 {//D5_최적경로

	static int N, 회사x, 회사y, 집x, 집y, 고객xy[][], 고객[], ans;
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
//		=================================  입력   =======================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			회사x = 0;
			회사y = 0;
			집x = 0;
			집y = 0;
			고객xy = new int[N][2];
			고객 = new int[N];
			visit = new boolean[N];
			ans = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			회사x = Integer.parseInt(st.nextToken().trim());
			회사y = Integer.parseInt(st.nextToken().trim());
			집x = Integer.parseInt(st.nextToken().trim());
			집y = Integer.parseInt(st.nextToken().trim());

			for (int i = 0; i < N; i++) {
				고객xy[i][0] = Integer.parseInt(st.nextToken().trim());
				고객xy[i][1] = Integer.parseInt(st.nextToken().trim());
			}

//		=================================  풀이   =======================================
			permutaion(0);

//		=================================  출력   =======================================
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

//		=================================  permutation  =======================================
	public static void permutaion(int cnt) {
		
		//순열 완성
		if (cnt == N) {
			int sum = 0;
			
			sum += Math.abs(회사x - 고객xy[고객[0]][0]) + Math.abs(회사y - 고객xy[고객[0]][1]); //회사에서 첫번째 고객까지의 거리
			for (int i = 0; i < N - 1; i++) {
				int a = 고객[i];
				int b = 고객[i + 1];
				sum += Math.abs(고객xy[a][0] - 고객xy[b][0]) + Math.abs(고객xy[a][1] - 고객xy[b][1]); //고객들 거리
			}
			sum += Math.abs(집x - 고객xy[고객[N - 1]][0]) + Math.abs(집y - 고객xy[고객[N - 1]][1]); //마지막 고객에서 내집까지 거리
			
			ans = Math.min(sum, ans);
			return;
		}

		//순열 구하기
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				고객[cnt] = i;
				permutaion(cnt + 1);
				visit[i] = false;
			}
		}
	}

}
