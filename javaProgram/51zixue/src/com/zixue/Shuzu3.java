//数组的冒泡排序

package com.zixue;
public class Shuzu3 {
	public static void main(String[] args) {
		int array[]={11,5,88,4,77,6,94};
		for(int j=1;j<array.length-1;j++){//运行数组长度减1次的找最大值并放在数组末尾
			for (int i=0;i<array.length-1;i++){//找出数组中最大值并排在末尾
				if(array[i]>array[i+1]){
					int t=array[i+1];
					array[i+1]=array[i];
					array[i]=t;
				}
			}
		}
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();
	

	}
}
