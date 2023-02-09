package 공부.Gold4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
  [입력]
첫째 줄에는 사각형 모양 판의 세로와 가로의 길이가 양의 정수로 주어진다. 세로와 가로의 길이는 최대 100이다. 
판의 각 가로줄의 모양이 윗 줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다. 
치즈가 없는 칸은 0, 치즈가 있는 칸은 1로 주어지며 각 숫자 사이에는 빈칸이 하나씩 있다.

  [출력]
첫째 줄에는 치즈가 모두 녹아서 없어지는 데 걸리는 시간을 출력하고, 
둘째 줄에는 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 출력한다.
 */
public class Main_2638 { //치즈
	
	public static int R, C, cheese, cnt, time, map[][];
	public static boolean visited[][];
	public static int deltas[][] = { //4방 탐색
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //맵 세로
		C = Integer.parseInt(st.nextToken()); //맵 가로
		cnt = 0; //모두 녹기 전 남아있는 치즈조각 수
		time = 0; //모두 녹는데 걸리는 시간
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++; //치즈있으면 카운트
			}
		}
		
		while(cheese != 0) { //치즈가 0일때까지 탐색
			cnt = cheese;
			time++;
			for(boolean a[]:visited) Arrays.fill(a, false); //2차원 배열 visited false로 초기화
			bfs();
		}
//		System.out.println(time);
		System.out.println(cnt-time+1);
		
	}


	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int start[] = {0,0}; //시작 0,0부터
		q.offer(start);
		visited[0][0] = true; //0,0 방문체크
		
		while(!q.isEmpty()) {
			int cur[] = q.poll(); //현위치
			
			for(int i=0; i<4; i++) {//탐색
				int dx = cur[0]+deltas[i][0];
				int dy = cur[1]+deltas[i][1];
				
				if(dx>=0 && dy>=0 && dx<R && dy<C && visited[dx][dy] == false) {
					visited[dx][dy] = true; //다음위치 방문체크
					if(map[dx][dy]==0) { //치즈가 아니면
						int next[] = {dx,dy}; //다음으로
						q.offer(next);
					} else { //치즈면
						cheese--; //치즈개수 빼주고
						map[dx][dy] = 0; //0으로 만들기
					}
				}
			}
		}
	}
}
