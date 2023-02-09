package 공부.Gold5;

import java.util.Scanner;

public class Main_5639 { //이진 검색 트리
	
	static int tree[] = new int[10001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i=0;
		
		while(sc.hasNext()) {
			tree[i++] = sc.nextInt();
		}
		postOrder(0, i-1);
	}
	
	private static void postOrder(int n, int end) {
		if (n>end) return;
		
		int mid = n+1;
		while(mid <= end && tree[mid] < tree[n]) {
			mid++;
		}
		
		postOrder(n+1, mid-1);
		postOrder(mid, end);
		System.out.println(tree[n]);
	}

}
