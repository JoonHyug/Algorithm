package offline.day230222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로_황준혁 {

	static int N;
	static int[] company;
	static int[] home;
	static int[][] customer;
	static boolean[] visited;
	
	static int min;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			company = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			home = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			customer = new int[N][2];
			for(int i=0;i<N;i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());				
			}
			min = Integer.MAX_VALUE;
			visited = new boolean[N];
			test(0, 0, 0, company);
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	
	private static void test(int cnt, int start, int sum, int[] xy) {
		if(cnt == N) {
			int value = Math.abs(home[0] - xy[0]) + Math.abs(home[1] - xy[1]);
			min = Math.min(min, sum + value);
			return;
		}
		for(int i=0;i<customer.length;i++) {
			if(!visited[i]) {
				int value = Math.abs(customer[i][0] - xy[0]) + Math.abs(customer[i][1] - xy[1]);
//				System.out.println(cnt +" : "+i+", "+value+" = "+sum);
				visited[i] = true;
				test(cnt + 1, i + 1, sum + value, new int[]{customer[i][0], customer[i][1]});				
				visited[i] = false;
			}
		}
	}

}
