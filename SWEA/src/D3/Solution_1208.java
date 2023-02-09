package D3;
import java.util.Arrays;
import java.util.Scanner;

/*
  [제약 사항]

가로 길이는 항상 100으로 주어진다.

모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.

덤프 횟수는 1이상 1000이하로 주어진다.

주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로 그 때의 최고점과 최저점의 높이 차를 반환한다 (주어진 data에 따라 0 또는 1이 된다).

  [입력]

총 10개의 테스트 케이스가 주어지며, 각 테스트 케이스의 첫 번째 줄에는 덤프 횟수가 주어진다. 그리고 다음 줄에 각 상자의 높이값이 주어진다.
 */
public class Solution_1208 {//Flatten

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; //테스트케이스 10개

		for (int test = 1; test <= T; test++) {
			int dump = sc.nextInt();
			int box[] = new int[100]; // 가로 길이 100으로 주어짐

			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}
			Arrays.sort(box);

			for (int i = 0; i < dump; i++) {
				int count = 0;
				if (box[99] - box[0] <= 1 || count <= dump) { //최고 최저 차이가 1이내, dump횟수 제한
					box[0] += 1;
					box[99] -= 1;
					Arrays.sort(box);
				}
				count++;
			}

			System.out.println("#" + test + " " + (box[99] - box[0]));
		}
	}

}
