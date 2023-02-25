package 공부.Silver4;

import java.util.Scanner;

public class Main_1543 { //문서 검색

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String doc = sc.nextLine();
		String word = sc.nextLine();
		int cnt = 0;
		
		for(int i=0; i<doc.length()-word.length()+1; i++) {
			if(doc.substring(i,i+word.length()).equals(word)) {
				cnt++;
				i+=(word.length()-1);
			}
		}
		
		System.out.println(cnt);
	}

}
