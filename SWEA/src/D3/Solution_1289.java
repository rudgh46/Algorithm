package D3;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1289 { //원재의 메모리 복구하기

	public static void main(String[] args) throws FileNotFoundException {

//		System.setIn(new FileInputStream("src/input1289.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test = 1; test <= T; test++) {
			String mem = sc.next();
			int count = 0;

			for (int i = 0; i < mem.length(); i++) {
				if (i == 0) {
					if (mem.charAt(i) == '1') {
						count++;
					}
				} else {
					if (mem.charAt(i) != mem.charAt(i - 1)) {
						count++;
					}
				}

			}
			System.out.printf("#%d %d%n", test, count);
		}

	}
}
