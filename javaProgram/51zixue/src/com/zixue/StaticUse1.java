

package com.zixue;

public class StaticUse1 {
	public static void main(String[] args){
		int[] arr={12,13,585,475,697};
		System.out.println(max(arr));
		System.out.println(ArrayOperate.minArray(arr));//��ͬ��ArrayOperate a=new ArrayOperate();a.minArray(arr){��Ҫ����ʹ��ʱ�����ø���ķ���ҪΪ��̬����}
		ArrayOperate.maoSort(arr);
		ArrayOperate.printArray(arr);
		
		int[] arr1={122,133,545,415,197};
		System.out.println(ArrayOperate.maxArray(arr1));
		System.out.println(ArrayOperate.minArray(arr1));
		ArrayOperate.xuanzeSort(arr1);
		ArrayOperate.printArray(arr1);
		
	}
	
	
	static int max(int[] arr){
		int max=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
}
