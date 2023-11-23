package programmers;
import java.util.*;
public class BigNum {
//	static ArrayList<Integer> result = new ArrayList<>();
//    static boolean[] visited;
//    
//    public static void dfs(int[] num, String str, int cnt){
//        if(cnt == num.length){
//            result.add(Integer.parseInt(str));
//            return;
//        }
//        for(int i=0;i<num.length;i++){
//            if(!visited[i]){
//            	visited[i] = true;
//                dfs(num, str+num[i], cnt + 1);
//                visited[i] = false;
//            }
//        }
//    }
//    
//    public static String solution(int[] numbers) {
//        visited = new boolean[numbers.length];
//        dfs(numbers, "", 0);
//        int max = 0;
//        for(int i=0;i<result.size();i++){
//            if(max < result.get(i)) {
//            	max = result.get(i);
//            }
//        }
//        return Integer.toString(max);
//    }
	public static String solution(int[] numbers) {
		String[] stringNumbers = new String[numbers.length];
		
		//int형 배열을 String형 배열로 바꿈
		for(int i = 0; i < numbers.length; i++) {
			stringNumbers[i] = Integer.toString(numbers[i]);
		}
		
		//두 수를 번갈아가며 합친 수 중 큰 값을 앞으로 정렬(내림차순 정렬)
		Arrays.sort(stringNumbers, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				System.out.println(o2+o1+", "+o1+o2);
				System.out.println((o2+o1).compareTo(o1+o2));
				System.out.println("-------------");
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		if(stringNumbers[0].equals("0")) return "0";
		
		//문자열을 delimiter("") 기준으로 합침
		return String.join("", stringNumbers);
	}
	public static void main(String[] args) {
		int[] temp = {6, 10, 2};
		System.out.println(solution(temp));
		System.out.println("======================="); 
		int[] temp2 = {3, 30, 34, 5, 9};
		System.out.println(solution(temp2));
		
	}

}
