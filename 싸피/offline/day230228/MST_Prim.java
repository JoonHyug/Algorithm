package offline.day230228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_Prim {

	static int N; //정점의 개수
	static int[][] adjMatrix; //인접 행렬
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		//인접 행렬 만들기
		adjMatrix = new int[N][N];
		for(int i=0;i<adjMatrix.length;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<adjMatrix[i].length;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cost = getMST();
		
		System.out.println(cost);
		
	}

	/**
	 * 최소 신장트리 비용을 반환
	 * @return 최소 신장트리 비용
	 */
	private static int getMST() {
		
		int cost = 0; //최소신장트리 비용
//		int cnt = 0; //선택한 정점의 개수
		
		//현재까지 구성한 트리에서 각 정점까지 이동하는데 필요한 최소 비용
		int[] minEdge = new int[N];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		//구성중인 트리에 포함되어 있다면 true
		boolean[] isInTree = new boolean[N];
		
		//임의의 정점 하나를 트리 구성의 시작점으로 선택
		//0번 정점이 첫번째로 선택되도록 세팅
		minEdge[0] = 0;
		
		//모든 정점을 선택할때까지 반복
		for(int i=0;i<N;i++) {
			//step 01. 트리에 포함할 정점 찾기
			//트리에 포함되지 않은 정점 줌
			//현재 트리에서 이동하는데 비용(minEdge)이 최소 비용인 정점을 선택 
			int minWeight = Integer.MAX_VALUE; //최소 비용
			int minVertex = -1; //최소 비용인 정점
			
			for(int v=0;v<N;v++) {
				if(!isInTree[v] && minEdge[v] < minWeight) {
					minVertex = v; //정점 정보 저장
					minWeight = minEdge[v]; //최소 비용 갱신
				}
			}
			
			//strp 02.트리에 포함시키기
			isInTree[minVertex] = true;
//			cnt++; //정점 선택 개수  cnt
//			cost += minWeight;//비용을 누적 minEdge[minVertex]와 같은 값
			cost += minEdge[minVertex];
			
			//step 03. minEdge 갱신
			//현재까지 구성한 트리에서 이동가능한 간선의 최소비용 갱신
			//선택된 정점에서 이동하능한 정점 중
			//기존 트리의 이동 비용보다 선택된 정점에서 이동하는 비용이 작다면 갱신
			for(int to=0;to<N;to++) {
				//트리에 포함되지 않았고, 해당 정점으로 이동이 가능한 경우
				if(!isInTree[to] && adjMatrix[minVertex][to] != 0) {
					//현재 정점을 포함하기 전 트리에서의 to까지의 비용과 
					//현재 정점(minVertex)에서 to까지의 비용을 비교
					minEdge[to] = Math.min(minEdge[to], adjMatrix[minVertex][to]);
				}
			}
			
		}
		
		return cost;
	}

}
