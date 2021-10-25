package puzzle;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		//배열을 분할한다는 것은? 배열로부터 임의의 수(피벗)을 가져와 피벗보다 작은 모든 수는 피벗의 왼쪽에, 피벗보다 큰 모든 수는 피벗의 오른쪽에 두는 것이다.(오른쪽피벗기준일때) 
		// 분할 단계 
		// 가장 오른쪽에 있는 값을 피벗으로 고를때 
		// 1. 왼쪽 포인터를 한 셀씩 계속 오른쪽으로 옮기면서 피벗보다 크거나 같은 값에 도달하면 멈춘다. 
		// 2. 이어서 오른쪽 포인터를 한셀씩 계속 왼쪽으로 옮기면서 피벗보다 작거나 같은 값에 도달하면 멈춘다.
		// 3. 왼쪽 포인터와 오른쪽 포인터가 가리키고 있는 값을 교환한다. 
		// 4. 두 포인터가 가리키는 값이 같거나 왼쪽 포인터가 오른쪽 포인터 바로 오른쪽으로 이동할때까지 위 과정을 반복한다. 
		// 5. 끝으로 왼쪽 포인터가 현재 가리키고 있는 값과 피벗을 모두 교환한다. 
		// 분할이 끝나면 피벗은 배열내에서 올바른 위치에 있다. 
		
		int[] array = {0,3,2,1,6,7,11,15,5};
		
		Partition p = new Partition(array);
		
		System.out.println(Arrays.toString(p.array));

		p.quickSort(0, p.array.length-1);
		
		System.out.println(Arrays.toString(p.array));

	}
}

class Partition {
	int[] array;
	Partition(int[] array){
		this.array = array;
	}
	
	
	 int partition(int leftPointer, int rightPointer) {
		
		int pivotPosition = rightPointer;
		int pivot = array[pivotPosition];
		
		rightPointer--;
		
		while(true) {
			while(array[leftPointer] < pivot) {
				leftPointer ++;
			}
			
			while(array[rightPointer] > pivot) {
				rightPointer --;
			}
			
			if (leftPointer >= rightPointer) {
				break;
			} else {
				swap(leftPointer,rightPointer);
			}
		}
		swap(leftPointer, pivotPosition);
		int left = leftPointer;
		return left;
		
		
	}
	
	void swap(int leftPointer, int rightPointer) {
		int temp = array[leftPointer];
		array[leftPointer] = array[rightPointer];
		array[rightPointer] = temp;
		
	}

	void quickSort(int leftIndex, int rightIndex) {
		
		if(rightIndex-leftIndex <= 0) {
			return;
		}
		
		int pivotPosition = partition(leftIndex, rightIndex);
		
		quickSort(leftIndex,pivotPosition-1); //피벗왼쪽배열 재귀적 함수 호출 처리 
		
		quickSort(pivotPosition+1,rightIndex); //피벗오른쪽 배열 재귀적 함수 호출 처리 
		
		
	}
	
}
