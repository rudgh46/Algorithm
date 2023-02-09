package D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [입력]
각 테스트 케이스의 첫 줄에는 각 케이스의 트리가 갖는 정점의 총 수 N(1≤N≤200)이 주어진다.
그 다음 N줄에 걸쳐 각각의 정점 정보가 주어진다.
해당 정점에 대한 정보는 해당 정점의 알파벳, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정점번호가 차례대로 주어진다.
정점 번호는 1부터 N까지의 정수로 구분된다. 입력에서 정점 번호를 매기는 규칙은 위와 같으며, 루트 정점의 번호는 반드시 1이다.
입력에서 이웃한 숫자 또는 연산자, 자식 정점의 번호는 모두 공백으로 구분된다.
위의 예시에서, 숫자 8이 4번 정점에 해당하면 “4 8”으로 주어지고, 연산자 ‘/’가 2번 정점에 해당하면 두 자식이 각각 숫자 ‘8’인 4번 정점과 숫자 ‘2’인 5번 정점이므로 “2 / 4 5”로 주어진다.
총 10개의 테스트 케이스가 주어진다.

  [제약 사항]
총 10개의 테스트 케이스가 주어진다.
총 노드의 개수는 200개를 넘어가지 않는다.
트리는 완전 이진 트리 형식으로 주어지며, 노드당 하나의 연산자 또는 숫자만 저장할 수 있다.
노드는 아래 그림과 같은 숫자 번호대로 주어진다.
 */
public class Solution_1233 { //사칙연산 유효성 검사

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test=1; test<=10; test++) {
			int N = Integer.parseInt(br.readLine()); //노드의 수
			char node; //숫자, 연산자 노드 받아옴
			int check = 1; //연산 가능이면 1 아니면 0
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				st.nextToken(); //노드 번호 안씀
				node = st.nextToken().charAt(0); //노드에 값(숫자, 연산자) 입력
				
				if(st.hasMoreTokens()) { // 자식노드가 있을 경우(단말노드X) => 노드는 연산자여야함
					if(node >= '0' && node <= '9') {
						check = 0; //연산 불가
					}
				}
				else { // 자식노드가 없을 경우(단말노드) => 노드는 숫자여야함.
					if(node < '0' || node > '9') {
						check = 0; //연산 불가
					}
				}
			}
			System.out.println("#"+test+ " " + check);
			
		}
	}

}
