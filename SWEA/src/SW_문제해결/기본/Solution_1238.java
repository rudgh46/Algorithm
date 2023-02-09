package SW_문제해결.기본;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
  [입력]
입력의 첫 번째 줄에는 입력 받는 데이터의 길이와 시작점이 주어진다.
그 다음 줄에 입력받는 데이터는 {from, to, from, to, …} 의 순서로 해석되며
 예시의 경우는 {2, 7, 11, 6, 6, 2, 2, 15, 15, 4, 4, 2, 4, 10, 7, 1, 1, 7, 1, 8, 1, 17, 3, 22}와 같다.
그런데 순서에는 상관이 없으므로 다음과 같이 주어진 인풋도 동일한 비상연락망을 나타낸다 (같은 비상연락망을 표현하는 다양한 인풋이 존재 가능하다).
{1, 17, 3, 22, 1, 8, 1, 7, 7, 1, 2, 7, 2, 15, 15, 4, 6, 2, 11, 6, 4, 10, 4, 2}
다음과 같이 동일한 {from, to}쌍이 여러 번 반복되는 경우도 있으며, 한 번 기록된 경우와 여러 번 기록된 경우의 차이는 없다.
{1, 17, 1, 17, 1, 17, 3, 22, 1, 8, 1, 7, 7, 1, 2, 7, 2, 15, 15, 4, 6, 2, 11, 6, 4, 10, 11, 6, 4, 2}
 
[출력]
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.
 */
public class Solution_1238 {//D4_Contact
	static int N, S, arr[][];
	static boolean visit[];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
//		=============================  입력   ======================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //데이터 길이
			S = Integer.parseInt(st.nextToken()); //시작점
			arr = new int[N+1][N+1];
			visit = new boolean[N + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = 1;
			}

//		=============================  풀이   ======================================
			int ans = bfs();
			
//		=============================  출력   ======================================
			System.out.println("#"+tc+" "+ans);
		}
	} 

//	========== bfs  ===========
	private static int bfs() {
		queue.offer(S);
		visit[S] = true;
		int size = 0;
		int ans = 0;

		while (!queue.isEmpty()) {
			size = queue.size();
			int max = 0;

			while (--size >= 0) { // 같은 레벨 노드
				int curr = queue.poll();
				
				for (int i = 1; i <= N; i++) {
					if (arr[curr][i] == 1 && !visit[i]) {
						queue.offer(i);
						if(max<i) max = i;
						visit[i] = true;
					}
				}
			}
			if(max>0) ans = max;
		}
		return ans;
	}

}
