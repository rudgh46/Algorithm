package 공부.Gold3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_23743 { //방탈출

	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int N, M, parents[];
	static List<Edge> edgeList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int[N+1];
		edgeList = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt(); //a방 번호
			int b = sc.nextInt(); //b방 번호
			int c = sc.nextInt(); //a방과 b방을 잇는 워프를 설치하는데 걸리는 시간
			edgeList.add(new Edge(a, b, c));
		}
		
		for(int i=1; i<=N; i++) {
			int t = sc.nextInt();
			edgeList.add(new Edge(i,0,t)); //i 에서 0(출구)으로
		}
		
		Collections.sort(edgeList);
		makeSet();
		
		int ans = 0;
		int cnt = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				ans += edge.weight;
				cnt++;
				if(cnt == N) break;
			}
		}
		
		System.out.println(ans);
	}

	private static void makeSet() {
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

}
