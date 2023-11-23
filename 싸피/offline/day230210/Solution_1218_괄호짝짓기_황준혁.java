package offline.day230210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_1218_괄호짝짓기_황준혁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int tc = 1;tc <= T;tc++) {
			Stack<Character> s = new Stack<>();
			int lng = Integer.parseInt(br.readLine());
			char[] arr = new char[lng];
			arr = br.readLine().toCharArray();
			for(int i=0;i<arr.length;i++) {
//				System.out.println(s+" / "+arr[i]);
				if(s.isEmpty() == true) {
					s.push(arr[i]);
				} else if(arr[i] == '}') {
					if(s.peek() == '{')	s.pop();
					else break;
				} else if(arr[i] == ']') {
					if(s.peek() == '[')	s.pop();
					else break;
				} else if(arr[i] == ')') {
					if(s.peek() == '(')	s.pop();
					else break;
				} else if(arr[i] == '>') {
					if(s.peek() == '<')	s.pop();
					else break;
				} else {
					s.push(arr[i]);					
				}

			}
			int answer = 0;
			if(s.isEmpty() == true) {
				answer = 1;
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}

}
