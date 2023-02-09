package 공부.Gold5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 
모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 
둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 
셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. 
u와 v는 서로 다르며 w는 10 이하의 자연수이다. 
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

  [출력]
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 
시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.
 */
public class Main_1753 { //최단경로
	
	static int V,E,K,u,v,w,distance[];
	static ArrayList[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		distance = new int[V+1]; //거리배열 무한대로 초기화
		for(int i=1; i<=V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		adjList = new ArrayList[V+1]; //인접리스트 초기화
		for(int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		for(int i=1; i<=E; i++) { //방향 간선 입력
			st = new StringTokenizer(br.readLine());
			
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Edge(v, w));
		}
		
		dijkstra(K);//출발지부터 진행
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			}
			else {
				sb.append(distance[i]).append("\n");
			}
		}
		
		System.out.println(sb);
			
		}

	private static void dijkstra(int start) {
		PriorityQueue<Edge> PQ = new PriorityQueue<Edge>();
		distance[start] = 0;//출발지 비용 0
		PQ.add(new Edge(start, 0));
		
		while(!PQ.isEmpty()) {
			Edge now = PQ.poll();
			
			if(now.cost>distance[now.id]) continue; //더 큰 가중치로 도착한 경우 패스
			
			int len = adjList[now.id].size();//현재 위치에 연결된 간선 탐색
			for(int i=0; i<len; i++) {
				Edge next = (Edge) adjList[now.id].get(i);
				
				if(distance[next.id] > now.cost + next.cost) {//cost가 작을때 갱신
					distance[next.id] = now.cost + next.cost;
					PQ.add(new Edge(next.id, distance[next.cost]));
				}
			}
		
	}

	}
	
	static class Edge implements Comparable<Edge>{
		int id, cost;
		

		public Edge(int id, int cost) {
			super();
			this.id = id;
			this.cost = cost;
		}


		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

}
