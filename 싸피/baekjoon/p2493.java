package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		//0번 인덱스는 빌딩의 높이, 1번 인덱스는 빌딩의 순서
		Stack<int[]> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());

		for(int i=1;i<=N;i++) {
			int value = Integer.parseInt(st.nextToken());
			//스택에 값이 있을때 반복
			while(!stack.isEmpty()) {
				//받아온 빌딩의 높이보다 스택에 들어있는 빌딩의 높이가 높으면
				//높이가 높은 빌딩의 순서를 출력
				if(stack.peek()[0] >= value ) {
					sb.append(stack.peek()[1]+" ");
					break;
				}
				//작으면 계속해서 pop해서 스택을 비움
				stack.pop();
			}
			//스택이 비어있다면 0을 출력
			if(stack.isEmpty()) {
				sb.append(0+" ");
			}
			//스택에 int[]을 생성, 0 : 높이, 1 : 순서
			stack.push(new int[] {value, i});
		}
		System.out.println(sb.toString());
	}

}
