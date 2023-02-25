package 공부.Silver2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
  [입력]
첫 줄에는 기둥의 개수를 나타내는 정수 N이 주어진다. N은 1 이상 1,000 이하이다. 
그 다음 N 개의 줄에는 각 줄에 각 기둥의 왼쪽 면의 위치를 나타내는 정수 L과 높이를 나타내는 정수 H가 한 개의 빈 칸을 사이에 두고 주어진다. 
L과 H는 둘 다 1 이상 1,000 이하이다.

  [출력]
첫 줄에 창고 다각형의 면적을 나타내는 정수를 출력한다.
 */
public class Main_2304 {//창고 다각형

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<top> arr = new ArrayList<>();
		
		int N = sc.nextInt();

		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr.add(new top(x,y));
		}
		Collections.sort(arr);

		int max = 0;
		int ans = 0;
		
		top curTop = arr.get(0);
		for(int i=1; i<N; i++) {
			if(curTop.y <= arr.get(i).y) {
				ans += (arr.get(i).x-curTop.x) * curTop.y;
				curTop = arr.get(i);
				max = i;
			}
		}
		
		curTop = arr.get(N-1);
		for(int i=0; i<N-max; i++) {
			if(curTop.y <= arr.get(N-i-1).y) {
				ans += (curTop.x-arr.get(N-i-1).x) * curTop.y;
				curTop = arr.get(N-i-1);
			}
		}
		ans += curTop.y;
		System.out.println(ans);
		
	}
	
	static class top implements Comparable<top>{
		int x;
		int y;
		
		public top(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(top o) {
			return this.x - o.x;
		}
		
	}

}
