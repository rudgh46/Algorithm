package 공부.Bronze2;
import java.util.Arrays;
import java.util.Scanner;

/*
  [입력]
아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 
주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 
가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
 */
public class Main_2309 { // 일곱난쟁이

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height[] = new int[9];

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
			sum += height[i]; //난쟁이 키 총합
		}
		Arrays.sort(height); //난쟁이 정렬
		
		Loop:
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - height[i] - height[j] == 100) { //총 난쟁이 합에서 가짜 난쟁이 키 빼주면 100이 되야함, 가짜 난쟁이 0으로 만들기
					height[i] = 0;
					height[j] = 0;
					break Loop;
				}
			}
		}
		
		
		for (int i = 0; i < 9; i++) {
			if (height[i] != 0)
				System.out.println(height[i]);
		}
	}

}
