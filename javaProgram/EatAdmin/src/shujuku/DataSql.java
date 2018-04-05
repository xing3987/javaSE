package shujuku;

import java.sql.*;

public class DataSql {
	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	
	String driver="sun.jdbc.odbc.JdbcOdbcDriver";
	String url="jdbc:odbc:sql server";
	String sqlname="sa";
	String sqlpassword="kuangyun398";
	
	
	public String getposition(String name,String password){
		String position=null;
		try{
			Class.forName(driver);
			ct=DriverManager.getConnection(url,sqlname,sqlpassword);
			ps=ct.prepareStatement("select renwu.position from denglu,renwu where denglu.number=? and denglu.password=? and renwu.number=denglu.number");
			ps.setString(1, name);ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				position=rs.getString(1);
				return position;
			}
		}catch(Exception e){
		}finally{
			try{
				ct.close();
				ps.close();
				rs.close();
			}catch(Exception e1){}
		}
		return position;
	}
}
