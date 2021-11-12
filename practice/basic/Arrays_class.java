package practice.basic;

import java.util.Arrays;
import java.util.List;

public class Arrays_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 =Arrays.asList("홍길동","김자바");
		System.out.println(list1.get(0));
		List<Integer> list2 = Arrays.asList(1,2,3);

		System.out.println(list2.get(2));
		
		//list2전체 출력하기
		//for문 
		//향상된 for 문
		//iterator 사용
		
		int[] arr = {0,1,2,3,4};
		int[] arr2 = Arrays.copyOf(arr, 7);
		for (int a : arr2) {
			System.out.print(a+" ");
		}
		System.out.println();
		int[] arr3 = Arrays.copyOfRange(arr, 1, 3);
		for (int a : arr3) {
			System.out.print(a+" ");
		}
		System.out.println();
		int[] arr4 = new int[5];
		Arrays.setAll(arr4, (i) -> (int)(Math.random()*5)+1);
		for (int a : arr4) {
			System.out.print(a+" ");
		}

	}

}
