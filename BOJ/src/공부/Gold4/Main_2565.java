package 공부.Gold4;

import java.util.*;

public class Main_2565 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int line[][] = new int[N][2];
		
		for(int i=0; i<N; i++) {
			line[i][0] = sc.nextInt();
			line[i][1] = sc.nextInt();
		}
		
		Arrays.sort(line, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i=1; i<=N; i++) {
			
		}
		
	}

}
