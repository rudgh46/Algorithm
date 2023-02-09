package 공부.Gold4;

import java.util.Scanner;
import java.util.Stack;

public class Main_9935 { //문자열 폭발

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); //입력 문자열
		String boom = sc.next(); //폭발 문자열
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i)); //문자열을 하나씩 스택에 넣기
			if(stack.size() >= boom.length()) { //스택 사이즈가 폭발 문자열보다 크면
				boolean check = true; //폭발 문자열 존재하는지 체크
				
				for(int j=0; j<boom.length(); j++) { // 폭발 문자열 길이만큼
					if(stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {//스택길이 - 폭발길이 부터 탐색, 폭발 문자열과 다르면 break
						check = false;
						break;
					}
				}
				
				if(check) {//폭발 문자열 존재하면 pop
					for(int j=0; j<boom.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char ch : stack) {
			sb.append(ch);
		}
		
		System.out.println(sb.length() != 0 ? sb.toString() : "FRULA");
	}
}
