package baekjoon;

import java.util.*;
public class p1541 {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String[] temp = sc.next().split("\\-");
		for(int i=0;i<temp.length;i++) {
			if(temp[i].contains("+")) {
				int sum = 0;
				String[] add = temp[i].split("\\+");
				for(int j=0;j<add.length;j++) {
					sum += Integer.parseInt(add[j]);
				}
				nums.add(sum);
			} else {
				nums.add(Integer.parseInt(temp[i]));				
			}
			
		}
		int result = nums.get(0);
		for(int i=1;i<nums.size();i++) {
			result -= nums.get(i);
		}
		System.out.println(result);
	}

}
