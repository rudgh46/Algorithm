package 공부.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10809 { // 알파벳 찾기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int cnt[] = new int[26];
		Arrays.fill(cnt, -1);
		for(int i=0; i<str.length(); i++) {
			if(cnt[str.charAt(i)-'a'] == -1) {
				cnt[str.charAt(i)-'a'] = i;
			}
		}

		for (int i : cnt) {
			System.out.print(i + " ");
		}
	}

}
