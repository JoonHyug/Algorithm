/**
 * 문제 해석
 * 1. 선거구를 2개로 나누었을 때 인구차이의 최소값을 구하기
 * 2. N개의 구역 존재
 * 3. 각 선거구 1개 이상
 * 4. 각 선거구의 모든 구역은 연결되어 있어야 한다.
 * 
 * 선서구 나누기
 *  => 두 단계로 나누기
 * 1. 선거구를 두 개로 쪼개기
 * 2. 각 선거구가 모두 연결되어 있는지 체크
 * 
 * 문제해결 프로세스
 * 1. 선거구를 두 개로 나누기
 * 	=> N개 중 1~2/N개를 뽑는 조합을 시도
 * 		nC1 + nC2 ... nC2/N
 * 2. 각 선거구가 모두 연결되어있는지 체크
 * 	=> BFS 또는 DFS 탐색을 2번 했을 때, 방문하지 못한 정점이 있다면 연결되지 않음
 * 3. 두 선거구의 인구수를 차이값 구하기
 * 	=> 차이값이 최소라면 갱신
 */

package offline.day230228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Main_17471_게리멘더링_황준혁_교수님 {
	
static int N;	//구역의 수
	
	static int[] popInfo;	//구역의 인구 정보
	
	static boolean[][] adjMatrix;	//인접 행렬
	
	static boolean[] isAreaA;	//선거구 체크 true : A, false : B

	static int minPopDiff;	//두 선거구 인구의 최솟값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		//인구 정보 입력
		popInfo = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			popInfo[i] = Integer.parseInt(st.nextToken());
		}
		
		//간선 정보 입력
		adjMatrix = new boolean[N+1][N+1];
		for(int from=1; from<=N; from++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int i=0; i<n; i++) {
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = true;
			}
		}
		
		minPopDiff = Integer.MAX_VALUE;
		isAreaA = new boolean[N+1];
		//1개 뽑는 조합 ~ N/2개 뽑는 조합 시도
		for(int r=1;r<=N/2;r++) {
			combination(0, 1, r);			
		}
		System.out.println(minPopDiff == Integer.MAX_VALUE?-1 : minPopDiff);
	}
	/**
	 * 
	 * @param cnt
	 * @param start
	 * @param r 현재 조합에서 뽑을 개수를 의미
	 */
	private static void combination(int cnt, int start, int r) {
		//step01. 선거구를 두 개로 나누었음(r개의 A구역 선택 완료)
		if(cnt == r) {
			//step 02. 각 선거구가 모두 연결되어 있는지 체크
			if(!isConnected()) return;
			
			//step 03. 두 선거구의 인구수를 차이값 구하고 최소값이라면 갱신
			int curPopDiff = getPopDiff();
			minPopDiff = Math.min(minPopDiff, curPopDiff);
			
			return;
		}
		for(int i=start;i<=N;i++) {
			//선거구 고르기
			isAreaA[i] = true;
			//다음 선거구는 재귀로
			combination(cnt + 1, i+1, r);
			isAreaA[i] = false;
		}
	}
	
	private static int getPopDiff() {
		int sumA = 0;
		int sumB = 0;
		for(int i=1;i<=N;i++) {
			//A구역이라면 A인구수에 누적
			if(isAreaA[i]) sumA += popInfo[i];
			//B구역이라면 B인구수에 누적
			else sumB += popInfo[i];
		}
		
		return Math.abs(sumA - sumB);
	}
	/**
	 * 각 선거구가 모두 연결되어 있다면 true를 반환
	 * @return
	 */
	private static boolean isConnected() {
		
		boolean[] visited = new boolean[N+1];
		
		//첫 번째 dfs탐색
		dfs(1, isAreaA[1], visited);
		
		//두 번째 dfs 탐색
		for(int i=2;i<=N;i++) {
			//방문한 적이 없는 정점이라면 해당정점을 기준으로 dfs
			if(!visited[i]) {
				dfs(i, isAreaA[i], visited);
				break; //더 이상 dfs하면 안되므로 멈춤
			}
		}

		//방문 배열에 false값이 있다면 연결되지 않았으므로 false 리턴
		for(int i=1;i<=N;i++) {
			if(!visited[i]) return false;
		}
		//모두 연결되었으므로 true 리턴
		return true;
	}
	
	/**
	 * 현재 정점에 대한 방문 처리 후,
	 * 현재 정점에서 이동 가능한 정점(같은 선거구)에 대한 방문처리는 재귀에 넘김
	 * @param from
	 * @param isA dfs의 시작점의 선거구 정보
	 * @param visited
	 */
	private static void dfs(int from, boolean isA, boolean[] visited) {
		//현재 정점 방문처리
		visited[from] = true;
		
		//이동 가능한 정점이고 같은 선거구라면 해당 정점에 대한 방문처리는 재귀로 넘김
		for(int to=1;to<=N;to++) {
			if(!visited[to] && adjMatrix[from][to] && isA == isAreaA[to]) {
				dfs(to, isA, visited);
			}
		}
	}

}
