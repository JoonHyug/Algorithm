package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p6987 {
	
	static int N = 6;
	static int[][] result = new int[N][3];
	static boolean isSuccess;
	
	//경기에 대한 경우의 수
	static int[][] matchInfo = new int[15][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int idx = 0;
		for(int i=0;i<N;i++) {
			for(int j = i + 1;j<N;j++) {
				matchInfo[idx][0] = i;
				matchInfo[idx][1] = j;
				idx++;
			}
		}
		
		for(int tc=0;tc<4;tc++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				result[i][0] = Integer.parseInt(st.nextToken()); //win			
				result[i][1] = Integer.parseInt(st.nextToken()); //draw	
				result[i][2] = Integer.parseInt(st.nextToken()); //lose	
			}
			isSuccess = false;
			dfs(0);
			sb.append(isSuccess?1:0).append(" ");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int cnt) {
		if(cnt == 15) {
			for(int i=0;i<N;i++) {
				if(result[i][0] != 0 || result[i][1] != 0 || result[i][2] != 0) return;
			}
			isSuccess = true;
			return;
		}
		
		int country1 = matchInfo[cnt][0];
		int country2 = matchInfo[cnt][1];
		
		//나라1이 승
		result[country1][0]--;
		result[country2][2]--;
		dfs(cnt + 1);
		result[country1][0]++;
		result[country2][2]++;
		
		//무승부
		result[country1][1]--;
		result[country2][1]--;
		dfs(cnt + 1);
		result[country1][1]++;
		result[country2][1]++;
		
		//나라1이 패
		result[country1][2]--;
		result[country2][0]--;
		dfs(cnt + 1);
		result[country1][2]++;
		result[country2][0]++;
		
		
	}

}
