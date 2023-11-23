package offline.day230228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_kruskal {
	
	static int V; //점점의 개수
	static int E; //간선의 개수
	
	static Edge[] edgeList; //간선 리스트
	
	static int[] parents; //서로소 집합
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        //간선리스트 만들기
        edgeList = new Edge[E];
        
        for(int i=0;i<E;i++) {
        	st = new StringTokenizer(br.readLine().trim());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	edgeList[i] = new Edge(from, to, weight);
        	
        }
        
        int cost = getMST();
        System.out.println(cost);
	}

	private static int getMST() {
		makeSet(); //단위 서로소 집합
		
		//간선리스트 가중치 오름차순 정렬
		Arrays.sort(edgeList);
		
		int cnt = 0; //사용한 간선의 개수
		int cost = 0; //최소 신장트리 비용
		for(Edge edge : edgeList) {
			int from = edge.from;
			int to = edge.to;
			int weight = edge.weight;
			
			//합집합 연산에 성공했다면
			if(union(from, to)) {
				cnt++; //사용한 간선 수 cnt
				cost += weight; //비용 누적
				//모든 정점을 연결했다면 종료
				if(cnt == V-1) {
					break;
				}
			}
		}
		
		return cost;
	}

	/** 
	 * a가 속한 집합과 b가 속한 집합을 합침
	 * b가 속한 집합의 대표 원소가 a가 속한 집합의 대표원소를 바라보게 함
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		//같은 집합의 경우 false 반환
		if(rootA == rootB) return false;
		
		parents[rootB] = rootA;
		return true;
	}

	private static int find(int a) {
		//해당 집합의 대표원소인 겨웅, 해당 값을 반환
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	private static void makeSet() {
		parents = new int[V];
		for(int i=0;i<V;i++) {
			parents[i] = i;
		}
	}

}
