package 공부.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 { //N과 M(2) //N과 M(1) 문제 풀이 거의 동일

	public static int N,M;
	public static StringBuilder sb = new StringBuilder();
	public static int arr[];
	public static boolean visit[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N];
		
		dfs(0);
		System.out.println(sb);
	}
	public static void dfs(int depth) {
		
		if(depth == M) {
			for(int i=0; i<M-1; i++) { //오름차순,중복 수열 출력X
				if(arr[i]>arr[i+1]) {
					return;
				}
			}
			for(int value : arr) {
				sb.append(value).append(' ');
			}sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}

}
