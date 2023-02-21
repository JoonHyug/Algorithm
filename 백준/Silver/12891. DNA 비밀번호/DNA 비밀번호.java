import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int S;
	static int P;
	static char[] dna;
	static int[] arr;
	static int result;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dna = br.readLine().toCharArray();
		// {A, C, G, T}
		arr = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		temp = new int[4];
		int start = 0;
		int end = P;
		for(int i=start;i<end;i++) {
			plus(dna[i]);
		}
		while(true) {
			if(check()) result++;
			if(end >= S) break;
			minus(dna[start]);
			plus(dna[end]);
			start++;
			end++;
		}
		System.out.println(result);
	}

	private static boolean check() {
		for (int j = 0; j < arr.length; j++) {
			if (temp[j] < arr[j]) {
				return false;
			}
		}
		return true;
	}
	private static void plus(char c) {
		if (c == 'A') {
			temp[0]++;
		} else if (c == 'C') {
			temp[1]++;
		} else if (c == 'G') {
			temp[2]++;
		} else if (c == 'T') {
			temp[3]++;
		}		
	}
	private static void minus(char c) {
		if (c == 'A') {
			temp[0]--;
		} else if (c == 'C') {
			temp[1]--;
		} else if (c == 'G') {
			temp[2]--;
		} else if (c == 'T') {
			temp[3]--;
		}		
	}

}