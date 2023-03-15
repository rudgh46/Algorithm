package 공부.Silver4;

import java.io.*;
import java.util.*;

public class Main_9012 { // 괄호
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		Stack<Character> stack = new Stack();
		String s = sc.nextLine();

		for (int i = 0; i < T; i++) {
			s = sc.nextLine();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (stack.isEmpty())
					stack.push(c);
				else {
					if (c == ')') {
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							stack.push(c);
						}
					} else {
						stack.push(c);
					}
				}
			}
			if (stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			stack.clear();
		}
	}

}
