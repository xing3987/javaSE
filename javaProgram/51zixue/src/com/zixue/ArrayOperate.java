//��̬Ӧ�ù�����Ĵ�����ʹ��

package com.zixue;

public class ArrayOperate {
	private ArrayOperate(){//˽�л���װ���࣬ʹ֮������NEW����

	}

	 static int maxArray(int[] arr){//�����ֵ
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}

	static int minArray(int[] arr){//����Сֵ
		int min=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]<min){
				min=arr[i];
			}
		}
		return min;
	}

	static void maoSort(int[] arr){//ð������
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1;j++){
				replace(arr,j,j+1);
			}
		}
	}

	static void xuanzeSort(int[] arr){//ѡ������
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length-1;j++){
				replace(arr,i,j);
			}
		}
	}

	static void printArray(int[] arr){//��ӡ����
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
		System.out.println("");
	}

	public static void replace(int[] arr,int a,int b){//��������С��������
		if(arr[a]>arr[b]){
			int t=arr[a];
			arr[a]=arr[b];
			arr[b]=t;
		}
	}

}
