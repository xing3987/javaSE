package jingjie;

import java.sql.*;

public class L10_2 {
	public static void main(String[] args){
		Connection ct=null;
		PreparedStatement ps=null;

		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct=DriverManager.getConnection("jdbc:odbc:sql server","sa","kuangyun398");

		//	ps=ct.prepareStatement("create database abcd");
			ps=ct.prepareStatement("drop database abcd");
			ps.execute();//不要输出结果数据时用这个语句，要数据时用resultSet rs=ps.executeQuery
			System.out.println("执行结束");


		}catch(Exception e){}
		finally{
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {}
			}


		}
	}
}