package practice.basic;

import java.util.Scanner;

public class ManagementMiniProject {

	public static void main(String[] args) {
		//배열을 활용.
		
		String[] itemCode = new String[5];//제품코드
		int[] productionCost = new int[5];//생산원가
		int[] receivingItem = new int[5];//입고량
		int[] salesVolume = new int[5];//판매량
		
		int[] stock = new int[5];//재고량 = 입고량-판매량
		int[] sales = new int[5];//판매금액 = 생산원가 * 20% * 판매량
		int[] profit = new int[5];//수익금액 = 판매금액 - (생산원가*판매량)
		
		Scanner sc = new Scanner(System.in);
		int itemCounter=0;
		
		while(true) {
			System.out.print(itemCounter+"번째 제품 정보를 입력하세요.");
			sc.nextLine();
			System.out.printf("제품코드 입력하세요.>>");
			itemCode[itemCounter] = sc.nextLine();
			
			
			System.out.print("생산원가를 입력하세요.>>");
			productionCost[itemCounter] = sc.nextInt();

			System.out.print("입고량을 입력하세요.>>");
			receivingItem[itemCounter] = sc.nextInt();
			
			System.out.print("판매량을 입력하세요.>>");
			salesVolume[itemCounter] = sc.nextInt();
			
			
			//재대로 입력받으면 계산시작하고 출력.
			
			stock[itemCounter] = receivingItem[itemCounter] - salesVolume[itemCounter]; //재고량 계산
			sales[itemCounter] =(int)(productionCost[itemCounter] * 1.2 * salesVolume[itemCounter]);//판매금액 계산
			profit[itemCounter] = sales[itemCounter] - (productionCost[itemCounter]*salesVolume[itemCounter]); // 수익금액 계산
			
			System.out.println("===========================================");
			System.out.println("             하이마트 제품코드별 보고서");
			System.out.println("-------------------------------------------");
			System.out.println("제품코드  생산원가  입고량  판매량  재고량   판매금액   수입금액");
			System.out.println("-------------------------------------------");
			int[] sum = new int[6];
			int[] average = new int[6];
			int[] max = new int[6];
			
			for(int i = 0; i<=itemCounter;i++) {
				System.out.printf("%s %d %d %d %d %d %d %n"
						,itemCode[i]
						,productionCost[i]
						,receivingItem[i]
						,salesVolume[i]
						,stock[i]
						,sales[i]
						,profit[i]
						);	
			}
			System.out.println("-------------------------------------------");
			for(int i =0; i<=itemCounter;i++) { //합계 계산
					sum[0] += productionCost[i];
					sum[1] += receivingItem[i];
					sum[2] += salesVolume[i];
					sum[3] += stock[i];
					sum[4] += sales[i];
					sum[5] += profit[i];
			}
			for(int i = 0; i < average.length; i++) { //평균 계산
				average[i] = sum[i] / (itemCounter+1);
			}
			
			//최대값 배열 초기화.
			max[0] = productionCost[0];
			max[1] = receivingItem[0];
			max[2] = salesVolume[0];
			max[3] = stock[0];
			max[4] = sales[0];
			max[5] = profit[0];
			
			for(int i =0; i<=itemCounter; i++) { //최대값 계산
				max[0] = (max[0] <= productionCost[i]) ? productionCost[i]: max[0];
				max[1] = (max[1] <= receivingItem[i]) ? receivingItem[i]: max[1];
				max[2] = (max[2] <= salesVolume[i]) ? salesVolume[i]: max[2];
				max[3] = (max[3] <= stock[i]) ? stock[i]: max[3];
				max[4] = (max[4] <= sales[i]) ? sales[i]: max[4];
				max[5] = (max[5] <= profit[i]) ? profit[i]: max[5];
				
			}//최대값 계산 종료
			
			System.out.print("합계    "); //합계 출력
			for(int i = 0; i <sum.length;i++) {
				System.out.print(sum[i]+"  ");
			}
			System.out.println();
			
			System.out.print("평균    "); //평균 출력
			for(int i = 0; i <average.length;i++) {
				System.out.print(average[i]+"  ");
			}
			System.out.println();
			
			System.out.print("최대값   "); //최대값 출력
			for(int i = 0; i <max.length;i++) {
				System.out.print(max[i]+"  ");
			}
			System.out.println();
			System.out.println("===========================================");
			itemCounter++;
			
		} // while 종료

	}//main 

}
