package offline.day230209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_Main_2961_도영이가만든맛있는음식_황준혁2 {
	static int S;
	static int P;
	static char[] dna;
	// {A, C, G, T}
	static int[] arr = new int[4];
	static int result;
	static int[] temp = new int[4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dna = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<P;i++) {
			plus(dna[i]);
		}
		for (int i = 0; i < S - P; i++) {
			check();
			minus(dna[i]);
			plus(dna[P+i]);
		}
		System.out.println(result);
	}

	private static void check() {
		for (int j = 0; j < arr.length; j++) {
			if (temp[j] < arr[j]) {
				return;
			}
		}
		result++;
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
