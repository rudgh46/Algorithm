package 공부.Gold5;

import java.util.*;
import java.io.*;

public class Main_13023 { //ABCDE
	
	static boolean visit[];
	static boolean arrive;
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arrive = false;
		
		A = new ArrayList[N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			A[a].add(b);
			A[b].add(a);
		}
		
		for(int i=0; i<N; i++) {
			dfs(i,1);
			if(arrive) break;
		}
		if(arrive) System.out.println("1");
		else System.out.println("0");
	}

	private static void dfs(int now, int depth) {
		if(depth == 5 || arrive) {
			arrive = true;
			return;
		}
		visit[now] = true;
	
		for(int i:A[now]) {
			if(!visit[i]) {
				dfs(i,depth+1);
			}
		}
		visit[now] = false;

	}
}
