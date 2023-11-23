package offline.day230207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution_2805_농작물수확하기_황준혁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] parm = new int[N][N];
			for(int i=0;i<N;i++) {
				String[] temp = br.readLine().split("");
				for(int j=0;j<N;j++) {
					parm[i][j] = Integer.parseInt(temp[j]);
				}
			}
			int result = 0;
			for(int i=0;i<N;i++) {
				if(N/2 >= i) {
					for(int j=N/2-i;j<=N/2+i;j++) {
						result += parm[i][j];
					}					
				} else {
					for(int j=i-N/2;j<N-(i-N/2);j++) {
						result += parm[i][j];
					}
				}
			}
			System.out.println(result);
		}
		
	}

}
