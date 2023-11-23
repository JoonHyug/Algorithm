/**
 * 문제 해석
 * 1. 경기 결과 4개 주어짐
 * 2. 6개의 나라가 각각 5번씩 경기를 치뤘을 때 가능한 경기 결과라면 1, 가능하지 않으면 0을 출력
 * 3. 승, 무, 패는 0~6로 주어짐
 * 
 * 완전 탐색
 * 1. 가능한 모든 경기결과를 만들어보고 판단하고자 하는 경기 결과가 만들어본 경우에 포함된다면 유효하다고 판단
 * 
 * 복잡도
 * 	1. 6개의 나라가 모두 한 번씩 경기를 하는 경우의 수
 * 		- 6C2의 경우의 수를 가짐 = 15
 * 	2. 각 경기마다 승, 무, 패 라는 결과가 있음
 * 		- 따라서, 3^15 = 약 1400만
 *  3. 여기에 판단해야하는 경기 결과 4
 *  	약 1400만 x 4 = 약 6400만
 *  4. 완탐이 가능할거라고 판단
 *  
 * 완전 탐색 프로세스
 * 1. 15경기에 대한 매치 정보 만들기
 * 		- 조합 6C2
 *  	- 반복문을 통해 이차원 배열에 매치정보 담기
 * 		- int matchInfo[15][2] 
 * 2. 각 경기를 승, 무, 패 경우로 수행
 * 		i, j 두 나라의 경우
 * 		- i승
 * 			i나라의 승수 + 1
 * 			j나라의 패수 + 1
 * 		- 무승부
 * 			i, j 나라의 무승부수 + 1
 * 		- i 패
 * 			i나라의 패수 + 1
 * 			j나라의 승수 + 1
 * 3. 15경기를 수행했을 때, 만들어진 경기결과가 판단하고자 하는 경기 결과와 일치하면 유효하다고 판단
 * 		- 유효성 판단 기준
 * 			- 만들어진 경기결과 와 주어진 경기결과의 모든 승무패가 일치한다면 유효 
 * 최적화
 * i, j 두 나라의 승, 무, 패를 결정하려는 순간
 * 1) i승 결정 시
 * 		- 만들어진 i나라의 승수 또는 j나라의 패수가 주어진 승, 패수와 일치한다면
 * 			- i승으로 결정할 경우 유효하지 않으므로 i승으로 결정 x
 * 			- 가지치기
 * 2) 무승부도 마찬가지
 * 3) 패도 마찬가리  
 */
package offline.day230221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_Main_6987_월드컵_황준혁_교수님_백트래킹_boolean {

	final static int N = 6; // 나라의 수
	static int[][] result = new int[N][3]; // 주어진 경기 결과

	static int[][] matchInfo = new int[15][2]; // 15(6C2)경기에 대한 나라 정보

	static int[][] madeResult; // 직접 만든 경기 결과

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// step 01. 매치 정보 만들기(6C2)
		int idx = 0;
		// i, j는 매치할 두 나라의 인덱스 정보
		// idx+1번쨰에 경기할 두 나라를 정하기
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				matchInfo[idx][0] = i;
				matchInfo[idx][1] = j;
				idx++;
			}
		}

		// 경기결과 4개
		A:
		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(br.readLine());
			// 각 나라의 승, 무, 패수 입력
			for (int i = 0; i < N; i++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());

				//한 나라의 경기수가 5가 아니라면 유효 X
				if(win+draw+lose != 5) {
					sb.append(0).append(" ");
					continue A;
				}
				
				result[i][0] = win;
				result[i][1] = draw;
				result[i][2] = lose;
			}
			madeResult = new int[N][3];
			boolean isValid = bruteForce(0);
			sb.append(isValid ? 1 : 0).append(" ");
		}
		System.out.println(sb);
	}

	/**
	 * 현재 경기에 대해 승, 무 ,패를 결정하고 다음 경기의 승, 무, 패는 재귀에 넘김
	 * 
	 * @param cnt 몇 번째 경기인지에 대한 정보
	 */
	private static boolean bruteForce(int cnt) {
		// 모든 경기결과를 경정했다면
		if (cnt == 15) {
			// 무사히 내려왔다면 모두 일치하므로 유효하다고 판단
			return true;
		}

		// 경기할 두 나라의 인덱스 정보
		int country1 = matchInfo[cnt][0];
		int country2 = matchInfo[cnt][1];

		// country1 승
		// country1의 승으로 결정하기 전, 만들어진 승, 패 결과가 주어진 승패 결과와 일치하는 것이 있다면
		// country1의 승으로 결정하지 않음
		// 가지치기
		if (madeResult[country1][0] < result[country1][0] 
				&& madeResult[country2][2] < result[country2][2]) {
			madeResult[country1][0]++;
			madeResult[country2][2]++;
			if(bruteForce(cnt + 1)) return true;
			// cnt번째 경기를 승으로 결정한 후, 뒤의 모든 경기결과를 만들어 보았으므로 되롤림
			madeResult[country1][0]--;
			madeResult[country2][2]--;
		}

		// 무
		if (madeResult[country1][1] < result[country1][1] 
				&& madeResult[country2][1] < result[country2][1]) {
			madeResult[country1][1]++;
			madeResult[country2][1]++;
			if(bruteForce(cnt + 1)) return true;
			madeResult[country1][1]--;
			madeResult[country2][1]--;
		}

		// country1 패
		if (madeResult[country1][2] < result[country1][2] 
				&& madeResult[country2][0] < result[country2][0]) {
			madeResult[country1][2]++;
			madeResult[country2][0]++;
			if(bruteForce(cnt + 1)) return true;
			madeResult[country1][2]--;
			madeResult[country2][0]--;			
		}
		return false;
	}

}
