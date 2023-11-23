package offline.day230207;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	static int N;		//요소의 개수
	static int[] array;	//요소 정보
	static int R;		//뽑을 요소의 개수
	static int[] picked; //선택한 요소 정보
	static boolean[] visited;	//요소를 사용했는지 여부 - true명 사용중
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		array = new int[N];
		for(int i=0;i<N;i++) {
			array[i] = i+1;
		}
		System.out.println("원본 요소 : "+Arrays.toString(array));
//		loopPermutation();
		picked = new int[R];
		visited = new boolean[N];
		permutation(0);
	}
	/**
	 * 요소를 선택하고 다음 요소의 선택은 재귀로 넘김
	 * @param cnt 현재까지 선택한 요소의 개수 or 현재 cnt 번째 요소를 선택할 차례
	 */
	
	private static void permutation(int cnt) {
		//기저 조건
		if(cnt == R) {
			System.out.println(Arrays.toString(picked));
			return;
		}
		//요소를 선택 - i는 array에서 선택할 요소의 인덱스
		for(int i=0;i<N;i++) {
			//이전에 선택했던 요소 제외
			if(!visited[i]) {
				//다음 번째 선택을 위해 체크
				visited[i] = true;
				//요소 선택
				picked[cnt] = array[i];
				//다음 요소 (cnt+1번쨰) 선택은 재귀에 맡김
				permutation(cnt + 1);
				//다음 요소의 고려를 위해 선택 정보 되돌리기
				visited[i] = false;
			}
		}
	}
	
	/**
	 * N개의 요소중 3개를 뽑아서 나열하는 순열의 경우를 모두 출력
	 */
	private static void loopPermutation() {
		//0번째 요소 선택
		for(int i=0;i<N;i++) {
			//1번째 요소 선택(0번째 뽑았던 요소 제외)
			for(int j=0;j<N;j++) {
				if(i != j) {
					//2번째 요소 선택
					for(int k=0;k<N;k++) {
						if(i != k && j != k) {
							//i, j, k는 array에서 선택된 요소의 인덱스
							System.out.println(array[i]+" "+array[j]+" "+array[k]);
						}
					}
				}
			}
		}
	}
	

}
