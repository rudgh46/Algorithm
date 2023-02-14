package 공부.Silver2;

import java.util.*;
import java.io.*;

public class Main_12891 { //DNA 비밀번호
	static int cur[];
	static int check[];
	static int checkPass;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char dna[] = new char[S];
		check = new int[4];
		cur = new int[4];
		checkPass = 0;
		int ans = 0;
		
		dna = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
			if(check[i] == 0) checkPass++;
		}
		
		for(int i=0; i<P; i++) {
			Add(dna[i]);
		}
		if(checkPass == 4) ans++;
		
		for(int i=P; i<S; i++) {
			int j = i-P;
			Add(dna[i]);
			Remove(dna[j]);
			if(checkPass == 4) ans++;
		}
		System.out.println(ans);
	}

	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if(cur[0] == check[0])
				checkPass--;
			cur[0]--;
			break;
		case 'C':
			if(cur[1] == check[1])
				checkPass--;
			cur[1]--;
			break;
		case 'G':
			if(cur[2] == check[2])
				checkPass--;
			cur[2]--;
			break;
		case 'T':
			if(cur[3] == check[3])
				checkPass--;
			cur[3]--;
			break;
		}
	}

	private static void Add(char c) {
		switch(c) {
		case 'A':
			cur[0]++;
			if(cur[0] == check[0])
				checkPass++;
			break;
		case 'C':
			cur[1]++;
			if(cur[1] == check[1])
				checkPass++;
			break;
		case 'G':
			cur[2]++;
			if(cur[2] == check[2])
				checkPass++;
			break;
		case 'T':
			cur[3]++;
			if(cur[3] == check[3])
				checkPass++;
			break;
		}
	}

}
