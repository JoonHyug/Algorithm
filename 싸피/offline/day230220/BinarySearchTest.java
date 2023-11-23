package offline.day230220;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//이진탐색 전제조건 : 정렬
		int[] arr = {3, 11, 15, 20, 21, 29, 45, 59, 65, 72};
		//arr배열 20 요소가 있는지 체크
		int find = sc.nextInt();
		int result = binarySearch(arr, find);
		System.out.println(result == -1?-1:arr[result]);
		
		int result2 = binarySearchRecursive(arr, find, 0, arr.length-1);
		System.out.println(result2 == -1?-1:arr[result2]);
		
		//라이브러리 활용(탐색 시 마지막 인덱스 에서 -1 곱하고 -1 출력)
		System.out.println(Arrays.binarySearch(arr, find));
	}

	//해당 배열에 찾고자 하는 요소가 있다면 해당 요소의 인덱스를 반환
	//없다면 -1을 반환
	private static int binarySearch(int[] arr, int find) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2; //중앙 요소의 인덱스

			//찾을 요소와 현재 범위의 중앙 요소 비교
			//중앙 인덱스의 오른쪽에 찾고자하는 값이 있음
			if(find > arr[mid]) start = mid + 1;
			//중앙 인덱스 왼쪽에 찾고자 하는 값이 있음
			else if(find < arr[mid]) end = mid - 1;
			//찾고자 하는 요소 발견
			else return mid;
		}
		return -1;
	}
	/**
	 * start ~ end 요소의 중앙값과 찾을 요소를 비교하여 요소를 찾으면 해당 요소의 인덱스 반환
	 * 요소를 찾기 못하면 start or end 값을 수정하여 재귀로 넘김
	 * @param arr
	 * @param find
	 * @param start
	 * @param end
	 * @return
	 */
	private static int binarySearchRecursive(int[] arr, int find, int start, int end) {
		//기저 조건(종료)
		if(start > end) {
			return -1;
		}

		//유도 파트(반복)
		int mid = (start + end) / 2; //중앙 요소의 인덱스
		//찾을 요소와 현재 범위의 중앙 요소 비교
		//중앙 인덱스의 오른쪽에 찾고자하는 값이 있음
		if(find > arr[mid]) return binarySearchRecursive(arr, find, mid + 1, end);
		//중앙 인덱스 왼쪽에 찾고자 하는 값이 있음
		else if(find < arr[mid]) return binarySearchRecursive(arr, find, start, mid - 1);
		//찾고자 하는 요소 발견
		else return mid;
	}
}
