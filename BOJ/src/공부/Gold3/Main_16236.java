package 공부.Gold3;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
  [입력]
첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.
둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.

0: 빈 칸
1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
9: 아기 상어의 위치

아기 상어는 공간에 한 마리 있다.

  [출력]
첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.
 */
public class Main_16236 { //아기 상어 뚜루루뚜루
	
	static int deltas[][] = { //상어 움직임 : 상 하 좌 우
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}};
	static int map[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int size = 2;
		int time = 0;
		int eat = 0;
		
		int cur[] = null;
		map = new int[N][N];
		
		
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					cur = new int[] {i,j};
					map[i][j] = 0;
				}
			}
		
		
		while(true) {
			PriorityQueue<int[]> queue = new PriorityQueue<>(
					(o1,o2) ->	o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : 
						(o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : 
							Integer.compare(o1[1], o2[1])));
			
			boolean visit[][] = new boolean[N][N];
			
			queue.add(new int[] {cur[0], cur[1], 0});
			
			visit[cur[0]][cur[1]] = true;
			
			boolean check = false;
			
			while(!queue.isEmpty()) {
				cur = queue.poll();
				
				if(map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) {
					map[cur[0]][cur[1]] = 0;
					eat++;
					time += cur[2];
					check = true;
					break;
				}
				
				for(int d=0; d<4; d++) {
					int dy = cur[0] + deltas[d][1];
					int dx = cur[1] + deltas[d][0];
					
					if(dy < 0 || dx < 0 || dx >=N || dy >= N || visit[dy][dx] || map[dy][dx] > size) continue;
					
					queue.add(new int[] {dy, dx, cur[2]+1});
					visit[dy][dx] = true;	
				}
			}
			if(!check) break;
			
			if(size == eat) {
				size++;
				eat = 0;
			}
		}
		
		System.out.println(time);
		

	}

}