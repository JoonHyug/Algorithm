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
		//0�� �ε����� ������ ����, 1�� �ε����� ������ ����
		Stack<int[]> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());

		for(int i=1;i<=N;i++) {
			int value = Integer.parseInt(st.nextToken());
			//���ÿ� ���� ������ �ݺ�
			while(!stack.isEmpty()) {
				//�޾ƿ� ������ ���̺��� ���ÿ� ����ִ� ������ ���̰� ������
				//���̰� ���� ������ ������ ���
				if(stack.peek()[0] >= value ) {
					sb.append(stack.peek()[1]+" ");
					break;
				}
				//������ ����ؼ� pop�ؼ� ������ ���
				stack.pop();
			}
			//������ ����ִٸ� 0�� ���
			if(stack.isEmpty()) {
				sb.append(0+" ");
			}
			//���ÿ� int[]�� ����, 0 : ����, 1 : ����
			stack.push(new int[] {value, i});
		}
		System.out.println(sb.toString());
	}

}
