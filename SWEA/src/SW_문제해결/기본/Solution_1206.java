package SW_문제해결.기본;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [제약 사항]
가로 길이는 항상 1000이하로 주어진다.
맨 왼쪽 두 칸과 맨 오른쪽 두 칸에는 건물이 지어지지 않는다. (예시에서 빨간색 땅 부분)
각 빌딩의 높이는 최대 255이다.
 
  [입력]
입력 파일의 첫 번째 줄에는 테스트케이스의 길이가 주어진다. 그 바로 다음 줄에 테스트 케이스가 주어진다.
총 10개의 테스트케이스가 주어진다.
 
  [출력]
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 조망권이 확보된 세대의 수를 출력한다.
 */
public class Solution_1206 { //D3_View

	public static void main(String[] args) throws NumberFormatException, IOException {
//		=================================  입력   ===================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10; //테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); //길이
			int map[] = new int[N];
			int cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
//		=================================  풀이   ===================================
			for(int i = 2; i<N-2; i++) { //0, 1, N-1, N-2 값은 0
				int max = Math.max(map[i-2], Math.max(map[i-1], Math.max(map[i+1], map[i+2]))); //왼쪽 오른쪽 건물의 최대값
				
				if(map[i]>max) { //현재 건물이 좌우 건물의 최대값보다 큰경우
					cnt += map[i]-max; //차이 구하기
				}
			}
			
//		=================================  출력   ===================================
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
