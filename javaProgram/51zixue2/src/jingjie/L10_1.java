package jingjie;

import java.sql.*;

public class L10_1 {
	public static void main(String[] args){
		Connection ct=null;
		
		PreparedStatement ps=null;//2 设定一个预备项，该方法提高了安全性，可用于帐号密码的输入
		ResultSet rs=null;
	//1	Statement sm=null;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct=DriverManager.getConnection("jdbc:odbc:sql server","sa","kuangyun398");
		//2	ps=ct.prepareStatement("insert into bumen values(?,?,?)");
		//2	ps.setInt(1, 7);ps.setString(2, "吓死");ps.setString(3, "路过");
		//2	rs=ps.executeQuery(); //rs调用该预设的语句，这样就保证只能在？中添加数据，没有or后面的漏洞
			ps=ct.prepareStatement("select * from bumen where bianhao=? and didian=?");
			ps.setInt(1,7);ps.setString(2, "路过");  //括号里的问号代表第几个问号
			rs=ps.executeQuery();
		/*1	sm=ct.createStatement();
		//1	int i=sm.executeUpdate("insert into bumen values('9','土军','地面')");//添加命令，int i是数据库中受影响的行数（可以不要int i）
		//1	int i=sm.executeUpdate("delete from bumen where mingcheng='土军' ");
		//1	if(i>=1){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
			
		1	ResultSet rs=sm.executeQuery("select * from bumen where bianhao=2 and didian='前山' or 1='1'");
									//rs默认指向第一行前面的空行(or后面为1的漏洞，为了解决该漏洞使用新的方法，预设法)
		*/	while(rs.next()){
				int bianhao=rs.getInt(1);   //rs.getInt()该语句时用于调取数据库中的第一个字段，注意数据类型要一致
				String mingcheng=rs.getString(2);
				String didian=rs.getString(3);
				System.out.println(bianhao+"\t"+mingcheng+"\t"+didian+"\t");
			}
		
			
		}catch(Exception e){}
		finally{
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {}
				}
		/*1	if(sm!=null){
				try {
					sm.close();
				} catch (SQLException e) {}		
			}			*/
		}
		

	}
}
