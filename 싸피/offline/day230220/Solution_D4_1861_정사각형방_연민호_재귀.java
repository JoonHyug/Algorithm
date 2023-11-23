package offline.day230220;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_연민호_재귀 {

	static int[][] map; // 방 정보
	static int N; // 방의 행열 크기
	
	static int maxNum; //최대이동가능횟수인 방번호
	static int maxCnt; //최대이동가능횟수
	
	static int curNum;	//현재 탐색중인 시작점의 번호
	
	//상하좌우 델타
	final static int[] dr = {-1, 1, 0, 0};
	final static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/day230220/정사각형방_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());	//방의 행열 크기
			map = new int[N][N];	//방 입력 공간 생성
			
			//방정보 입력
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxNum = Integer.MAX_VALUE;	//최대이동가능횟수인 방번호 초기화
			maxCnt = 0;	//최대이동가능횟수 초기화
			
			
			//모든 시작점을 기준으로 이동가능횟수 탐색
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					curNum = map[i][j];	//시작점 번호 저장
					move(i, j, 1);
				}
			}
			
			
			System.out.println("#"+tc+" "+maxNum+" "+maxCnt);
		}
	}

	/**
	 * 현재 좌표 기준 사방 중 이동가능한 방이 있다면 해당 지점 기준 탐색은 재귀에 넘김
	 * @param r 행 좌표
	 * @param c 열 좌표
	 * @param cnt 현재까지의 이동횟수
	 */
	private static void move(int r, int c, int cnt) {
		
		//4방 탐색
		for(int d=0; d<4; d++) {
			//다음 좌표
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			//경계 벗어X, (r,c)좌표값 +1 = (nr,nc) 이라면 이동
			//이동 가능한 방 발견
			if( nr>=0 && nr<N && nc>=0 && nc<N && map[r][c]+1==map[nr][nc]) {
				move(nr, nc, cnt+1);
				return;
			}
		}
		// 이동가능한 방을 만나지 못한 경우( 더 이상 이동 불가능 )
		//현재 이동 횟수 > 최대이동횟수 
		//현재 이동 횟수 == 최대이동횟수 이고, 시작점의 번호 < 최대이동횟수번호
		if(cnt > maxCnt || ( cnt==maxCnt && curNum < maxNum ) ) {
			maxCnt = cnt;
			maxNum = curNum;
		}
	}
}

