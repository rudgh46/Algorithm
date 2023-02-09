package 공부.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1157 {//단어 공부

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int arr[] = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			if('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				arr[str.charAt(i)-'a']++;				
			}else {
				arr[str.charAt(i)-'A']++;				
			}
		}
		
		int max = Integer.MIN_VALUE;
		char ch = '?';
		for(int i=0; i<26; i++) {
			if(arr[i]>max) {
				max = arr[i];
				ch = (char)(i+'A');
			}
			else if(arr[i] == max) {
				ch = '?';
			}
		}
		System.out.println(ch);
		
	}

}
