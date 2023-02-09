package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 부먹 왕국의 도시 수 N(1 ≤ N ≤ 300,000)과 이동 제한 거리 D(1 ≤ D ≤ N)이 주어진다.
두 번째 줄에는 1번 도시부터 차례대로 각 도시에 차원관문이 남아있는 지에 대한 정보가 주어진다.
1은 남아있음을 의미하며 0은 파괴 당한 것을 의미한다.
i번 도시와 (i+1)번 도시 사이의 거리는 모든 1 ≤ i < N에 대해서 1이다.

  [출력]
각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
각 테스트 케이스마다 부먹 왕국이 추가로 건설 해야 하는 차원관문 의 최소 개수를 구하여라.
 */
public class Solution_7964 { //부먹왕국의 차원 관문

	public static void main(String[] args) throws NumberFormatException, IOException {
//		===============================  입력   ====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //도시 수
			int D = Integer.parseInt(st.nextToken()); //이동 제한 거리
			int gate[] = new int[N];
			int move=0; //이동 횟수
			int cnt=0; //건설 횟수
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				gate[i] = Integer.parseInt(st.nextToken());
			}
			
//		===============================  풀이   ====================================
			for(int i=0; i<N; i++) {
				move++; //이동횟수 증가
				if(gate[i] == 1 || move==D) { //게이트 있거나 이동횟수 == 제한거리이면
					if(move==D && gate[i] != 1) { //이동횟수 == 제한거리이고 게이트 없으면 건설
						cnt++;
					}
					move=0; //이동횟수 초기화
				}
			}
			
//		===============================  출력   ====================================
			System.out.println("#" +tc+ " "+cnt);
			
		}
	}

}
