package 공부.Silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 재료의 개수 N(1 ≤ N ≤ 10)이 주어진다.
다음 N개 줄에는 그 재료의 신맛과 쓴맛이 공백으로 구분되어 주어진다. 
모든 재료를 사용해서 요리를 만들었을 때, 그 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수이다.
 */
public class Main_2961 {//도영이가 만든 맛없는 음식
	static int N,재료신맛[], 재료쓴맛[], 차이 = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		재료신맛 = new int[N];
		재료쓴맛 = new int[N];
		
		
		for(int i=0; i<N; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		재료신맛[i] = Integer.parseInt(st.nextToken());
		재료쓴맛[i] = Integer.parseInt(st.nextToken());
		}
		
		해결(1,0,0,0);
		
		System.out.println(차이);
	}
	
	public static void 해결(int 신맛, int 쓴맛, int idx, int count) {
		if(idx==N) {
			if(count !=0) {
			차이 = Math.min(차이, Math.abs(신맛-쓴맛));
			}
			return;
		}
		
		해결(신맛,쓴맛,idx+1,count);
		해결(신맛*재료신맛[idx], 쓴맛+재료쓴맛[idx], idx+1, count+1);
		
	}

}
