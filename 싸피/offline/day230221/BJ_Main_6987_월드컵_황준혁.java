package offline.day230221;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_Main_6987_월드컵_황준혁 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int win;
	static int draw;
	static int lose;
	static int[][] temp;
	
	public static void main(String[] args) throws IOException {
		for(int c=0;c<1;c++) {
			temp = new int[6][3];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<temp.length;i++) {
				for(int j=0;j<temp[i].length;j++) {
					temp[i][j] = Integer.parseInt(st.nextToken());				
				}
			}
			win = 0;
			draw = 0;
			lose = 0;
			test(0, 1);
		}
		
	}
	
	private static void test(int cnt, int start) {
		/**
		 * A : B, C, D, E, F - 5
		 * B : C, D, E, F 	 - 4
		 * C : D, E, F 		 - 3
		 * D : E, F 		 - 2
		 * E : F 			 - 1
		 * 				       총 15개
		 */
		if(cnt == temp.length) {
			return;
		}
		for(int i = start; i<temp.length;i++) {
			//승
			if(temp[cnt][0] != 0) {
				temp[cnt][0]--;
				temp[i][2]--;
			}
				
			//무
			else if(temp[cnt][1] != 0) {
				temp[cnt][1]--;
				temp[i][1]--;
			}
				
			//패
			else if(temp[cnt][2] != 0) {
				temp[cnt][2]--;
				temp[i][0]--;
			}
			System.out.println(Arrays.deepToString(temp));
			test(cnt + 1, i + 1);
		}
		
		

	}
	
	

}
