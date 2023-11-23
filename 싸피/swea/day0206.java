package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class day0206 {
	public static int check(char[] str) {
		int cnt = 0;
		char prev = '0';
		for(int i=0;i<str.length;i++) {
			char now = str[i];
			if(prev != now) {
				cnt++;
				prev = now;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String memo = br.readLine();
			sb.append("#"+tc+" ").append(check(memo.toCharArray())).append("\n");
		}
		System.out.println(sb.toString());
	}

}
