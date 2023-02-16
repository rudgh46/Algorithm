package 공부.Silver2;

import java.util.*;
import java.io.*;

public class Main_1874 { //스택 수열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> st = new Stack<>();
		
		int num = 1;
		boolean res = true;
		
		for(int i=0; i<arr.length; i++) {
			int cur = arr[i];
			
			if(cur>=num) {
				while(cur>=num) {
					st.push(num++);
					sb.append("+\n");					
				}
				st.pop();
				sb.append("-\n");
			}else {
				int n = st.pop();
				
				if(n>cur) {
					System.out.println("NO");
					res = false;
					break;
				} else {
					sb.append("-\n");
				}
			}
		}
		if(res) System.out.println(sb);
	}

}
