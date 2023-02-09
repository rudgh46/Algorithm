import java.io.*;
import java.util.*;

public class Main_금고털이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int knapsack[][] = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			knapsack[i][0] = Integer.parseInt(st.nextToken());
			knapsack[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;

		Arrays.sort(knapsack, (o1,o2) -> o2[1] - o1[1]);
		
		int temp = W;
		for(int i=1; i<=N; i++) {
			if(temp >= knapsack[i-1][0]) {
				temp -= knapsack[i-1][0];
				max += knapsack[i-1][0] * knapsack[i-1][1];
			}else {
				max += temp * knapsack[i-1][1];
				break;
			}
		}
		
		System.out.println(max);

	}

}
