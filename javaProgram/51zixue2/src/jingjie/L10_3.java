//建立可以滚动的表格

package jingjie;
import javax.swing.*;
import java.awt.*;
public class L10_3 extends JFrame {	
	public static void main(String[] args){
		L10_3 aa=new L10_3();
	}
	public L10_3(){
		this.setTitle("创建可以滚动的表格");
		this.setBounds(100,100,240,150);//设定加载位置和宽高
		this.setDefaultCloseOperation(3);
		String[] columnNames={"A","B"};
		String[][] tableValues={{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}};
		JTable table=new JTable(tableValues,columnNames);
		JScrollPane scrollPane=new JScrollPane(table);
		this.add(scrollPane);
		this.setVisible(true);
	}
}
