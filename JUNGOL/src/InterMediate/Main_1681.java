package InterMediate;
import java.util.Scanner;

/*
  [입력] 
첫 줄은 배달해야 하는 장소의 수 N(1≤N≤13)이 주어진다. 이때, 출발지(회사)는 1번이다.
둘째 줄은 N X N 크기의 장소와 장소를 이동하는 비용(0 ≤ 비용＜ 100)이 한 칸씩의 공백으로 구분하여 주어진다.
비용은 양방향이 아니라 단방향으로 가기 위한 비용이다. 
예들 들어 첫 번째 행 두 번째 열에 적힌 비용은 1번 장소에서 2번 장소로 이동하기 위한 비용을 의미하며, 
2번 장소에서 1번 장소로 이동하기 위한 비용은 두 번째 행 첫 번째 열에 주어진다. 
장소 사이에 이동할 수 있는 방법이 없다면 비용을 0으로 표시한다.

  [출력]
회사에서 출발하여 오늘 배달해야 하는 모든 장소를 한 번씩 들러 물건을 배달하고 회사에 돌아오기 위한 최소의 비용을 출력한다.
 */
public class Main_1681 {// Intermediate_해밀턴 순환회로

	static int N, arr[][], ans;
	static boolean visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		visit = new boolean[N];
		arr = new int[N][N];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		visit[0] = true; //회사에서 시작하기 때문에 방문처리 하고 시작
		dfs(1, 0, 0);
		System.out.println(ans);
	}
/**
 * 
 * @param cnt : 방문지점 개수
 * @param cur : 방문시작 index
 * @param sum : 누적 비용
 */
	private static void dfs(int cnt, int cur, int sum) { //N-1개의 순열,
		if (sum > ans) //중간에 구한 비용이 이미 구한 최소 비용보다 커지면 리턴
			return;
		if (cnt == N) {//마지막 도닥 부분은 마지막 고객의 집, 다시 회사로 복귀
			if (arr[cur][0] != 0 && ans > sum + arr[cur][0]) { //마지막 회사로 복귀하는 경로가 존재하고 최소비용보다 작으면 갱신
				ans = sum + arr[cur][0];
			}
			return;
		}
		for (int i = 1; i < N; i++) {
			if (arr[cur][i] == 0 || visit[i]) //시작점에서 i를 갈 수 있고 방문한 적이 없을경우만
				continue;
			visit[i] = true;
			dfs(cnt + 1, i, sum + arr[cur][i]); //정점 이어주기
			visit[i] = false;
		}

	}

}
