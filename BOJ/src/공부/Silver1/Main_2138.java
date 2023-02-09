package 공부.Silver1;
import java.util.Scanner;

/*
  [입력]
첫째 줄에 자연수 N(2 ≤ N ≤ 100,000)이 주어진다. 
다음 줄에는 전구들의 현재 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 
그 다음 줄에는 우리가 만들고자 하는 전구들의 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 
0은 켜져 있는 상태, 1은 꺼져 있는 상태를 의미한다.

  [출력]
첫째 줄에 답을 출력한다. 
불가능한 경우에는 -1을 출력한다.
 */
public class Main_2138 {//전구와 스위치

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int on_light[] = new int[N]; // 1번 스위치 눌렀을때
		int off_light[] = new int[N]; // 1번 스위치 안눌렀을때
		int light[] = new int[N]; // 목표전구 상태
		int on_ans = 1;
		int off_ans = 0;
		int X = Integer.MAX_VALUE;
		
		String stLight = sc.next();
		String stLight2 = sc.next();
		
		for (int i = 0; i < N; i++) {
			on_light[i] = stLight.charAt(i) - '0';
			off_light[i] = stLight.charAt(i) - '0';
			light[i] = stLight2.charAt(i) - '0';
		}
		
		on_light[0] = 1 - on_light[0];
		on_light[1] = 1 - on_light[1];
		
		for(int i = 1; i<N; i++) {
			if(on_light[i-1] != light[i-1]) {
				on_light[i-1] = 1 - on_light[i-1];
				on_light[i] = 1 - on_light[i];
				on_ans++;
				
				if(i != N-1)
					on_light[i+1] = 1 - on_light[i+1];
			}
			
			if(off_light[i-1] != light[i-1]) {
				off_light[i-1] = 1 - off_light[i-1];
				off_light[i] = 1 - off_light[i];
				off_ans++;
				
				if(i != N-1)
					off_light[i+1] = 1 - off_light[i+1];
			}
		}
		
		if(on_light[N-1] != light[N-1]) on_ans = X;
		if(off_light[N-1] != light[N-1]) off_ans = X;
		
		if(on_ans == X && off_ans == X) 
			System.out.println(-1);
		else
			System.out.println(Math.min(on_ans, off_ans));
		
	}

}
