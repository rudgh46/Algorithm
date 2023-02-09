package 공부.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 탑의 수를 나타내는 정수 N이 주어진다. N은 1 이상 500,000 이하이다. 
둘째 줄에는 N개의 탑들의 높이가 직선상에 놓인 순서대로 하나의 빈칸을 사이에 두고 주어진다. 
탑들의 높이는 1 이상 100,000,000 이하의 정수이다.

 */
public class Main_2493 { //탑

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();	//탑 높이 스택
		Stack<Integer> idx = new Stack<>();		//탑 높이 스택의 인덱스 번호 스택
		int size[] = new int[N];				//탑 높이 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<N; i++) {
			size[i] = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) {	//가장 왼쪽 탑, 출력 0 후 stack에 탑 높이 저장, idx에 stack 인덱스 저장
				System.out.print("0 ");
				stack.push(size[i]);
				idx.push(i+1); //0부터 시작이라 +1 해줌
			}else {
				while(true) {
					if(stack.isEmpty()) {
						System.out.print("0 ");
						stack.push(size[i]);
						idx.push(i+1);
						break;
					}
					if(stack.peek()>size[i]) {
						System.out.print(idx.peek()+" "); //현재 탑보다 높으면 높은 탑의 idx 출력 후 stack에 저장
						stack.push(size[i]);
						idx.push(i+1);
						break;
					}else {
						stack.pop();	//현재 탑보다 작은 탑 빼주기
						idx.pop();		
					}
				}
			}
		}
		
	}

}
