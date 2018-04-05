package jingjie;

import java.sql.*;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class L10_search extends AbstractTableModel{
	Vector ziduan,jilu;
	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	
	public L10_search(){
		this.table("select * from xuesheng");
	}
	public L10_search(String sql){
		this.table(sql);
	}
	public void table(String sql){
		ziduan=new Vector();
		ziduan.add("学号");ziduan.add("姓名");ziduan.add("性别");ziduan.add("年龄");ziduan.add("籍贯");ziduan.add("所在院系");
		jilu=new Vector();
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct=DriverManager.getConnection("jdbc:odbc:sql server","sa","kuangyun398");
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();//rs结果数据为ps中运行后得到的数据
			while(rs.next()){//当下一行有数据rs.next()为下一行数据
				Vector hang=new Vector();
				hang.add(rs.getString(1));//得到第一个字段数据赋值给hang
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				jilu.add(hang);
			}
		}catch(Exception e){}
		finally{
			try{
				if(ct!=null){
					ct.close();
					ps.close();
					rs.close();
					}
			}catch(Exception e1){}
		}
	}

	
	public int getColumnCount() { //得到列数
		return ziduan.size();
	}


	public int getRowCount() {//得到行数
		return jilu.size();
	}

	public Object getValueAt(int row, int column) {//得到具体的数值（从第几行第几列）
		return ((Vector) jilu.get(row)).get(column);
	}
	public String getColumnName(int column){//返回字段的名称（没有这个函数不返回字段名默认为ABCD~）
		return (String) ziduan.get(column);
	}
}
