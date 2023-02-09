package 공부.Silver4;
import java.util.Scanner;

public class Main_1002 { //터렛

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, x1, y1, r1, x2, y2, r2;
		num = sc.nextInt();
		for(int i = 0; i<num; i++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			r1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			r2 = sc.nextInt();
			System.out.println(distance(x1,y1,r1,x2,y2,r2));	
		}
	}
	static int distance(int x1, int y1, int r1, int x2, int y2, int r2) {
		double d;
		d = Math.pow(x1 - x2, 2) + Math.pow(y1 -y2, 2);
		d = Math.sqrt(d);
		if (d==0 && r1==r2)
			return -1;
		else if (d> r1 + r2 || d < Math.abs(r1 - r2))
			return 0;
		else if (r1+r2 == d || r1 -r2 == d || r2-r1 == d)
			return 1;
		else
			return 2;
	}
}
