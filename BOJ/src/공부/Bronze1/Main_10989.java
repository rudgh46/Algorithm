package 공부.Bronze1;

import java.util.*;
import java.io.*;

public class Main_10989 { // 수 정렬하기3

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Radix_sort(arr, 5);
//		StringBuilder sb = new StringBuilder();
		br.close();
		for(int i=0; i<N; i++) {
//			sb.append(arr[i]+"\n");
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
//		System.out.println(sb);
	}

	private static void Radix_sort(int[] arr, int max_size) {
		int output[] = new int[arr.length];
		int digit = 1;
		int cnt = 0;
		while (cnt != max_size) {
			int bucket[] = new int[10];
			for(int i=0; i<arr.length; i++) {
				bucket[(arr[i]/digit) % 10]++;
			}
			for(int i=1; i<10; i++) {
				bucket[i] += bucket[i-1];
			}
			for(int i=arr.length-1; i>=0; i--) {
				output[bucket[arr[i] / digit % 10]-1] = arr[i];
				bucket[(arr[i] / digit)%10]--;
			}
			for(int i=0; i<arr.length; i++) {
				arr[i] = output[i];
			}
			digit*=10;
			cnt++;
		}
	}

}
