import java.io.*;
import java.util.*;

public class Main_GBC {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int len[][] = new int[N][2];
		int test[][] = new int[M][2];
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			len[i][0] = Integer.parseInt(st.nextToken());
			len[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			test[i][0] = Integer.parseInt(st.nextToken());
			test[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		for(int i=0; i<N; i++) {
			for(int j=idx; j<M; j++) {
				if(len[i][0] < test[j][0]) {
					test[j][0] -= len[i][0];
					if(test[j][1] - len[i][1] > 0)
						ans = Math.max(ans, test[j][1] - len[i][1]);
					break;
				} else if(len[i][0] > test[j][0]) {
					len[i][0] -= test[j][0];
					if(test[j][1] - len[i][1] > 0)
						ans = Math.max(ans, test[j][1] - len[i][1]);
					idx++;
				} else {
					if(test[j][1] - len[i][1] > 0)
						ans = Math.max(ans, test[j][1] - len[i][1]);
					idx++;
					break;
				}
			}
		}
		System.out.println(ans);
	}

}
