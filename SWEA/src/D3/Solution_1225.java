package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;
import java.util.StringTokenizer;

/*
  [제약 사항]
주어지는 각 수는 integer 범위를 넘지 않는다.
마지막 암호 배열은 모두 한 자리 수로 구성되어 있다.

  [입력]
각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고, 그 다음 줄에는 8개의 데이터가 주어진다.
 */
public class Solution_1225 { //암호생성기

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int test = 1; test <= 10; test++) {
//			int T = sc.nextInt();
			int T = Integer.parseInt(br.readLine());
			int count = 1;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 8; i++) {
//				q.offer(sc.nextInt());
				q.offer(Integer.parseInt(st.nextToken()));
			}

			while (true) {
				int pass = q.poll();
				if (pass - count <= 0) {
					q.offer(0);
					break;
				}
				q.offer(pass - count);

				if (count == 5) {
					count = 0;
				}
				count++;
			}

//			System.out.print("#"+test+" ");
			sb.append("#").append(T).append(" ");
			for (int i = 0; i < 8; i++) {
//				System.out.print(q.poll()+" ");
				sb.append(q.poll()).append(" ");
			} // System.out.println();
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
