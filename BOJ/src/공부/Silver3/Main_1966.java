package 공부.Silver3;

import java.util.*;

public class Main_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Queue<int[]> q = new LinkedList<>();
			int cnt =0;
			
			for(int i=0; i<N; i++) {
				q.add(new int[] {i, sc.nextInt()});
			}
			
			while(true) {
				int cur[] = q.remove();
				boolean flag = true;
				
				for(int arr[] : q) {
					if(arr[1] > cur[1]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					cnt++;
					if(cur[0] == M ) break;
				} else {
					q.add(cur);
				}
			}
			System.out.println(cnt);
			
		}
	}

}
