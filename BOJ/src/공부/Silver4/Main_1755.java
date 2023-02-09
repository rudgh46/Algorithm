package 공부.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1755 {

	public static class Node implements Comparable<Node>{
		String s;
		int n;
		
		public Node(String s, int n) {
			super();
			this.s = s;
			this.n = n;
		}

		@Override
		public int compareTo(Node o) {
			return s.compareTo(o.s);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		for(int i=M; i<=N; i++) {
			String s = "";
			if(i<10) {
				s = num[i];
			} else {
				s += num[i/10];
				s += " ";
				s += num[i%10];
			}
			q.offer(new Node(s,i));
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			cnt++;
			System.out.print(node.n+" ");
			if(cnt%10==0) System.out.println();
		}
		
	}
}