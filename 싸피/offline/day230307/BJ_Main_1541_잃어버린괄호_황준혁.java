package offline.day230307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_Main_1541_잃어버린괄호_황준혁 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		String[] temp = br.readLine().split("-");
		for(int i=0;i<temp.length;i++) {
			if(temp[i].contains("+")) {
				String[] add = temp[i].split("\\+");
				int hap = 0;
				for(int j=0;j<add.length;j++) {
					hap += Integer.parseInt(add[j]);
				}
				list.add(hap);
			} else {
				list.add(Integer.parseInt(temp[i]));				
			}
		}
		int result = list.get(0);
		for(int i=1;i<list.size();i++) {
			result -= list.get(i);
		}
		System.out.println(result);
//		System.out.println(list);
		
	}

}
