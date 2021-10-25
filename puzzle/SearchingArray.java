package puzzle;

import java.util.Arrays;

public class SearchingArray {

	public static void main(String[] args) {
		
		int[] array = new int[5000]; 
		int[] unorderedArray = new int[array.length]; 
		int[] array2 = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i+1;						// 1부터~1,000,000까지 오름차순으로 저장
			array2[i] = i+1;						// 1부터~1,000,000까지 오름차순으로 저장
			unorderedArray[i] = array.length-i; // 1부터~1,000,000까지 내림차순으로 저장
			
		}
		
		array2[array2.length-1] = 1;
		array2[0] = array2.length;
		
		int value = 10;  //찾고 싶은 값 
		
//		linearSearch(array,value);
//		binarySearch(array,value);
//		bubbleSort(unorderedArray,array); 
//		selectionSort(unorderedArray,array);
//		insersionSort(unorderedArray,array);
//		insersionSort(array2,array);
		selectionSort(array2,array);
		
		
		
	}
		//삽입정렬
	 static void insersionSort(int[] unorderedArray, int[] array) {
		
		 int compare = 0; //비교 진행 카운트
		 int sweap = 0; //교환 진행 카운트
		 
		 for(int i = 1; i < unorderedArray.length;i++) {
			int tempPosition = i;
			int tempValue = unorderedArray[i];  // 선택한 값
			
			//선택한 값과 선택한 값 왼쪽에 있는 값을 비교후 선택한 값이 작으면 교체가 이루어진다.(공백이 왼쪽 끝에 있을 경우 교체 작업 종료) 
			while(tempPosition > 0 && unorderedArray[tempPosition-1] > tempValue) {
				unorderedArray[tempPosition] = unorderedArray[tempPosition-1];
				tempPosition --;
				compare++;
			}
			unorderedArray[tempPosition] = tempValue; // 공백에 선택한 값 저장.
			sweap++;

	 }// for i 종료
		 
		 if(Arrays.equals(unorderedArray, array)) {   //오름차순으로 정렬된 배열과 같으면 
			 System.out.println(unorderedArray.length+" 길이의 내림차순 배열을 오름차순으로 정렬 완료");	
			 System.out.println("비교:"+compare+", 교환:"+sweap+", 총:" + (compare+sweap)+" 단계");
		 }
		
	}
	 
	 //선택정렬
	static void selectionSort(int[] unorderedArray, int[] array) {
		
		 int compare = 0; //비교 진행 카운트
		 int sweap = 0; //교환 진행 카운트
		 
		 for(int i = 0; i < unorderedArray.length;i++) {
			 int lowestValueIndex = i;
			 
			for(int j = i+1; j < unorderedArray.length;j++) {
				compare++;
				if(unorderedArray[j] < unorderedArray[lowestValueIndex]) {  //비교 후 새로운 최소값 발견시 
					lowestValueIndex = j;    								//해당 인덱스 저장
				}
			}//for j 종료 
			if(lowestValueIndex != i) {
				int temp = unorderedArray[i]; 							    //발견한 인덱스로 값을 교환하는 절차 실행
				unorderedArray[i] = unorderedArray[lowestValueIndex];
				unorderedArray[lowestValueIndex] = temp;
				sweap++;
			}
			
		 }// for i 종료
		 if(Arrays.equals(unorderedArray, array)) {   //오름차순으로 정렬된 배열과 같으면 
			 System.out.println(unorderedArray.length+" 길이의 내림차순 배열을 오름차순으로 정렬 완료");	
			 System.out.println("비교:"+compare+", 교환:"+sweap+", 총:" + (compare+sweap)+" 단계");
		 }
	}

	//내림차순으로 정렬된 배열을 오름차순 정렬로 바꾸기 
	static void bubbleSort(int[] unorderedArray, int[] array) {
		
		int compare = 0; //비교 진행 카운트
		int sweap = 0; //교환 진행 카운트
		for(int i = 0; i < unorderedArray.length-1; i++) {
			for(int j = 0; j < unorderedArray.length-1-i; j++) {
				compare++;
				if(unorderedArray[j]>unorderedArray[j+1]) {
					sweap++;
					int temp = unorderedArray[j];
					unorderedArray[j] = unorderedArray[j+1];
					unorderedArray[j+1] = temp;
				}
			}
		}// for문 종료
		if(Arrays.equals(unorderedArray, array)) {   //오름차순으로 정렬된 배열과 같으면 
			System.out.println(unorderedArray.length+" 길이의 내림차순 배열을 오름차순으로 정렬 완료");			
			System.out.println("비교:"+compare+", 교환:"+sweap+", 총:" + (compare+sweap)+" 단계");
		}
		
	}

	static void binarySearch(int[] array, int value) {
		System.out.println("----------------");
		System.out.println("binarySearch");
		int count = 0;   //진행 단계를 카운트 하기 위한 변수
		int lower = 0;          //하한선(배열의 처음값)
		int upper = array.length-1;  //상한선(배열의 마지막 값)
		
		//상한선과 하한선 사이의 가운데 값을 확인하는 과정을 하한선이 상한선과 같아지거나 커질때까지 반복한다.
		while(lower <= upper) {
			count++;
			int mid = (lower + upper) /2;
			int midValue = array[mid];
			
			if(midValue >value) {   
				upper = mid-1;
				System.out.println("상한선줄임 :"+upper+" 횟수:"+count);
				
			}else if(midValue<value){
				lower = mid+1;
				System.out.println("하한선증가 :"+lower+" 횟수:"+count);
				
			} else if(midValue==value){
				System.out.println("총 : " + count+"단계 진행했으며 "+midValue+" 값을 찾았다.");
				return;  // 값 검색 성공.
			}
		}
		
		System.out.println("총 : "+count+"단계 진행했으며 못찾았다."); // 검색 실패.
	
	}
	
	// linearSearch
	static void linearSearch(int[] array,int value) {
		System.out.println("----------------");
		System.out.println("linerSearch");
		int count = 0; // 카운트를 위한 변수 
		
		for(int i = 0; i < array.length; i++) {
			count++;
			if(array[i]==value) {
				System.out.println("찾았다. 진행한 단계:" + count);
				return;
			}
		
		}
		System.out.println("총 : "+count+"단계 진행했으며 못찾았다.");
	}
}