package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		System.out.println(cal(A, B, C));
	}

	private static long cal(long A, long B, long C) {
		if (B == 1) {
			//B�� 1�̸� ���� �ּҷ� ���ҵǴ� �κ��̱� ������ A % C�� ��ȯ
			return A % C;
		}

		long temp = cal(A, B / 2, C);

		if (B % 2 == 0) {
			//(temp % C) * (temp % C) = (temp * temp) % C = temp * temp % C
			return temp * temp % C;
		} else {
			//temp * temp * A�� long�� ������ ��� �� �ֱ� ������ ���� %����
			//Ȧ���� 1�� �� ������� �ϱ� ������ A�� �߰�
			return ((temp * temp % C) * A) % C;
		}
	}

}
