package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2263 {
	static ArrayList<Integer> preOrder;
	static int[] inOrder;
	static int[] postOrder;

	public static void tree(int in_s, int in_e, int post_s, int post_e) {
		if(in_e >= in_s || post_e >= post_s) {
			int value = postOrder[post_e];
			int idx = 0;
			for(int i=in_s;i<=in_e;i++) {
				if(value == inOrder[i]) {
					idx = i;
					break;
				}
			}
			preOrder.add(value);
			tree(in_s, idx-1, post_s, post_s+(idx-1-in_s));
			tree(idx+1, in_e, post_s+(idx-in_s), post_e-1);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		inOrder = new int[N];
		postOrder = new int[N];
		preOrder = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		tree(0, inOrder.length-1, 0, postOrder.length-1);
		for (int i : preOrder) {
			sb.append(i+" ");
		}
		System.out.println(sb);
	}

}
