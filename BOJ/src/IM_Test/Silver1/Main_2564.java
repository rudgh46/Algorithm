package IM_Test.Silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 블록의 가로의 길이와 세로의 길이가 차례로 주어진다. 둘째 줄에 상점의 개수가 주어진다. 블록의 가로의 길이와 세로의 길이, 상점의 개수는 모두 100이하의 자연수이다.
이어 한 줄에 하나씩 상점의 위치가 주어진다. 상점의 위치는 두 개의 자연수로 표시된다.
첫째 수는 상점이 위치한 방향을 나타내는데, 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을 의미한다. 
둘째 수는 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리를 나타내고, 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리를 나타낸다.
마지막 줄에는 동근이의 위치가 상점의 위치와 같은 방식으로 주어진다. 상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없다.
 */
public class Main_2564 { //경비원

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int c = Integer.parseInt(st.nextToken());//가로
		int r = Integer.parseInt(st.nextToken());//세로
		int n = Integer.parseInt(br.readLine());//상점 개수
		int sum = 0; //합
		int dis = 0; //거리
		int map[] = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken()); //상점 방향
			int shop = Integer.parseInt(st.nextToken()); //상점 위치
			
			if(d==1) {//북, 베열의 겉만 도니까 1차원 배열로 만들어줌, 북 => 0 ~ c, 동 => c ~ c+r, 남 => c+r ~ c+r+c, 서 => c+r+c ~ c+r+c+r
				map[i] = shop;
			}
			else if(d==2) {//남
				map[i] = 2*c+r-shop;
			}
			else if(d==3) {//서
				map[i] = 2*(c+r)-shop;
			}
			else if(d==4) {//동
				map[i] = c+shop;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int myD = Integer.parseInt(st.nextToken());
		int myShop = Integer.parseInt(st.nextToken());
		
		if(myD==1) {
			dis = myShop;
		}
		else if(myD==2) {
			dis = 2*c+r-myShop;
		}
		else if(myD==3) {
			dis = 2*(c+r)-myShop;
		}
		else if(myD==4) {
			dis = c+myShop;
		}
		
		for(int i=0; i<n; i++) {
			int max = dis > map[i] ? dis : map[i];
			int min = dis <= map[i] ? dis : map[i];
			sum += Math.min(max-min, 2*(c+r)-max+min);
		}
		System.out.println(sum);
	}

}
