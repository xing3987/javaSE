//������

import java.util.*;

public class Text {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int on,age;String name;int java,c_shar,html,sql;String a="";
		System.out.println("�붨��ѧ����������");
		Admin adminStu=new Admin();
		while(in.hasNextInt()!=true){//������Ĳ���������ʱ����ֵ��a������������
			a=in.next();
			System.out.println("�����������������!!");
		}		
		Student stuArr[]=new Student[in.nextInt()];
		
		while(true){
			System.out.println("��ѡ����Ҫִ�еĹ��ܣ�");
			System.out.println("10�����һ��ѧ����");
			System.out.println("11������һ��ѧ��");
			System.out.println("12������ѧ����Ÿ���ѧ���Ļ�����Ϣ");
			System.out.println("13������ѧ�����ɾ��ѧ��");
			System.out.println("14�����ݱ������ѧ�����ųɼ�");
			System.out.println("15������ĳ�ųɼ���������");
			System.out.println("16�������ֽܷ�������");
			System.out.println("17�����ݱ������");
			System.out.println("99���˳�ϵͳ");

			while(in.hasNextInt()!=true){//������Ĳ���������ʱ����ֵ��a������������
				a=in.next();
				System.out.println("�����������������!!");
			}

			switch(in.nextInt()){
			case 10:
				System.out.println("������ѧ��������");
				name=in.next();
				System.out.println("������ѧ�����䣺");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				age=in.nextInt();			
				adminStu.creat(name, age, stuArr);
				adminStu.printStu(stuArr);
				break;
			case 11:
				System.out.println("ִ�в���ѧ���Ļ�����Ϣ��");
				System.out.println("��������ı�Ž��в��ң�");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				on=in.nextInt();
				adminStu.select(on,stuArr);
				break;
			case 12:
				System.out.println("ִ�и���ѧ����Ϣ�Ĳ�����");
				System.out.println("������ѧ����ţ�");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				on=in.nextInt();
				System.out.println("������ѧ��������");
				name=in.next();
				System.out.println("������ѧ�����䣺");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				age=in.nextInt();
				adminStu.update(on,name,age,stuArr);				
				break;
			case 13:
				System.out.println("ִ��ɾ��ѧ����Ϣ�Ĳ�����");
				System.out.println("������Ҫɾ����ѧ����ţ�");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				on=in.nextInt();
				adminStu.delect(on, stuArr);
				adminStu.printStu(stuArr);
				break;
			case 14:
				System.out.println("--�ɼ�¼��--");
				System.out.println("������Ҫ¼���ѧ����ţ�");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				on=in.nextInt();
				System.out.println("������ѧ����java�ɼ���");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				java=in.nextInt();
				System.out.println("������ѧ����c#�ɼ���");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				c_shar=in.nextInt();
				System.out.println("������ѧ����html�ɼ���");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				html=in.nextInt();
				System.out.println("������ѧ����sql�ɼ���");
				while(in.hasNextInt()!=true){
					a=in.next();
					System.out.println("�����������������!!");
				}
				sql=in.nextInt();
				adminStu.addPoint(on,java, c_shar, html, sql,stuArr);
				adminStu.printStu(stuArr);
				break;
			case 15:
				System.out.println("���ݳɼ���������");
				System.out.println("��������Ҫ����ĳɼ���1��ʾjava,2��ʾc#,3��ʾhtml,4��ʾsql��");
				adminStu.pointSort(in.nextInt(), stuArr);
				break;
			case 16:
				System.out.println("���ݳɼ��ֽܷ�������");
				adminStu.sumSort(1, stuArr);
				break;
			case 17:
				System.out.println("��������ã�");
				adminStu.sumSort(2, stuArr);
				break;
			case 99:
				System.out.println("�������");
				in.close();
				System.exit(0);//�˳��ڴ������
				System.out.println(a);
			default:
				System.out.println("��������ȷ��ţ�");
			}
		}

	}

}
