package baekjoon;

import java.util.*;
import java.io.*;

public class p10828 {
	private int[] arr;
	private int top = -1;

	public void push(int value) {
		arr[++top] = value;
	}

	public int pop() {
		if (top == -1) {
			return -1;
		}
		int temp = arr[top];
		arr[top--] = 0;
		return temp;
		
	}

	public int size() {
		return top+1;
	}

	public int empty() {
		if (top == -1) {
			return 1;
		}
		return 0;
	}

	public int top() {
		if(top == -1) {
			return -1;
		}
		return arr[top];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		p10828 stack = new p10828();
		int T = Integer.parseInt(br.readLine());
		stack.arr = new int[T];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			case "push":
				int value = Integer.parseInt(st.nextToken());
				stack.push(value);
				break;
			case "pop":
				sb.append(stack.pop()).append('\n');
				break;
			case "size":
				sb.append(stack.size()).append('\n');
				break;
			case "empty":
				sb.append(stack.empty()).append('\n');
				break;
			case "top":
				sb.append(stack.top()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}

}
