package jingjie;
import java.io.*;
import java.util.ArrayList;

public class L4_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader sr=new BufferedReader(new InputStreamReader(System.in));
		Spgl admin=new Spgl();
		String bianhao;String name;float jiage;
		while(true){
			System.out.println("请按提示选择以下功能");
			System.out.println("添加食品请按1");
			System.out.println("查找食品信息请按2");
			System.out.println("修改食品价格请按3");
			System.out.println("删除食品请按4");
			System.out.println("查看所以食品请按5");
			System.out.println("退出请按0");
			
			String str=sr.readLine();
			switch(str){
			case "0":
				System.out.println("系统退出");
				System.exit(0);
			case "1":
				System.out.println("请输入食品编号");
				bianhao=sr.readLine();
				System.out.println("请输入食品名称");
				name=sr.readLine();
				System.out.println("请输入食品价格");
				try{
				jiage=Float.parseFloat(sr.readLine());
				admin.addSp(bianhao,name,jiage);
				}catch(Exception e){
					System.out.println("输入有误");
				}
				
				break;
			case "2":
				System.out.println("请输入食品编号");
				bianhao=sr.readLine();
				admin.cxSp(bianhao);
				break;
			case "3":
				System.out.println("请输入要修改价格的食品编号");
				bianhao=sr.readLine();
				System.out.println("请输入价格");
				try{
				jiage=Float.parseFloat(sr.readLine());
				admin.xgjg(bianhao, jiage);
				}catch(Exception e){
					System.out.println("输入有误");
				}
				break;
			case "4":
				System.out.println("请输入要修改价格的食品编号");
				bianhao=sr.readLine();
				admin.delSp(bianhao);
				break;
			case "5":
				admin.ckSp();
				break;
			default:
				System.out.println("输入错误，请重新输入");
			}

		}
	}
}

class Sp{//定义食品信息
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

class Spgl{//食品管理系统
	private ArrayList<Sp> aa=null;
	Spgl(){//当调用管理系统时建立食品数组
		aa=new ArrayList<Sp>(); 
	}
	
	public void addSp(String bianhao,String name,float jiage){//添加食品信息
		Sp x=new Sp();
		x.setBianhao(bianhao);
		x.setName(name);
		x.setJiage(jiage);
		aa.add(x);
		System.out.println("添加食品成功");
	}
	public void cxSp(String bianhao){//输入编号查询食品
		int i;
		for(i=0;i<aa.size();i++){
			Sp b=(Sp)aa.get(i);
			if(b.getBianhao().equals(bianhao)){
				System.out.println("食品编号为\t"+bianhao);
				System.out.println("食品名称为\t"+b.getName());
				System.out.println("食品价格为\t"+b.getJiage());
				break;
			}
		}
		if(i==aa.size()){
			System.out.println("没有该编号的食品");
		}
	}
	public void xgjg(String bianhao,Float jiage){//修改食品价格
		int i;
		for(i=0;i<aa.size();i++){
			Sp b=(Sp)aa.get(i);
			if(b.getBianhao().equals(bianhao)){
				b.setJiage(jiage);
				System.out.println("修改价格成功");
				System.out.println("食品编号为\t"+b.getBianhao());
				System.out.println("食品名称为\t"+b.getName());
				System.out.println("食品价格为\t"+b.getJiage());
				break;
			}
		}
		if(i==aa.size()){
			System.out.println("没有该编号的食品");
		}
	}
	public void delSp(String bianhao){//根据编号删除食品
		
		if(aa.size()==0){
			System.out.println("没有商品啦");
			return;
		}
		int i;
		for(i=0;i<aa.size();i++){
			Sp b=(Sp)aa.get(i);
			if(b.getBianhao().equals(bianhao)){
				aa.remove(i);
				System.out.println("删除商品成功");
				break;
			}
		}
		if(i==aa.size()){
			System.out.println("没有该编号的食品");
		}
	}
	public void ckSp(){//查询价格
		System.out.println("食品编号\t食品名称\t食品价格");
		for(int i=0;i<aa.size();i++){
			Sp b=(Sp)aa.get(i);
			System.out.println(b.getBianhao()+"\t"+b.getName()+"\t"+b.getJiage());
		}
	}
	
}