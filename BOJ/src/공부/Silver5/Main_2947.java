package 공부.Silver5;

import java.util.Scanner;
/*
  [입력]
첫째 줄에 조각에 쓰여 있는 수가 순서대로 주어진다. 숫자는 1보다 크거나 같고, 5보다 작거나 같으며, 중복되지 않는다. 
처음 순서는 1, 2, 3, 4, 5가 아니다.

  [출력]
두 조각의 순서가 바뀔때 마다 조각의 순서를 출력한다.
 */
public class Main_2947 { //나무 조각

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					for(int k=0; k<5; k++) {
						System.out.print(arr[k] + " ");
					}
					System.out.println();
				}
			}
		}

	}

}
