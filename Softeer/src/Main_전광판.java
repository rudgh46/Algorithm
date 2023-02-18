import java.util.*;
import java.io.*;

public class Main_전광판 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int numbers[][] = new int[10][7];
		
		numbers[0] = new int[] {1,1,1,0,1,1,1};
		numbers[1] = new int[] {0,0,1,0,0,1,0};
		numbers[2] = new int[] {1,0,1,1,1,0,1};
		numbers[3] = new int[] {1,0,1,1,0,1,1};
		numbers[4] = new int[] {0,1,1,1,0,1,0};
		numbers[5] = new int[] {1,1,0,1,0,1,1};
		numbers[6] = new int[] {1,1,0,1,1,1,1};
		numbers[7] = new int[] {1,1,1,0,0,1,0};
		numbers[8] = new int[] {1,1,1,1,1,1,1};
		numbers[9] = new int[] {1,1,1,1,0,1,1};
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			
			while(A!=0) {
				int tempA = A%10;
				if(B == 0) {
					for(int i=0; i<7; i++) {
						if(numbers[tempA][i] == 1) cnt++;
					}
				}else {
					int tempB = B%10;
					for(int i=0; i<7; i++) {
						if(numbers[tempA][i] != numbers[tempB][i]) cnt++;
					}
				}
				A/=10;
				B/=10;
			}
			while(B!=0) {
				int tempB = B%10;
				for(int i=0; i<7; i++) {
					if(numbers[tempB][i] == 1) cnt++;
				}
				B /= 10;
			}
			System.out.println(cnt);
			
		}
	}

}
