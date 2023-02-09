package IM_Test.Bronze1;
import java.util.Scanner;

/*
  [입력]
첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
 */
public class Main_2839 {//설탕배달

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //설탕 무게
		int count = 0;	//봉지 수 카운트
		while(true) {
			if(N%5 == 0) {
				count += (N / 5);
				System.out.println(count);
				break;
			}
			else {
				N -= 3;
				count++;
			}
			if(N<0) {
				System.out.println("-1");
				break;
			}
		}
	}

}
