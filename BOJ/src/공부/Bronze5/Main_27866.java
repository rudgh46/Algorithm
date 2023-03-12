package 공부.Bronze5;

import java.io.*;

public class Main_27866 { //문자와 문자열

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		System.out.println(str.charAt(Integer.parseInt(br.readLine())-1));
		
		
	}

}
