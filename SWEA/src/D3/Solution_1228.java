package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
  위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.

  [입력]
첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)
두 번째 줄 : 원본 암호문
세 번째 줄 : 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)
네 번째 줄 : 명령어
위와 같은 네 줄이 한 개의 테스트 케이스이며, 총 10개의 테스트 케이스가 주어진다.
 */
public class Solution_1228 {//암호문1

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> pass = new LinkedList<Integer>();
		
		for (int test = 1; test <= 10; test++) {
			pass.clear();
			int N = Integer.parseInt(br.readLine().trim());

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				pass.add(Integer.parseInt(st.nextToken()));
			}

			int K = Integer.parseInt(br.readLine().trim());

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < K; i++) {
				 st.nextToken(); 
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						pass.add(x, Integer.parseInt(st.nextToken()));
						x++;
					}
				 

			}
			System.out.print("#" + test + " ");
			for(int i=0; i<10; i++) {
				System.out.print(pass.get(i) + " ");
			}
			System.out.println();
		}

	}

}
