package offline.day230215;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {

//	static class Custom implements Comparable<Custom>{
//		int x;
//		public Custom(int x) {
//			this.x = x;
//		}
//		@Override
//		public int compareTo(Custom o) {
//			return this.x - o.x;
//		}
//	}
	static class Custom {
		int x;

		public Custom(int x) {
			this.x = x;
		}
	}

	public static void main(String[] args) {
		//클래스에 Comparable을 상속받거나 람다표현식으로 생성자에 선언해주면 된다.
//		PriorityQueue<Custom> pq2 = new PriorityQueue<>();
		PriorityQueue<Custom> pq2 = new PriorityQueue<Custom>((o1, o2) -> o1.x - o2.x);
		pq2.add(new Custom(10));
		pq2.add(new Custom(20));

//		Custom c = new Custom(34);
//		Comparable com = (Comparable) c;

//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		pq.add(1);
		pq.add(30);
		pq.add(5);
		pq.add(1100);

		// pq의 정렬 기준대로 반환
		while (!pq.isEmpty()) {
			int num = pq.poll();
			System.out.println(num);
		}

		// 단순히 내부에 저장된 물리적인 순서로 출력
//		for(int num : pq) {
//			System.out.println(num);
//		}
		
//		PriorityQueue<String> pq3 = new PriorityQueue<String>((o1, o2) -> o2.compareTo(o1));
		PriorityQueue<String> pq3 = new PriorityQueue<String>(Collections.reverseOrder());
		
		pq3.add("A");
		pq3.add("C");
		pq3.add("B");
		pq3.add("F");

		// pq의 정렬 기준대로 반환
		while (!pq3.isEmpty()) {
			String s = pq3.poll();
			System.out.println(s);
		}
	}

}
