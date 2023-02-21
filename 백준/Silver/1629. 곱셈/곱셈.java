import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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
			return A % C;
		}

		long temp = cal(A, B / 2, C);

		if (B % 2 == 0) {
			//(temp % C) * (temp % C) = (temp * temp) % C = temp * temp % C
			return temp * temp % C;
		} else {
			//temp * temp * A가 long의 범위를 벗어날 수 있기 때문에 먼저 %연산
			//홀수면 1을 더 곱해줘야 하기 때문에 A를 추가
			return ((temp * temp % C) * A) % C;
		}
	}

}