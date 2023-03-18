package 공부.Silver2;

import java.io.*;
import java.util.*;

public class Main_1406 { //에디터

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int length = str.length();
		int M = Integer.parseInt(br.readLine());
		
		Stack<Character> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();
		
		
		for(int i=0; i<length; i++) {
			st1.push(str.charAt(i));
		}
		
		for(int i=0; i<M; i++) {
			String cmd = br.readLine();
			char c = cmd.charAt(0);
			
			switch(c) {
			case 'L':
				if(!st1.isEmpty()) {
					st2.push(st1.pop());
				}
				break;
			case 'D':
				if(!st2.isEmpty()) {
					st1.push(st2.pop());
				}
				break;
			case 'B':
				if(!st1.isEmpty()) {
					st1.pop();
				}
				break;
			case 'P':
				char ch = cmd.charAt(2);
				st1.push(ch);
				break;
			default:
				break;
			}
		}
		
		while(!st1.isEmpty()) {
			st2.push(st1.pop());
		}
		StringBuilder sb = new StringBuilder();
		while(!st2.isEmpty()) {
			sb.append(st2.pop());
		}
		System.out.println(sb);
	}

}
