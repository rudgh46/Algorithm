package 공부.Silver5;

import java.io.*;

public class Main_1427 { //소트인사이드

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		int arr[] = new int[num.length()];
		
		for(int i=0; i<num.length(); i++) {
			arr[i] = num.charAt(i)-'0';
		}
		
		for(int i=0; i<num.length(); i++) {
			int max = i;
			for(int j=i+1; j<num.length(); j++) {
				if(arr[j]>arr[max]) max = j;
			}
			if(arr[i] < arr[max]) {
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
		}
		for(int i=0; i<num.length(); i++) {
			System.out.print(arr[i]);
		}
	}
}


