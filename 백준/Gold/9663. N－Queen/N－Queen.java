import java.util.Scanner;

public class Main {

	static int N;
	static int[] queen; //각 인덱스에는 각 행에서 퀸의 위치를 저장
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queen = new int[N];
		dfs(0);
		System.out.println(result);
	}
	
	//cnt : n번째 행을 의미
	private static void dfs(int cnt) {
		//퀸이 n개인 경우를 제외하고는 카운트 할 필요가 없다.
		if(cnt == N) {
			result++;
			return;
		}
		for(int i=0;i<queen.length;i++) {
			queen[cnt] = i;
			if(check(cnt)) {
				dfs(cnt + 1);
			}
		}
	}
	
	private static boolean check(int idx) {
		//0~idx(0~3)까지를 탐색하면서 다음 행으로 이동하기 위한 방법이 존재하는지 체크
		for(int i=0;i<idx;i++) {
			//수직, 수평 위치에 퀸이 존재하는지 체크
			if(queen[i] == queen[idx]) return false;
			//대각선 위치에 퀸이 존재하는지 체크
			if(Math.abs(idx-i) == Math.abs(queen[idx] - queen[i])) return false;
		}
		return true;
	}

}