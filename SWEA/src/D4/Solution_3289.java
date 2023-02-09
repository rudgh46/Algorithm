package D4;
import java.util.Scanner;
/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫째 줄에 n(1≤n≤1,000,000), m(1≤m≤100,000)이 주어진다.
m은 입력으로 주어지는 연산의 개수이다.
다음 m개의 줄에는 각각의 연산이 주어진다.
합집합은 0 a b의 형태로 입력이 주어진다.
이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.
두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
a와 b는 n 이하의 자연수이며 같을 수도 있다.

[출력]
각 테스트 케이스마다 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력한다.
 */
public class Solution_3289 {//서로소 집합

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int arr[] = new int[n+1];
			
			for(int i=0; i<n; i++) {
				arr[i] = i;
			}
			
			int m = sc.nextInt(); //연산의 개수

			System.out.print("#"+tc+" ");
			for(int i=0; i<m; i++) {
				int check = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(check == 1) {
					if(find(arr,a,b)) System.out.print(1);
					else System.out.print(0);
				}else union(arr,a,b);
				
			}System.out.println();
			
			
			}

	}
	
	public static int findSet(int p[], int x) {
		if(x==p[x]) return x;
		else return p[x] = findSet(p, p[x]);
	}
	
	public static void union(int p[], int x, int y) {
		x = findSet(p,x);
		y = findSet(p,y);
		
		if(x>y)	p[x] = y;
		else p[y] = x;
	}
	
	public static boolean find(int p[], int x, int y) {
		return (findSet(p,x) == findSet(p,y));
	}

}
