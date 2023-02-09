package 공부.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724 {
	
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken()); 
			int v = Integer.parseInt(st.nextToken());
			arr[u][v] = 1;
			arr[v][u] = 1;
		}
		
		boolean visit[] = new boolean[N+1];
		
		int cnt=0;
		
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {
				dfs(i,arr,visit);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int start, int[][] arr, boolean[] visit) {
		visit[start] = true;
		
		for(int i=1; i<=N; i++) {
			if(arr[start][i]==1 && !visit[i]) {
				dfs(i,arr,visit);
			}
		}
	}
}
