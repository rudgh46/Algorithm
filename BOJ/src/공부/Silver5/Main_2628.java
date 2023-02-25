package 공부.Silver5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
  [입력]
첫줄에는 종이의 가로와 세로의 길이가 차례로 자연수로 주어진다. 가로와 세로의 길이는 최대 100㎝이다. 
둘째 줄에는 칼로 잘라야하는 점선의 개수가 주어진다. 
셋째 줄부터 마지막 줄까지 한 줄에 점선이 하나씩 아래와 같은 방법으로 입력된다. 
가로로 자르는 점선은 0과 점선 번호가 차례로 주어지고, 세로로 자르는 점선은 1과 점선 번호가 주어진다. 
입력되는 두 숫자 사이에는 빈 칸이 하나씩 있다.

  [출력]
첫째 줄에 가장 큰 종이 조각의 넓이를 출력한다. 단, 넓이의 단위는 출력하지 않는다.
 */
public class Main_2628 { //종이자르기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		int N = sc.nextInt();
		List<Integer> cutW = new ArrayList<Integer>();
		List<Integer> cutH = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			int cut = sc.nextInt();
			
			if(cut == 0) {
				cutW.add(sc.nextInt()); //가로로 자르기
			}
			else {
				cutH.add(sc.nextInt()); //세로로 자르기
			}
		}
		cutW.add(H);
		cutH.add(W);
		cutW.add(0);
		cutH.add(0);
		
		Collections.sort(cutW);
		Collections.sort(cutH);
		

		int w = 0, h = 0;
		
		for(int i=0; i<cutW.size()-1; i++) {
			int temp = cutW.get(i+1) - cutW.get(i);
			if(w<temp) {
				w = temp;
			}
		}
		
		for(int i=0; i<cutH.size()-1; i++) {
			int temp = cutH.get(i+1) - cutH.get(i);
			if(h<temp) {
				h = temp;
			}
		}

		System.out.println(h*w);
		
	}

}
