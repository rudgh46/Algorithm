package 공부.Platinum5;

import java.util.*;
import java.io.*;

public class Main_11003 { // 최솟값 찾기
	
	public static class Node{
		int value;
		int index;
		
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Deque<Node> dq = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!dq.isEmpty() && dq.getLast().value > now) {
				dq.removeLast();
			}
			dq.addLast(new Node(now, i));
			
			if(dq.getFirst().index <= i-L) {
				dq.removeFirst();
			}
			
			sb.append(dq.getFirst().value).append(" ");
		}
		System.out.println(sb);
	}

}
