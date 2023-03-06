package 공부.Silver4;

import java.util.*;

public class Main_10866 { //덱

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<>();
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			String cmd = sc.next();

			switch (cmd) {
			case "push_front": {
				dq.addFirst(sc.nextInt());
				break;
			}
			case "push_back": {
				dq.addLast(sc.nextInt());
				break;
			}
			case "pop_front": {
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');

				} else {
					sb.append(dq.removeFirst()).append('\n');
				}
				break;
			}
			case "pop_back": {
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dq.removeLast()).append('\n');
				}
				break;
			}
			case "size": {
				sb.append(dq.size()).append('\n');
				break;
			}
			case "empty": {
				if (dq.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			}
			case "front": {
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dq.peekFirst()).append('\n');
				}
				break;
			}
			case "back": {
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dq.peekLast()).append('\n');
				}
				break;
			}
			default:
				break;
			}
		}
		System.out.println(sb);
	}

}
