//�����ѡ������

package com.zixue;
public class Shuzu4 {
	public static void main(String[] args) {
		int array[]={11,5,88,4,77,6,94};
/*		for(int j=1;j<array.length-1;j++){//�������鳤�ȼ�1�ε������ֵ����������ĩβ
			int l=1;
			for (int i=0;i<array.length-l;i++){//�ҳ����������ֵ������ĩβ
				if(array[i]>array[i+1]){
					int t=array[i+1];
					array[i+1]=array[i];
					array[i]=t;
				}
			}
			l++;//ĩβ�ҳ����������,Ҫ�Աȵ����鳤�ȼ�1
		}
*/		
		 for(int i=0;i<array.length-1;i++){//ÿ�����͵�һ�����ȣ�����ȵ�һ����С�ͻ�����ȷ����һ������С��Ȼ��ȵڶ�����...
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
