package 공부.Bronze2;
import java.util.Scanner;

/*
  입력
총 아홉개 줄에 1보다 크거나 같고 99보다 작거나 같은 자연수가 주어진다. 
모든 숫자는 서로 다르다. 또, 항상 답이 유일한 경우만 입력으로 주어진다.
 */
public class Main_3040{ //백설공주와 일곱 난쟁이

	static int height[], num[];
	static boolean visit[];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		height = new int[9];	//9명 난쟁이 값
		num = new int[7];		//선택한 난쟁이 값
		visit = new boolean[9];	//선택여부
		for(int i=0; i<9; i++) {
			height[i] = sc.nextInt();
		}
		
		dfs(0,0,0);
		
	}
	
	public static void dfs(int count, int start, int sum) {
		if(count == 7) {	//7명 키의 합이 100이면 출력
			if(sum == 100) {
				for(int a : num) {
					System.out.println(height[a]);
				}
			}
			return;
		}
		for(int i=start; i<9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				num[count] = i;
				dfs(count+1, i+1, sum+height[i]);
				visit[i] = false;
			}
		}
	}

}
