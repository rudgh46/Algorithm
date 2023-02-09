package D4;
import java.util.Scanner;
import java.util.Stack;

/*
  [입력]
각 테스트 케이스의 첫 번째 줄에는 테스트케이스의 길이가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
총 10개의 테스트케이스가 주어진다.
  
 */
public class Solution_1218 { // 괄호 짝짓기

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int test = 1; test <= 10; test++) {
			int N = sc.nextInt();
			Stack<String> st = new Stack<String>();
			String arr[] = new String[N];
			String line = sc.next();
			arr = line.split("");
			int ans = 1;

			for (int i = 0; i < N; i++) {
				if (arr[i].equals("(") || arr[i].equals("[") || arr[i].equals("{") || arr[i].equals("<")) {
					st.push(arr[i]);
				} else if (arr[i].equals(")")) {
					if (!(st.peek().equals("(")))
						break;
					st.pop();
				} else if (arr[i].equals("]")) {
					if (!(st.peek().equals("[")))
						break;
					st.pop();
				} else if (arr[i].equals("}")) {
					if (!(st.peek().equals("{")))
						break;
					st.pop();
				} else if (arr[i].equals(">")) {
					if (!(st.peek().equals("<")))
						break;
					st.pop();
				}
			}
			if (!st.isEmpty()) {
				ans = 0;
			}
			System.out.println("#"+ test + " " + ans);
		}
	}
}
