package 공부.Gold4;

import java.util.*;
import java.io.*;

public class Main_17298 { //오큰수

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int arr[] = new int[N];
		int ans[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(0);
		
		for(int i=1; i<N; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				ans[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	}

}
