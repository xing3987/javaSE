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
			ps.execute();//��Ҫ����������ʱ�������䣬Ҫ����ʱ��resultSet rs=ps.executeQuery
			System.out.println("ִ�н���");


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