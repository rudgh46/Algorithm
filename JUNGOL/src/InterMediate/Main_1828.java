package InterMediate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
  [입력]
첫줄에 화학물질의 수 N이 입력된다. N의 범위는 1이상 100 이하이다. 
두 번째 줄부터 N+1줄까지 최저보관온도와 최고보관온도가 입력된다. 
보관온도는 -270° ~ 10000°이며, 각 냉장고는 임의의 정해진 온도를 일정하게 유지할 수 있고, 냉장고는 아주 크다고 가정한다.
  [출력]
첫줄에 최소로 필요한 냉장고의 대수를 출력한다.
 */
public class Main_1828 {//Intermediate_냉장고

	public static void main(String[] args) throws NumberFormatException, IOException {
//		====================================  입력   =================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //화학물질 개수
		int temp[][] = new int[N][2]; //화학물질의 온도배열
		int count=1;//냉장고 카운트
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken()); //최저온도
			temp[i][1] = Integer.parseInt(st.nextToken()); //최고온도
		}
//		====================================  풀이   =================================
		Arrays.sort(temp, new Comparator<int[]>() { //최대온도 오름차순으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]- o2[1];
			}
		});
		
		int max = temp[0][1]; //처음 화학물질의 최대온도를 max에 넣어줌
		
		for(int i=1; i<N; i++) { //두번째 화학물질부터
			if(max<temp[i][0]) { //max보다 높은 최저온도 만날경우
				max = temp[i][1];//해당 화학물질의 최고온도를 max에 넣어주고 냉장고 추가
				count++;
			}
		}
//		====================================  출력   =================================
		System.out.println(count);//냉장고 출력
	}

}
