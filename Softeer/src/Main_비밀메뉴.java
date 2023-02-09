import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_비밀메뉴 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String secret = "";
		String user = "";
		
		secret = br.readLine();
		user = br.readLine();
		
		if(user.contains(secret)) {
			System.out.println("secret");
		} else {
			System.out.println("normal");
		}
	}

}
