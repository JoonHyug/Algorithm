/**
 * 문제 해석
 * C개의 문자들로 L자리의 암호를 만드는 모든 경우의 수 구하기
 * 	- C개 중에 L개를 뽑는ㅈ 조합
 * 	- 만들어진 암호가 모음 1개 이상, 자음 2개 이상인 경유 유효
 * 	- 조합된 암호들은 사전순서대로 정렬이 되어있어야 함
 * 		- 재귀를 통해 조합 만들 때 특징, 원본 요소의 순서대로 조합이 만들어짐
 * 			=> 미리 문자들을 사전순으로 정렬해놓으면 조합된 암호 또한 사전순으로 정렬이 되어있을 것
 * 
 * 시간 복잡도 15C7 < 30C15
 * 
 * 문제 해결 프로세스
 * 1. 주어진 알파벳을 사전순으로 정렬
 * 2. C개의 문자열 중 L개를 뽑아 암호 만들기(조합)
 * 3. 만들어진 암호가 모음 1개 이상, 자음 2개 이상이면 출력
 * 	1) L개를 전부 뽑고 만들어진 암호를 탐색하며 조건에 부합하는지 체크
 * 	2) 매개변수를 추가해 암호를 만드는 과정에서 모음과 자음 개수를 체크
 * 		=> L개를 전부 뽑은 후 세었던 개수를 가지고 조건 체크
 */

package offline.day230224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_Main_1759_암호만들기_황준혁_교수님 {

	static int L;
	static int C;
	static char[] words;
	static char[] vowles;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		words = new char[C];
		for (int i = 0; i < words.length; i++) {
			words[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(words);
		vowles = new char[] { 'a', 'e', 'i', 'o', 'u' };
		visited = new boolean[C];
		dfs(0, 0, new char[L]);
		System.out.println(sb);
	}

	private static void dfs(int cnt, int start, char[] temp) {
		if (cnt == L) {
			int vow_count = 0;
			int con_count = 0;
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < vowles.length; j++) {
					if (temp[i] == vowles[j]) {
						vow_count++;
					}
				}
			}
			con_count = temp.length - vow_count;
			if (vow_count >= 1 && con_count >= 2) {
				for(int i=0;i<temp.length;i++) {
					sb.append(temp[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = start; i < words.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[cnt] = words[i];
				dfs(cnt + 1, i + 1, temp);
				visited[i] = false;
			}
		}
	}

}
