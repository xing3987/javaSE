package jingjie;
import java.io.*;
import java.util.ArrayList;

public class L4_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader sr=new BufferedReader(new InputStreamReader(System.in));
		Spgl admin=new Spgl();
		String bianhao;String name;float jiage;
		while(true){
			System.out.println("�밴��ʾѡ�����¹���");
			System.out.println("���ʳƷ�밴1");
			System.out.println("����ʳƷ��Ϣ�밴2");
			System.out.println("�޸�ʳƷ�۸��밴3");
			System.out.println("ɾ��ʳƷ�밴4");
			System.out.println("�鿴����ʳƷ�밴5");
			System.out.println("�˳��밴0");
			
			String str=sr.readLine();
			switch(str){
			case "0":
				System.out.println("ϵͳ�˳�");
				System.exit(0);
			case "1":
				System.out.println("������ʳƷ���");
				bianhao=sr.readLine();
				System.out.println("������ʳƷ����");
				name=sr.readLine();
				System.out.println("������ʳƷ�۸�");
				try{
				jiage=Float.parseFloat(sr.readLine());
				admin.addSp(bianhao,name,jiage);
				}catch(Exception e){
					System.out.println("��������");
				}
				
				break;
			case "2":
				System.out.println("������ʳƷ���");
				bianhao=sr.readLine();
				admin.cxSp(bianhao);
				break;
			case "3":
				System.out.println("������Ҫ�޸ļ۸��ʳƷ���");
				bianhao=sr.readLine();
				System.out.println("������۸�");
				try{
				jiage=Float.parseFloat(sr.readLine());
				admin.xgjg(bianhao, jiage);
				}catch(Exception e){
					System.out.println("��������");
				}
				break;
			case "4":
				System.out.println("������Ҫ�޸ļ۸��ʳƷ���");
				bianhao=sr.readLine();
				admin.delSp(bianhao);
				break;
			case "5":
				admin.ckSp();
				break;
			default:
				System.out.println("�����������������");
			}

		}
	}
}

class Sp{//����ʳƷ��Ϣ
	private String bianhao;
	private String name;
	private float jiage;
	Sp(String bianhao,String name,float jiage){
		this.bianhao=bianhao;
		this.name=name;
		this.jiage=jiage;
	}
	Sp(){
		
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getJiage() {
		return jiage;
	}
	public void setJiage(float jiage) {
		this.jiage = jiage;
	}	
}

class Spgl{//ʳƷ����ϵͳ
	private ArrayList<Sp> aa=null;
	Spgl(){//�����ù���ϵͳʱ����ʳƷ����
		aa=new ArrayList<Sp>(); 
	}
	
	public void addSp(String bianhao,String name,float jiage){//���ʳƷ��Ϣ
		Sp x=new Sp();
		x.setBianhao(bianhao);
		x.setName(name);
		x.setJiage(jiage);
		aa.add(x);
		System.out.println("���ʳƷ�ɹ�");
	}
	public void cxSp(String bianhao){//�����Ų�ѯʳƷ
		int i;
		for(i=0;i<aa.size();i++){
			Sp b=(Sp)aa.get(i);
			if(b.getBianhao().equals(bianhao)){
				System.out.println("ʳƷ���Ϊ\t"+bianhao);
				System.out.println("ʳƷ����Ϊ\t"+b.getName());
				System.out.println("ʳƷ�۸�Ϊ\t"+b.getJiage());
				break;
			}
		}
		if(i==aa.size()){
			System.out.println("û�иñ�ŵ�ʳƷ");
		}
	}
	public void xgjg(String bianhao,Float jiage){//�޸�ʳƷ�۸�
		int i;
		for(i=0;i<aa.size();i++){
			Sp b=(Sp)aa.get(i);
			if(b.getBianhao().equals(bianhao)){
				b.setJiage(jiage);
				System.out.println("�޸ļ۸�ɹ�");
				System.out.println("ʳƷ���Ϊ\t"+b.getBianhao());
				System.out.println("ʳƷ����Ϊ\t"+b.getName());
				System.out.println("ʳƷ�۸�Ϊ\t"+b.getJiage());
				break;
			}
		}
		if(i==aa.size()){
			System.out.println("û�иñ�ŵ�ʳƷ");
		}
	}
	public void delSp(String bianhao){//���ݱ��ɾ��ʳƷ
		
		if(aa.size()==0){
			System.out.println("û����Ʒ��");
			return;
		}
		int i;
		for(i=0;i<aa.size();i++){
			Sp b=(Sp)aa.get(i);
			if(b.getBianhao().equals(bianhao)){
				aa.remove(i);
				System.out.println("ɾ����Ʒ�ɹ�");
				break;
			}
		}
		if(i==aa.size()){
			System.out.println("û�иñ�ŵ�ʳƷ");
		}
	}
	public void ckSp(){//��ѯ�۸�
		System.out.println("ʳƷ���\tʳƷ����\tʳƷ�۸�");
		for(int i=0;i<aa.size();i++){
			Sp b=(Sp)aa.get(i);
			System.out.println(b.getBianhao()+"\t"+b.getName()+"\t"+b.getJiage());
		}
	}
	
}