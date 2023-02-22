package 공부.Platinum5;

import java.util.*;
import java.io.*;

public class Main_1517 { // 버블소트
	
	static int[] arr,tmp;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		tmp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;

		merge_sort(1, N);
		System.out.println(ans);
	}

	private static void merge_sort(int start, int end) {
		if(end - start < 1) return;
		
		int mid = start + (end - start) / 2;
		
		merge_sort(start, mid);
		merge_sort(mid+1, end);
		
		for(int i=start; i<=end; i++) {
			tmp[i] = arr[i];
		}
		
		int k = start;
		int index1 = start;
		int index2 = mid + 1;
		
		while(index1 <= mid && index2 <= end) {
			if(tmp[index1] > tmp [index2]) {
				arr[k] = tmp[index2];
				ans = ans + index2 - k;
				k++;
				index2++;
			} else {
				arr[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while(index1 <= mid) {
			arr[k] = tmp[index1];
			k++;
			index1++;
		}
		while(index2 <= end) {
			arr[k] = tmp[index2];
			k++;
			index2++;
		}
	}

}
