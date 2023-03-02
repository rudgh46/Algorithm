package 공부.Bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10798 { //세로읽기

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String arr[][] = new String[15][15];
		
		for(int i=0; i<15; i++) {
			Arrays.fill(arr[i], "-1");
		}
		
		for(int i=0; i<15; i++) {
			String[] str = sc.next().split("");
			for(int j=0; j<str.length; j++) {
				arr[i][j] = str[j];
			}
			if(!sc.hasNext()) break;
		}
		
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				if(arr[j][i] != "-1") 
					System.out.print(arr[j][i]);
			}
		}
	}

}
