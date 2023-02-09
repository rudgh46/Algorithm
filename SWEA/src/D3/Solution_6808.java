package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 아홉 개의 정수가 공백으로 구분되어 주어진다.
각 정수는 1이상 18이하이며, 같은 정수는 없다.
규영이는 정수가 주어지는 순서대로 카드를 낸다고 생각하면 된다.
 */
public class Solution_6808 {//규영이와 인영이의 카드게임

	static int count;
	static int 규영[], 인영[], card[], result[];

	public static void main(String[] args) throws IOException {
//		==============================  입력   ====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test = 1; test<=T; test++) {
			card = new int[19];
			규영 = new int[9];
			인영 = new int[9];
			result = new int[9];

			int idx = 0;
			count = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) { //규영이 카드 입력
				규영[i] = Integer.parseInt(st.nextToken());
				card[규영[i]] = 1;
			}
//			==============================  풀이   ====================================
			for(int i=1; i<=18; i++) { //인영이 카드 입력
				if(card[i] == 0) {
					인영[idx++] = i;
				}
			}
			
			permutation(0,0);
			
//			==============================  출력   ====================================
			sb.append("#").append(test).append(" ").append(count).append(" ").append(362880-count).append("\n"); //9! = 362880, 362880-이기는 경우 = 지는경우
		}
		System.out.println(sb);

	}
	
//	==============================  permutation   ====================================
	public static void permutation(int idx,int flag) {
		if(idx==9) { 
			int 규영점수 = 0;
			int 인영점수 = 0;
			
			for(int i=0; i<9; i++) {
				if(규영[i]>result[i]) { //규영이 점수가 더 높으면 규영이 점수에 합
					규영점수 += 규영[i] + result[i];
				}else {//인영이 점수가 더 높으면 인영이 점수에 합
					인영점수 += 규영[i] + result[i];
				}
			}
			if(규영점수>인영점수) count++; //이기는 경우
			return;
		}
		
		for(int i=0; i<9; i++) { 
			if((flag & 1<<i) !=0) continue;
				result[idx] = 인영[i]; //인영이 숫자
				permutation(idx+1,flag | 1<<i);
			
		}
		
	}

}
