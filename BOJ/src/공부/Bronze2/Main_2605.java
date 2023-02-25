package 공부.Bronze2;

import java.util.ArrayList;
import java.util.Scanner;
/*
  [입력]
첫째 줄에는 학생의 수가 주어지고 둘째 줄에는 줄을 선 차례대로 학생들이 뽑은 번호가 주어진다. 
학생의 수가 100 이하이고, 학생들이 뽑는 번호는 0 또는 자연수이며 학생들이 뽑은 번호 사이에는 빈 칸이 하나씩 있다.

  [출력]
학생들이 처음에 줄을 선 순서대로 1번부터 번호를 매길 때, 첫째 줄에 학생들이 최종적으로 줄을 선 순서를 그 번호로 출력한다. 
학생 번호 사이에는 한 칸의 공백을 출력한다.
 */
public class Main_2605 { //줄 세우기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			list.add(i-num,i+1);
		}
		for(int i=0; i<N; i++) {
			System.out.print(list.get(i)+" ");
		}
	}

}
