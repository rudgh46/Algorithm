package 공부.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828 { //스택

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch (order) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "top":
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.peek()+"\n");
				break;
			case "size":
				sb.append(stack.size()+"\n");
				break;
			case "empty":
				if(stack.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "pop":
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.pop()+"\n");
				break;
			default:
				sb.append("error\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
