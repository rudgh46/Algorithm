import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://softeer.ai/practice/info.do?eventIdx=1&psProblemId=394

 * [입력]
첫 번째 줄에 두 정수 N,M이 주어진다.
두 번째 줄에 N개의 정수 W1, W2, ... , WN이 주어진다.
다음 M개의 줄의 j번째 줄에는 두 정수 Aj, Bj가 주어진다.
입력은 다음 조건을 만족한다.
    2 ≤ N ≤ 105
    1 ≤ M ≤ 105
    1 ≤ Wi ≤ 109
    1 ≤ Aj, Bj ≤ N
    Aj ≠ Bj
    
 * [출력]
첫 번째 줄에 자신이 최고라고 생각하는 회원 수를 출력한다.
 */
public class Main_우물_안_개구리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //헬스장에서 운동하는 회원 수
		int M = Integer.parseInt(st.nextToken()); //친분관계의 수
		int W[] = new int[N]; //회원별 들 수 있는 무게
		int person[] = new int[N]; //친분관계 배열
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			W[i] = Integer.parseInt(st.nextToken()); //회원별 들 수 있는 무게 입력
		}
		
		for(int i=0; i<M; i++) { //친분관계만큼 돌기
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1; //회원 A와
			int B = Integer.parseInt(st.nextToken())-1; //회원 B는 친분관계
			
			if(W[A] < W[B]) { //들 수 있는 무게 비교 후  랭크해주기
				if(person[B] == 0) person[B] = 1;
				person[A] = 2;
			}
			
			else if(W[A] > W[B]) {
				if(person[A] == 0) person[A] = 1;
				person[B] = 2;
			}
			
			else person[A] = person[B] = 2;
		}
		
		for(int i=0; i<N; i++) {
			if(person[i] != 2) ans++; //친분이 없으면(0) 최고, 랭크 1이면 최고
		}
		
		System.out.println(ans); //출력
	}
}
