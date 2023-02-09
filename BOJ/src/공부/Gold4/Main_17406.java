package 공부.Gold4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 배열 A의 크기 N, M, 회전 연산의 개수 K가 주어진다.
둘째 줄부터 N개의 줄에 배열 A에 들어있는 수 A[i][j]가 주어지고, 다음 K개의 줄에 회전 연산의 정보 r, c, s가 주어진다.
  [제한]
3 ≤ N, M ≤ 50
1 ≤ K ≤ 6
1 ≤ A[i][j] ≤ 100
1 ≤ s
1 ≤ r-s < r < r+s ≤ N
1 ≤ c-s < c < c+s ≤ M
 */
public class Main_17406 { //배열돌리기4
	
	static int N,M,K,r,c,s,arr[][],arr2[][],turn[][],permutation[];
	static int res = Integer.MAX_VALUE;
	static boolean visit[];
	static int deltas[][] = { //하 우 상 좌
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		K = Integer.parseInt(st.nextToken()); // 회전연산 개수
		
		arr = new int[N][M];
		arr2 = new int[N][M];
		turn = new int[K][3];
		visit = new boolean[K];
		permutation = new int[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				arr2[i][j] = arr[i][j];
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			turn[i][0] = r;
			turn[i][1] = c;
			turn[i][2] = s;
		}
		
		permutation(0);
		
		System.out.println(res);
	}
	
	public static void permutation(int cnt) {
		if(cnt == K) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					arr[i][j] = arr2[i][j];
				}
			}
			for(int i=0; i<K; i++) {
				r = turn[permutation[i]][0];
				c = turn[permutation[i]][1];
				s = turn[permutation[i]][2];
				move(r,c,s);
			}
			int temp = arrValue(arr);
			if(res>temp) {
				res = temp;
			}
			return;
		}
		for(int i=0; i<K; i++) {
			if(visit[i]==false) {
				visit[i]=true;
				permutation[cnt]=i;
				permutation(cnt+1);
				visit[i]=false;
				permutation[cnt]=0;
			}
		}
	}
	
	public static void move(int r, int c, int s) {
		for(int count=0; count<s; count++) {
			int i = r-s-1+count;
			int j = c-s-1+count;
			int start = arr[i][j];
			int d=0;
			while(d<4) {
				int dx = i + deltas[d][0];
				int dy = j + deltas[d][1];
				
				if(dx >= r-s-1+count && dx<r+s-count && dy>= c-s-1+count && dy< c+s-count) {
					arr[i][j] = arr[dx][dy];
					i = dx;
					j = dy;
				}
				else d++;
			}
			arr[r-s-1+count][c-s+count] = start;
		}
	}
	
	public static int arrValue(int arr[][]) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			int temp=0;
			for(int j=0; j<arr[i].length; j++) {
				temp += arr[i][j];
			}
			if(temp<min) {
				min = temp;
			}
		}
		return min;
	}
}
