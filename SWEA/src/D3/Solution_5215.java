package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [제약사항]
(단 여러 재료를 조합하였을 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정되고, 같은 재료를 여러 번 사용할 수 없으며, 햄버거의 조합의 제한은 칼로리를 제외하고는 없다.)

  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 재료의 수, 제한 칼로리를 나타내는 N, L(1 ≤ N ≤ 20, 1 ≤ L ≤ 104)가 공백으로 구분되어 주어진다.
다음 N개의 줄에는 재료에 대한 민기의 맛에 대한 점수와 칼로리를 나타내는 Ti, Ki(1 ≤ Ti ≤ 103, 1 ≤ Ki ≤ 103)가 공백으로 구분되어 주어진다.
 */

public class Solution_5215 { //햄버거 다이어트

	public static int N,L,max;
	public static int arr[][];
	public static boolean used[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			used = new boolean[N];
			max = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0);
			
			System.out.println("#"+test+" "+max);
		}

	}
	public static void dfs(int idx) {
		
     		if(idx == N) {
  			int cal = 0, score=0;
			for(int i=0; i<N; i++) {
				if(used[i]) {
					score += arr[i][0];
 					cal += arr[i][1];
 					if(cal<=L) { continue;
 					}
				}
			}
			if(cal<=L && score>=max)
				max = score;
			return;
		}
		
		used[idx] = true;
		dfs(idx+1);
 		used[idx] = false;
 		dfs(idx+1);
		
	}

}
