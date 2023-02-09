package 공부.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958 { //OX퀴즈

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int score = 0;
			int sum = 0;
			String ox = br.readLine();
			for(int i=0; i<ox.length(); i++) {
				if(ox.charAt(i) == 'O') {
					score++;
				}else if(ox.charAt(i) == 'X'){
					score = 0; 
				}
				sum += score;
			}
			System.out.println(sum);
			
		}
	}

}
