import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] temp = new int[N][2];
		int maxX = 0, maxY = 0;
		for(int i=0;i<temp.length;i++) {
			st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = Integer.parseInt(st.nextToken());
			maxX = Math.max(maxX, temp[i][0]+10);
			maxY = Math.max(maxY, temp[i][1]+10);
		}
//		boolean[] x = new boolean[maxX+1];
//		boolean[] y = new boolean[maxY+1];
		boolean[][] color = new boolean[maxX][maxY];
		int sum = 10*10*N;
		int cnt = 0;
		for(int i=0;i<temp.length;i++) {
			for(int j=temp[i][0];j<temp[i][0]+10;j++) {
				for(int k=temp[i][1];k<temp[i][1]+10;k++) {
					if(color[j][k] != true) color[j][k] = true;
					else cnt++;
				}
			}
		}
		sum -= cnt;
//		for(int i=0;i<temp.length;i++) {
//			int cntX = 0, cntY = 0;
//			for(int j=temp[i][0];j<temp[i][0]+10;j++) {
//				if(x[j] != true) x[j] = true;
//				else cntX++;
//			}
//			for(int j=temp[i][1];j<temp[i][1]+10;j++) {
//				if(y[j] != true) y[j] = true;
//				else cntY++;
//			}
//			sum -= cntX * cntY;
//			System.out.println(cntX+" * "+cntY+" = "+cntX * cntY);
//		}
		System.out.println(sum);
	}

}