package 공부.Silver5;

import java.util.*;
import java.io.*;

public class Main_25206 { //너의 평점은

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		double sumGrade = 0;
		String grade[][] = new String[20][2];
		
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			grade[i][0] = st.nextToken();
			grade[i][1] = st.nextToken();
			
			if(!grade[i][1].equals("P")) {
				sum += cal(Double.parseDouble(grade[i][0]),grade[i][1]);
				sumGrade += Double.parseDouble(grade[i][0]);
			}
		}
		if(sum != 0) {
			sum /= sumGrade;
		}
		System.out.printf("%f",sum);
		
	}

	private static double cal(double score, String grade) {
		double sum = 0;
		
		switch(grade) {
		case "A+":
			sum = score * 4.5;
			break;
		case "A0":
			sum = score * 4.0;
			break;
		case "B+":
			sum = score * 3.5;
			break;
		case "B0":
			sum = score * 3.0;
			break;
		case "C+":
			sum = score * 2.5;
			break;
		case "C0":
			sum = score * 2.0;
			break;
		case "D+":
			sum = score * 1.5;
			break;
		case "D0":
			sum = score * 1.0;
			break;
		}
		return sum;
	}

}
