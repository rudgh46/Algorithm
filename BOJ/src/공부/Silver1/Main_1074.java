package 공부.Silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 정수 N, r, c가 주어진다.
 */
public class Main_1074 { //Z
	static int N,r,c,count,len;
	
	public static void main(String[] args) throws IOException {
//	================================  입력   ========================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //2^N * 2^N 크기의 배열
		r = Integer.parseInt(st.nextToken()); //행
		c = Integer.parseInt(st.nextToken()); //열
//		================================  풀이   ========================================
		count = 0;	//방문 카운트
		len = (int) Math.pow(2, N);	//한 변의 길이 = 2^N
		Z(len,r,c); //재귀
//		================================  출력   ========================================
		System.out.println(count);
	}

//	================================  Z   ========================================
	public static void Z(int len, int r, int c) {
		if(len == 1) return; //기저조건
		
		if(r<len/2 && c<len/2) { //2사분면
			Z(len/2,r,c);
		}
		else if(r<len/2 && c>=len/2) { //1사분면
			count += Math.pow(len/2, 2); //1사분면의 시작 위치
			Z(len/2, r, c-len/2);
		}
		else if(r>=len/2 && c<len/2) { //3사분면
			count += Math.pow(len/2, 2)*2; //3사분면의 시작 위치
			Z(len/2, r-len/2,c);
		}
		else { //4사분면
			count += Math.pow(len/2, 2)*3; //4사분면의 시작 위치
			Z(len/2,r-len/2, c-len/2);
		}
	}
}
