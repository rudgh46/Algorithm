package 공부.Gold5;

import java.util.Scanner;

public class Main_12865 { // 평범한 배낭

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); //물품의 수
		int K = sc.nextInt(); //버틸수 있는 무게

		int W[] = new int[N + 1]; //물건의 무게
		int V[] = new int[N + 1]; //물건의 가치

		int result[][] = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}
		
		int weight = 0;
		int value = 0;

		for (int i = 1; i <= N; i++) {
			weight = W[i]; //현재 무게
			value = V[i]; //현재 가치

			for (int j = 1; j <= K; j++) { //1부터 목표 무게까지
				if (weight <= j) { //담을 수 있는 상황
					//담는 상황과 담지 않는 상황 중 최대
					//담지 않는 경우 : 직전 물건까지 무게를 만족히는 최적해
					//담는 경우 : 현재 물건 가치 + 직전 물건의 [현재 무게 - 현재 물건의 무게]
					result[i][j] = Math.max(result[i - 1][j], value + result[i - 1][j - weight]);
				} else {//담을 수 없는 상황
					//직전 물건까지 무게를 만족하는 최적해
					result[i][j] = result[i - 1][j];
				}
			}
		}
		System.out.println(result[N][K]); //N물건까지 K의 무게를 만드는 최적해

	}

}
