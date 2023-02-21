package 공부.Silver5;

import java.util.*;
import java.io.*;

public class Main_11004 {// K번째 수
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int n =Integer.parseInt(st.nextToken());
		 int k = Integer.parseInt(st.nextToken());
		 List<Integer> list = new ArrayList<>();
		 
		 st = new StringTokenizer(br.readLine());
		 for(int i=0;i<n;i++) {
			 list.add(Integer.parseInt(st.nextToken()));
			 
		 }
		 Collections.sort(list);
		 
		 
		 System.out.println(list.get(k-1));
	     
		
			
	       
	}

}
