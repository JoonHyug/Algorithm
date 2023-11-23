/**
 * 문제 해석
 * R x C
 * 첫번째 열 : 가스관
 * 마지막 열 : 빵집
 * 
 * 빵집과 가스관을 연결할 수 있는 파이프라인 최대 개수 구하기
 * 
 * 파이프라인의 방향
 * - 오른쪽, 오른쪽 위, 오른쪽 아래
 * 
 * 500만개
 * . : 빈칸
 * x : 건물
 * 
 * 조건 : 건물의 경우는 파이프 설치 불가
 * 
 * 1. 위쪽에서부터 각 행마다 파이프라인 설치시도 했을 때 
 * 	방향을 오른쪽 위, 오른쪽, 오른쪽 아래 순서로 설치해보는 것이 유리하다고 결정(그리디적 사고)
 * 2. 각 좌표에서 파이프를 세방향으로 설치해보기
 * 		- 해당 방향의 다음 좌표가 경계 벗어나면 X
 * 		- 해당 방향의 다음 좌표가 벽이면 X
 * 		- 해당 방향의 다음 좌표가 설치된 파이프('-')라면 안됨
 * 		- 파이프 설치 경우 '-'로 체크
 * 		- 파이프라인 설치 성공여부에 관계없이 설치된 파이프 정보는 되돌리지 않음
 * 3. 마지막 열까지 파이프를 설치하는데 성공했다면 하나의 파이프라인 설치 완료
 * 		- 파이프라인 설치 수 cnt
 * 파이프라인 설치가 완료되면 설치 시도 중지
 */
package offline.day230221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Main_3109_빵집_황준혁_교수님_boolean {

	//오른쪽 위, 오른쪽, 오른쪽 아래 행 변화량 델타값
	final static int[] dr = {-1, 0, 1};
	
	static char[][] map; //맵 정보
	static int R, C;	//맵의 행열 크기
	
	static int pipeLineCnt; //파이프라인 설치 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for(int i=0;i<map.length;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//step 01. 각 행에 대한 파이프라인 설치 시도
		for(int r=0;r<R;r++) {
			if(setPipe(r, 0)) pipeLineCnt++;
		}
		System.out.println(pipeLineCnt);
	}

	/**
	 * 현재 좌표에서 파이프를 세 방향으로 설치해보고 다음 좌표에서의 파이프 설치는 재귀로 넘김
	 * @param r 현재 좌표 행값
	 * @param c 현재 좌표 열값
	 */
	private static boolean setPipe(int r, int c) {
		//step 03. 마지막 열이라면 파이프라인 설치 완료
		if(c == C-1) {
			return true;
		}
		//step 02. 세가지 방향으로 파이프 설치하기
		for(int d=0;d<dr.length;d++) {
			//선택된 방향의 다음 좌표
			int nr = r+dr[d];
			int nc = c+1;
			//경계 안에 있거나 빈칸이어야함
			if(0 <= nr && nr < R && map[nr][nc] == '.') {
				//파이프 설치
				map[nr][nc] = '-';
				//다음 좌표에서 파이프 설치는 재귀로 넘김
				//현재 설치에 대한 결과가 성공으로 이어진다면 true값을 반환
				if(setPipe(nr, nc)) return true;
			}
		}
		//세 가지 방향에 대해 설치해보았을대 모두 실패했다면
		return false;
	}

}
