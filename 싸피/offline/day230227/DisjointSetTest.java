/**
 * 서로소 집합
 * 
 */

package offline.day230227;

import java.util.Arrays;
import java.util.Scanner;

public class DisjointSetTest {

	static int N; // 요소의 개수 (0~N-1 요소)
	static int[] parents; // 서로소 집합 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parents = new int[N];

		makeSet();
		
		System.out.println(union(0, 3));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2, 4));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(1, 2));
		System.out.println(Arrays.toString(parents));

		System.out.println(union(3, 4));
		System.out.println(Arrays.toString(parents));
		
	}

	/**
	 * N = 5 index 0 1 2 3 4 value [0][1][2][3][4] index : 집합의 요소 value : index 요소가
	 * 포함된 집합의 대표 원소
	 */
	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	/**
	 * a요소가 포함된 집합의 대표원소를 받화하는 메소드
	 * @return a요소가 포함된 집합의 대표 원소
	 */
	private static int find(int a) {
		//a요소가 해당 집합의 대표 원소인 경우, a를 반환
		if(parents[a] == a) return a;
		
		
		//path compression
		//현재 a원소가 대표원소를 직접 바라보게 설정
		parents[a] = find(parents[a]);
		return find(parents[a]);
	
		
	}

	/**
	 * a, b 두 원소가 포함된 집합들의 합집합 연산
	 * @param a
	 * @param b
	 * @return 합집합 연산 성공 시 true 반환 - 확장성을 위해
	 */
	private static boolean union(int a, int b) {
		//1. a원소와 b원소의 대표 원소 찾기
		int rootA = find(a);
		int rootB = find(b);
		
		//a, b 집합의 대표원소가 같다면 이미 같은 집합이므로 flase를 반환
		if(rootA == rootB) return false;
		
		//b가 속한 집합이 a가 속한 집합에 포함되도록 설정
		parents[rootB] = rootA;
		return true;
		
	}
}
