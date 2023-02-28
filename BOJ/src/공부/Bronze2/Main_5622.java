package 공부.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5622 { // 다이얼

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char arr[][] = {
			{2,' ',' ',' ',' '},
			{3,'A','B','C',' '},
			{4,'D','E','F',' '},
			{5,'G','H','I',' '},
			{6,'J','K','L',' '},
			{7,'M','N','O',' '},
			{8,'P','Q','R','S'},
			{9,'T','U','V',' '},
			{10,'W','X','Y','Z'},
			{11,' ',' ',' ',' '}
		};
		String str = br.readLine();
		int time = 0;
		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<10; j++) {
				for(int k=1; k<5; k++) {
					if(str.charAt(i) == arr[j][k]) {
						time += arr[j][0];
					}
				}
			}
		}
		System.out.println(time);
	}

}
