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
		ziduan.add("ѧ��");ziduan.add("����");ziduan.add("�Ա�");ziduan.add("����");ziduan.add("����");ziduan.add("����Ժϵ");
		jilu=new Vector();
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct=DriverManager.getConnection("jdbc:odbc:sql server","sa","kuangyun398");
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();//rs�������Ϊps�����к�õ�������
			while(rs.next()){//����һ��������rs.next()Ϊ��һ������
				Vector hang=new Vector();
				hang.add(rs.getString(1));//�õ���һ���ֶ����ݸ�ֵ��hang
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

	
	public int getColumnCount() { //�õ�����
		return ziduan.size();
	}


	public int getRowCount() {//�õ�����
		return jilu.size();
	}

	public Object getValueAt(int row, int column) {//�õ��������ֵ���ӵڼ��еڼ��У�
		return ((Vector) jilu.get(row)).get(column);
	}
	public String getColumnName(int column){//�����ֶε����ƣ�û����������������ֶ���Ĭ��ΪABCD~��
		return (String) ziduan.get(column);
	}
}
