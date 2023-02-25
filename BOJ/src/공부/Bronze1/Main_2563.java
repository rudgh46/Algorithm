package 공부.Bronze1;
import java.util.Scanner;

/*
  [입력]
첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다. 
색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고, 
두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다. 
색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다
 */
public class Main_2563 {//색종이

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //색종이 수
		int 도화지[][] = new int[100][100]; //도화지
		int 넓이=0; //넓이
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt(); //색종이 시작위치
			int y = sc.nextInt(); 
			
			for(int j=x; j<x+10; j++) { //색종이 크기 10
				for(int k=y; k<y+10; k++) {
					if(도화지[j][k] == 0) { //색종이 곂치는 부분 체크 (0이면 백지상태, 1이면 도화지 있는 상태)
						도화지[j][k] = 1; //색종이가 있는 장소에 1 표시 후 넓이 증가
						넓이++;
					}
				}
			}
		}
		System.out.println(넓이);

		
		
	}

}
