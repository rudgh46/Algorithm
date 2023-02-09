package 공부.Silver5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
 */
public class Main_1158 {//Silver5_요세푸스 문제

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		System.out.print("<");
		
		while (q.size() != 1) {
			for (int i = 0; i < K - 1; i++) {
				q.offer(q.poll());
			}
			System.out.print(q.poll() + ", ");

		}
		System.out.println(q.poll()+">");
	}
}
