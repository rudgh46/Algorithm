package 공부.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1032 { //명령 프롬프트

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String arr[] = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		
		boolean same = true;
		
		for(int i=0; i<arr[0].length(); i++) {
			char c = arr[0].charAt(i);
			
			same = true;
			for(int j=1; j<N; j++) {
				if(c != arr[j].charAt(i)) {
					same=false;
					break;
				}
			}
			if(same) {
				sb.append(c);
			}else
				sb.append("?");
		}
		System.out.println(sb.toString());
	}

}
