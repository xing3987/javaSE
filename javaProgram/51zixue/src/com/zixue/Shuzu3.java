//�����ð������

package com.zixue;
public class Shuzu3 {
	public static void main(String[] args) {
		int array[]={11,5,88,4,77,6,94};
		for(int j=1;j<array.length-1;j++){//�������鳤�ȼ�1�ε������ֵ����������ĩβ
			for (int i=0;i<array.length-1;i++){//�ҳ����������ֵ������ĩβ
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
