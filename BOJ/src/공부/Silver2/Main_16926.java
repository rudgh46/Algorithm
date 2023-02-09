package 공부.Silver2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.
둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.
  [제한]
2 ≤ N, M ≤ 300
1 ≤ R ≤ 1,000
min(N, M) mod 2 = 0
1 ≤ Aij ≤ 108
 */
public class Main_16926 { //배열돌리기1

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int deltas[][] = {//배열을 반시계 방향으로 돌려기 위한 방향 설정  
				{0,1},	//우
				{1,0},	//하
				{0,-1},	//좌
				{-1,0}};//상
		
		int N = Integer.parseInt(st.nextToken());	//배열 행
		int M = Integer.parseInt(st.nextToken());	//배열 열
		int map[][] = new int[N][M];				//배열
		int R = Integer.parseInt(st.nextToken());	//회전 횟수
		int temp = 0;	//처음 위치 배열 값 저장할 임시장소
		
		for(int i=0; i<N; i++) { // 배열 입력
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<R; i++) {// 회전 수 만큼
			for(int j=0; j<Math.min(N,M)/2; j++) { //Math.min(N,M)/2 는 돌려야 하는 사각형 수
				int d=0,r=j,c=j; //방향, 시작점
				temp = map[r][c]; //시작위치 임시장소에 저장
				while(d<4) { 
					int dx = r + deltas[d][0];
					int dy = c + deltas[d][1];
					
					if(dx>=j && dx<N-j && dy>=j && dy<M-j) { //범위 내에 있을 경우 돌리기
						map[r][c] = map[dx][dy];
						r = dx;
						c = dy;
					}
					else d++; //범위 벗어나면 방향 전환
				}
				map[j+1][j] = temp; //4방향 전부 돌리기 끝나면 초기위치 바로 아래 넣어주기
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(map[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.print(sb);

	}

}
