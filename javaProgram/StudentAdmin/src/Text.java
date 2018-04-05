//主程序

import java.util.*;

public class Text {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int on,age;String name;int java,c_shar,html,sql;String a="";
		System.out.println("请定义学生的人数：");
		Admin adminStu=new Admin();
		while(in.hasNextInt()!=true){//当输入的不是整型数时，赋值给a，并重新输入
			a=in.next();
			System.out.println("输入错误，请重新输入!!");
		}		
		Student stuArr[]=new Student[in.nextInt()];
		
		while(true){
			System.out.println("请选择你要执行的功能：");
			System.out.println("10：添加一个学生：");
			System.out.println("11：查找一个学生");
			System.out.println("12：根据学生编号更新学生的基本信息");
			System.out.println("13：根据学生编号删除学生");
			System.out.println("14：根据编号输入学生各门成绩");
			System.out.println("15：根据某门成绩进行排序");
			System.out.println("16：根据总分进行排序");
			System.out.println("17：根据编号重置");
			System.out.println("99：退出系统");

			while(in.hasNextInt()!=true){//当输入的不是整型数时，赋值给a，并重新输入
				a=in.next();
				System.out.println("输入错误，请重新输入!!");
			}

			switch(in.nextInt()){
			case 10:
				System.out.println("请输入学生姓名：");
				name=in.next();
				System.out.println("请输入学生年龄：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				age=in.nextInt();			
				adminStu.creat(name, age, stuArr);
				adminStu.printStu(stuArr);
				break;
			case 11:
				System.out.println("执行查找学生的基本信息：");
				System.out.println("根据输入的编号进行查找：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				on=in.nextInt();
				adminStu.select(on,stuArr);
				break;
			case 12:
				System.out.println("执行更新学生信息的操作：");
				System.out.println("请输入学生编号：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				on=in.nextInt();
				System.out.println("请输入学生姓名：");
				name=in.next();
				System.out.println("请输入学生年龄：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				age=in.nextInt();
				adminStu.update(on,name,age,stuArr);				
				break;
			case 13:
				System.out.println("执行删除学生信息的操作：");
				System.out.println("请输入要删除的学生编号：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				on=in.nextInt();
				adminStu.delect(on, stuArr);
				adminStu.printStu(stuArr);
				break;
			case 14:
				System.out.println("--成绩录入--");
				System.out.println("请输入要录入的学生编号：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				on=in.nextInt();
				System.out.println("请输入学生的java成绩：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				java=in.nextInt();
				System.out.println("请输入学生的c#成绩：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				c_shar=in.nextInt();
				System.out.println("请输入学生的html成绩：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				html=in.nextInt();
				System.out.println("请输入学生的sql成绩：");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("输入错误，请重新输入!!");
				}
				sql=in.nextInt();
				adminStu.addPoint(on,java, c_shar, html, sql,stuArr);
				adminStu.printStu(stuArr);
				break;
			case 15:
				System.out.println("根据成绩进行排序：");
				System.out.println("请输入需要排序的成绩：1表示java,2表示c#,3表示html,4表示sql：");
				adminStu.pointSort(in.nextInt(), stuArr);
				break;
			case 16:
				System.out.println("根据成绩总分进行排序：");
				adminStu.sumSort(1, stuArr);
				break;
			case 17:
				System.out.println("按编号重置：");
				adminStu.sumSort(2, stuArr);
				break;
			case 99:
				System.out.println("程序结束");
				in.close();
				System.exit(0);//退出内存的运行
				System.out.println(a);
			default:
				System.out.println("请输入正确编号：");
			}
		}

	}

}
