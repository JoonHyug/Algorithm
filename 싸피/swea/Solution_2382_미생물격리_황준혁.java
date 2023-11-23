/**
 * 1. 약품이 칠해진 칸에 도착하면 이동방향이 반대로 바뀌고 절반이 된다.
 * 	=> 2를 나눈 후 소수점 이하를 버림
 * 		=> 1마리인 경우 0.5가 되어 군집이 사라짐
 * 2. 군집이 한 칸에 모이면 군집이 합쳐진다.
 * 	=> 군집의 미생물 수는 각 군집의 미생물 수의 합, 이동 방향은 더 많은 군집의 이동방향으로 정해진다.
 * 		=> 군집의 미생물 수가 같은 경우는 주어지지 않는다.
 */
package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리_황준혁 {

	static class Micro{
		int y, x, num, d;

		public Micro(int y, int x, int num, int d) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
			this.d = d;
		}
		
	}
	
	static int N, M, K;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
		}
	}

}
