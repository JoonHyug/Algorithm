package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] RGB = new int[N+1][3];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			RGB[i][0] = Math.min(RGB[i-1][1], RGB[i-1][2]) + R;
			RGB[i][1] = Math.min(RGB[i-1][0], RGB[i-1][2]) + G;
			RGB[i][2] = Math.min(RGB[i-1][0], RGB[i-1][1]) + B;
		}
		sb.append(Math.min(RGB[N][0], Math.min(RGB[N][1], RGB[N][2])));
		System.out.println(sb);
	}

}
