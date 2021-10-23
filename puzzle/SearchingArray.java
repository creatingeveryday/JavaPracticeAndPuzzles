package puzzle;

public class SearchingArray {

	public static void main(String[] args) {
		
		int[] array = new int[1000000]; 	// 1부터~1,000,000까지 오름차순으로 저장된 배열
		for(int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		int value = 1000000;  //찾고 싶은 값 
		
		linearSearch(array,value);
		binarySearch(array,value);
		
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