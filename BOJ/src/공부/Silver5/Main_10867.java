package 공부.Silver5;

import java.util.*;

public class Main_10867 { // 중복빼고 정렬하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		/*풀이 1*/
		Stack<Integer> st = new Stack<>();
		
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(!st.contains(num)) {
				st.add(num);
			}
		}
		int size = st.size();
		int arr[] = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = st.pop();
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<size; i++) {
			System.out.print(arr[i] + " ");		
		}
		
		
		/*풀이 2
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(int i=0; i<N; i++) {
			hs.add(sc.nextInt());
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>(hs);
		Collections.sort(al);
		
		for(int i=0 ; i<al.size(); i++) {
			System.out.print(al.get(i)+" ");
		}
		*/
	}

}
