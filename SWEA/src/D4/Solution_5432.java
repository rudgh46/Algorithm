package D4;
import java.util.Scanner;

/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.
 */
public class Solution_5432 { // 쇠막대기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 int T = sc.nextInt();
		 for(int test=1; test<=T; test++) {
			 String line = sc.next();
			 int result = 0;
			 int metalRod = 0;
			 int count = 0;
			 char laserMetal[] = new char[line.length()];
			 for(int i=0; i<line.length(); i++) {
				 laserMetal[i] = line.charAt(i);
			 }
			 
			 for(int i=0; i<line.length()-1; i++) {
				 for(int j=i; j<line.length(); j++) {
					 if(laserMetal[i] == '(' && laserMetal[j] == ')') {
						 if(i>0 && j<laserMetal.length && laserMetal[i-1]=='(' && laserMetal[j]==')') {
							 laserMetal[i] = '0';
							 laserMetal[j] = '0';
							 count++; 
						 }
					 }
				 }
			 }
			 System.out.println(count);
		 }

	}

}
