import java.io.*;
import java.math.*;
import java.util.*;

public class Main_바이러스 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long K = Long.parseLong(st.nextToken());
		long P = Long.parseLong(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		
		for(int i=0; i<N; i++) {
			K = (K*P) % 1000000007;
		}
		
		System.out.println(K);
	}

}
