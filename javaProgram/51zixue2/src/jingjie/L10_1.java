package jingjie;

import java.sql.*;

public class L10_1 {
	public static void main(String[] args){
		Connection ct=null;
		
		PreparedStatement ps=null;//2 �趨һ��Ԥ����÷�������˰�ȫ�ԣ��������ʺ����������
		ResultSet rs=null;
	//1	Statement sm=null;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct=DriverManager.getConnection("jdbc:odbc:sql server","sa","kuangyun398");
		//2	ps=ct.prepareStatement("insert into bumen values(?,?,?)");
		//2	ps.setInt(1, 7);ps.setString(2, "����");ps.setString(3, "·��");
		//2	rs=ps.executeQuery(); //rs���ø�Ԥ�����䣬�����ͱ�ֻ֤���ڣ���������ݣ�û��or�����©��
			ps=ct.prepareStatement("select * from bumen where bianhao=? and didian=?");
			ps.setInt(1,7);ps.setString(2, "·��");  //��������ʺŴ���ڼ����ʺ�
			rs=ps.executeQuery();
		/*1	sm=ct.createStatement();
		//1	int i=sm.executeUpdate("insert into bumen values('9','����','����')");//������int i�����ݿ�����Ӱ������������Բ�Ҫint i��
		//1	int i=sm.executeUpdate("delete from bumen where mingcheng='����' ");
		//1	if(i>=1){
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
			}
			
		1	ResultSet rs=sm.executeQuery("select * from bumen where bianhao=2 and didian='ǰɽ' or 1='1'");
									//rsĬ��ָ���һ��ǰ��Ŀ���(or����Ϊ1��©����Ϊ�˽����©��ʹ���µķ�����Ԥ�跨)
		*/	while(rs.next()){
				int bianhao=rs.getInt(1);   //rs.getInt()�����ʱ���ڵ�ȡ���ݿ��еĵ�һ���ֶΣ�ע����������Ҫһ��
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
