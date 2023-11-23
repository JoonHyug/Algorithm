package offline.day230215;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    static int[] arr;
    static int N, R;
    static int[] result;
    static boolean[] visited;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        
        arr= new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        result = new int[R];
        visited = new boolean[N];
        test1(0);
        System.out.println("===========================");
        test2(0, 0);
        System.out.println("===========================");
        test3(0);
    }
    private static void test1(int cnt) {
    	if(cnt == R) {
    		System.out.println(Arrays.toString(result));
    		return;
    	}
    	for(int i=0;i<arr.length;i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			result[cnt] = arr[i];
    			test1(cnt+1);
    			visited[i] = false;
    		}
    	}
    }
    private static void test2(int cnt, int start) {
    	if(cnt == R) {
    		System.out.println(Arrays.toString(result));
    		return;
    	}
    	for(int i=start;i<arr.length;i++) {
    		result[cnt] = arr[i];
    		test2(cnt+1, i+1);
    	}
    }
    private static void test3(int cnt) {
    	if(cnt == N) {
    		for(int i=0;i<arr.length;i++) {
    			if(visited[i]) {
    				System.out.print(arr[i]+" ");
    			}
    		}
    		System.out.println();
    		return;
    	}
    	visited[cnt] = true;
    	test3(cnt + 1);
    	visited[cnt] = false;
    	test3(cnt + 1);
    }
}
