//��������ѧ������

public class Admin {
	public void creat(String name,int age,Student[] arr){//����ѧ��
		Student stu=new Student();//�ȴ���һ��ѧ���ڵ��ú�����ֱ��arr[on].setOn���arr[on]�����ڻ���ɿ�ָ���쳣
		stu.setName(name);
		stu.setAge(age);
		stu.setSum();
		stu.setAvg();
		int i=this.setIndex(arr);
		stu.setOn(i);
		if(i==9999){
			System.out.println("ѧ�������Ѿ�����󣬲��������");
		}else{
			arr[i]=stu;
		}
	}
	public int setIndex(Student[] arr){//����������Ϊ�յ��±�
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null){
				return i;
			}
		}
		return 9999;
	}

	public void select(int on,Student[] arr){//��ѯ����
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null&&arr[i].getOn()==on){
				System.out.println("\t���\t����\t����\tjava\tC#\thtml\tsql\t�ܷ�\tƽ����");
				System.out.println(arr[i]);
				return;//��������
			}
		}
		System.out.println("û�����ѧ������");
	}

	public void printStu(Student[] arr){//��ӡѧ����Ϣ
		System.out.println("\t���\t����\t����\tjava\tC#\thtml\tsql\t�ܷ�\tƽ����");
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null){
				System.out.println(arr[i]);					
			}
		}		
	}

	public void update(int on,String name,int age,Student[] arr){//������Ϣ
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null&&arr[i].getOn()==on){
				arr[i].setName(name);
				arr[i].setAge(age);
				this.printStu(arr);
				return;//��������
			}
		}
		System.out.println("û�����ѧ����");
	}

	public void delect(int on,Student[] arr){//ɾ��ѧ����Ϣ
		if(on>=arr.length){
			System.out.println("������");
		}else if(arr[on]==null){
			System.out.println("û�����ѧ��");
		}else{
			System.out.println("ɾ����Ϣ�ɹ�");
			arr[on]=null;
		}
	}

	public void addPoint(int on,int java,int c_shar,int html,int sql,Student[] arr){//¼����ųɼ�
		if(on>=arr.length){
			System.out.println("������");
		}else if(arr[on]==null){
			System.out.println("û�����ѧ��");
		}else{
			arr[on].setJava(java);
			arr[on].setC_shar(c_shar);
			arr[on].setHtml(html);
			arr[on].setSql(sql);
			arr[on].setSum();
			arr[on].setAvg();
		}		
	}

	public void pointSort(int i,Student[] arr){//����ÿ�ųɼ���������
		Student arr1[]=new Student[arr.length];
		System.arraycopy(arr, 0, arr1, 0, arr.length);//�����������������(ԭ���飬��ԭ����ڼ�λ��ʼ��Ŀ�����飬�ӵڼ�λ��ʼճ�������Ƴ���)
				/*��ͬ��for(int l=0;l<arr.length;l++){
					arr1[l]=arr[l];
				}*/
		switch(i){
		case 1:
			for(int j=0;j<arr1.length-1;j++){
				Student stu=new Student();
				if(arr1[j]==null){
					continue;
				}
				for(int k=j+1;k<arr1.length;k++){
					if(arr1[k]==null){
						continue;
					}
					if(arr1[j].getJava()<arr1[k].getJava()){
						stu=arr1[j];
						arr1[j]=arr1[k];
						arr1[k]=stu;
					}
				}
			}
			this.printStu(arr1);
			break;
		case 2:
			for(int j=0;j<arr1.length-1;j++){
				Student stu=new Student();
				if(arr1[j]==null){
					continue;
				}
				for(int k=j+1;k<arr1.length;k++){
					if(arr1[k]==null){
						continue;
					}
					if(arr1[j].getC_shar()<arr1[k].getC_shar()){
						stu=arr1[j];
						arr1[j]=arr1[k];
						arr1[k]=stu;
					}
				}
			}
			this.printStu(arr1);
			break;
		case 3:
			for(int j=0;j<arr1.length-1;j++){
				Student stu=new Student();
				if(arr1[j]==null){
					continue;
				}
				for(int k=j+1;k<arr1.length;k++){
					if(arr1[k]==null){
						continue;
					}
					if(arr1[j].getHtml()<arr1[k].getHtml()){
						stu=arr1[j];
						arr1[j]=arr1[k];
						arr1[k]=stu;
					}
				}
			}
			this.printStu(arr1);
			break;
		case 4:
			for(int j=0;j<arr1.length-1;j++){
				Student stu=new Student();
				if(arr1[j]==null){
					continue;
				}
				for(int k=j+1;k<arr1.length;k++){
					if(arr1[k]==null){
						continue;
					}
					if(arr1[j].getSql()<arr1[k].getSql()){
						stu=arr1[j];
						arr1[j]=arr1[k];
						arr1[k]=stu;
					}
				}
			}
			this.printStu(arr1);
			break;
		default:
			System.out.println("��������ȷ��ţ�");
		}

	}

	public void sumSort(int i,Student[] arr){//���ֻܷ��߱�Ž�������
		Student arr1[]=new Student[arr.length];
		System.arraycopy(arr, 0, arr1, 0, arr.length);
		switch(i){
		case 1:
			for(int j=0;j<arr1.length-1;j++){
				Student stu=new Student();
				if(arr1[j]==null){
					continue;
				}
				for(int k=j+1;k<arr1.length;k++){
					if(arr1[k]==null){
						continue;
					}
					if(arr1[j].getSum()<arr1[k].getSum()){
						stu=arr1[j];
						arr1[j]=arr1[k];
						arr1[k]=stu;
					}
				}
			}
			this.printStu(arr1);
			break;
		case 2:
			for(int j=0;j<arr1.length-1;j++){
				Student stu=new Student();
				if(arr1[j]==null){
					continue;
				}
				for(int k=j+1;k<arr1.length;k++){
					if(arr1[k]==null){
						continue;
					}
					if(arr1[j].getOn()>arr1[k].getOn()){
						stu=arr1[j];
						arr1[j]=arr1[k];
						arr1[k]=stu;
					}
				}
			}
			this.printStu(arr1);
			break;
		}
	}


}