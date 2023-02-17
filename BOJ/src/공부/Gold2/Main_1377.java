package 공부.Gold2;

import java.util.*;
import java.io.*;

public class Main_1377 { //버블소트
	
	public static class arr implements Comparable<arr>{
		int value;
		int index;
		
		public arr(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}
		
		@Override
		public int compareTo(arr o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr[] mat = new arr[N];
		for(int i=0; i<N; i++) {
			mat[i] = new arr(Integer.parseInt(br.readLine()), i);	
		}
		Arrays.sort(mat);
		
		int Max = 0;
		
		for(int i=0; i<N; i++) {
			if(Max<mat[i].index - i) Max = mat[i].index - i;
		}
		System.out.println(Max+1);
	}

}
