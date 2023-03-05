package 공부.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845 { // 큐

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>(); 
		StringBuilder sb = new StringBuilder();
		int num = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch (order) {
			case "push":
				num = Integer.parseInt(st.nextToken());
				q.add(num);
				break;
			case "pop":
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(q.poll()+"\n");
				break;
			case "size":
				sb.append(q.size()+"\n");
				break;
			case "empty":
				if(q.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "front":
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(q.peek()+"\n");
				break;
			case "back":
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(num + "\n");
				break;
			default:
				sb.append("error\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
