//用来管理学生的类

public class Admin {
	public void creat(String name,int age,Student[] arr){//创建学生
		Student stu=new Student();//先创建一个学生在调用函数，直接arr[on].setOn如果arr[on]不存在会造成空指针异常
		stu.setName(name);
		stu.setAge(age);
		stu.setSum();
		stu.setAvg();
		int i=this.setIndex(arr);
		stu.setOn(i);
		if(i==9999){
			System.out.println("学生人数已经到最大，不能添加了");
		}else{
			arr[i]=stu;
		}
	}
	public int setIndex(Student[] arr){//返回数组里为空的下标
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null){
				return i;
			}
		}
		return 9999;
	}

	public void select(int on,Student[] arr){//查询方法
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null&&arr[i].getOn()==on){
				System.out.println("\t编号\t姓名\t年龄\tjava\tC#\thtml\tsql\t总分\t平均分");
				System.out.println(arr[i]);
				return;//结束方法
			}
		}
		System.out.println("没有这个学生！！");
	}

	public void printStu(Student[] arr){//打印学生信息
		System.out.println("\t编号\t姓名\t年龄\tjava\tC#\thtml\tsql\t总分\t平均分");
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null){
				System.out.println(arr[i]);					
			}
		}		
	}

	public void update(int on,String name,int age,Student[] arr){//更新信息
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null&&arr[i].getOn()==on){
				arr[i].setName(name);
				arr[i].setAge(age);
				this.printStu(arr);
				return;//结束方法
			}
		}
		System.out.println("没有这个学生！");
	}

	public void delect(int on,Student[] arr){//删除学生信息
		if(on>=arr.length){
			System.out.println("编号溢出");
		}else if(arr[on]==null){
			System.out.println("没有这个学生");
		}else{
			System.out.println("删除信息成功");
			arr[on]=null;
		}
	}

	public void addPoint(int on,int java,int c_shar,int html,int sql,Student[] arr){//录入各门成绩
		if(on>=arr.length){
			System.out.println("编号溢出");
		}else if(arr[on]==null){
			System.out.println("没有这个学生");
		}else{
			arr[on].setJava(java);
			arr[on].setC_shar(c_shar);
			arr[on].setHtml(html);
			arr[on].setSql(sql);
			arr[on].setSum();
			arr[on].setAvg();
		}		
	}

	public void pointSort(int i,Student[] arr){//根据每门成绩进行排序
		Student arr1[]=new Student[arr.length];
		System.arraycopy(arr, 0, arr1, 0, arr.length);//复制数组变量依次是(原数组，从原数组第几位开始，目标数组，从第几位开始粘贴，复制长度)
				/*等同于for(int l=0;l<arr.length;l++){
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
			System.out.println("请输入正确编号：");
		}

	}

	public void sumSort(int i,Student[] arr){//按总分或者编号进行排序
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