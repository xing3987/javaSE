//数组的选择排序

package com.zixue;
public class Shuzu4 {
	public static void main(String[] args) {
		int array[]={11,5,88,4,77,6,94};
/*		for(int j=1;j<array.length-1;j++){//运行数组长度减1次的找最大值并放在数组末尾
			int l=1;
			for (int i=0;i<array.length-l;i++){//找出数组中最大值并排在末尾
				if(array[i]>array[i+1]){
					int t=array[i+1];
					array[i+1]=array[i];
					array[i]=t;
				}
			}
			l++;//末尾找出来的最大数,要对比的数组长度减1
		}
*/		
		 for(int i=0;i<array.length-1;i++){//每个数和第一个数比，如果比第一个数小就互换，确保第一个数最小，然后比第二个数...
			 for(int j=i+1;j<array.length;j++){
					if(array[i]>array[j]){
						int t=array[i];
						array[i]=array[j];
						array[j]=t;
					}				 
			 }
		 }
		 
		 
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();
	

	}
}
