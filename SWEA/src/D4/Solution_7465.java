package D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 각각 창용 마을에 사는 사람의 수와 서로를 알고 있는 사람의 관계 수를 나타내는
두 정수 N, M(1 ≤ N ≤ 100, 0 ≤ M ≤ N(N-1)/2) 이 공백 하나로 구분되어 주어진다.
이후 M개의 줄에 걸쳐서 서로를 알고 있는 두 사람의 번호가 주어진다.
같은 관계는 반복해서 주어지지 않는다.

[출력]
각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
무리의 개수를 출력한다.
 */
public class Solution_7465 { //창용 마을 무리의 개수
	
	static int N,M,arr[],res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		================================  입력   =====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			res = N;
			
			makeSet();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
//		================================  풀이   =====================================
				if(union(a,b)) {
					
					res--;
				}
			}
			
//		================================  출력   =====================================
			sb.append("#").append(tc).append(" ").append(res).append("\n");
			
		}
		System.out.println(sb);

	}
	
//	===========  makeSet  ===========
	public static void makeSet() {
		arr = new int[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = i;
		}
	}
	
//	===========  findSet  ===========
	public static int findSet(int a) {
		if(a==arr[a]) return a;
		return arr[a] = findSet(arr[a]);
	}
	
//	===========  union  ===========
	public static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		arr[bRoot] = aRoot;
		return true;
	}

}
