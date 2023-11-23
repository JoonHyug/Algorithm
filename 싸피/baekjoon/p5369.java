package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p5369 {

	static ArrayList<Integer> binTree = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		while ((s = br.readLine()) != null && !s.isEmpty()) {
			binTree.add(Integer.parseInt(s));
		}
//		System.out.println(binTree);
		search(0, binTree.size()-1);
		System.out.println(sb.toString());
	}

	private static void search(int idx, int end) {
		if(idx > end) {
			return;
		}
		int position = idx+1;
		for (int i = position; i <= end; i++) {
			if(binTree.get(idx) > binTree.get(i)) {
				position++;
			}
		}
		search(idx + 1, position-1);
		search(position, end);
		sb.append(binTree.get(idx)+"\n");
	}

}
