package offline.day230208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Main_11660_구간합구하기5_황준혁 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] temp = new int[N+1][N+1];
		for(int i=1;i<temp.length;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<temp[i].length;j++) {
				temp[i][j] = temp[i-1][j] + temp[i][j-1] - temp[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			result = temp[x2][y2]-temp[x2][y1-1]-temp[x1-1][y2] + temp[x1-1][y1-1];
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
//		for(int i=0;i<temp.length;i++) {
//			for(int j=0;j<temp[i].length;j++) {
//				System.out.print(temp[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

}
