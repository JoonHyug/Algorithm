import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] S;
	static int[] B;
	static ArrayList<Integer> SS = new ArrayList<>();
	static ArrayList<Integer> BB = new ArrayList<>();
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			max = i;
			SS_cal(0, 0, 1);
			BB_cal(0, 0, 0);
		}
		int result = 1000000001;
		for(int i=0;i<SS.size();i++) {
			result = Math.min(result, Math.abs(SS.get(i) - BB.get(i)));
		}
		System.out.println(result);

	}

	private static void SS_cal(int cnt, int start, int cal) {
		if (cnt == max) {
			SS.add(cal);
			return;
		}
		for (int i = start; i < N; i++) {
			SS_cal(cnt + 1, i + 1, cal * S[i]);
		}
	}

	private static void BB_cal(int cnt, int start, int cal) {
		if (cnt == max) {
			BB.add(cal);
			return;
		}
		for (int i = start; i < N; i++) {
			BB_cal(cnt + 1, i + 1, cal + B[i]);
		}
	}

}