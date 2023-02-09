package 공부.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773 {// 제로

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		int sum = 0;
		
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) { // 0이면 빼기
				stack.pop();
			} else { //0 아니면 넣기
				stack.push(num);
			}
		}
		
		for(int i: stack) { //stack 값들 더하기
			sum += i;
		}
		
		System.out.println(sum);
	}

}
