//建立不可以滚动的表格
package jingjie;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.util.Vector;
public class L10_4 extends JFrame {	
	public static void main(String[] args){
		L10_4 aa=new L10_4();
	}
	public L10_4(){
		this.setTitle("创建不可以滚动的表格");
		this.setBounds(100,100,240,150);//设定加载位置和宽高
		this.setDefaultCloseOperation(3);
		Vector<String> columnNames=new Vector<>();
		columnNames.add("A");
		columnNames.add("B");
		Vector tableValues=new Vector();//tableValues是二维数组
		for(int row=1;row<6;row++){
			Vector rowV=new Vector();
			rowV.add("A"+row);rowV.add("B"+row);
			tableValues.add(rowV);
		}
		DefaultTableModel tableModel=new DefaultTableModel(tableValues,columnNames){
			public boolean isCellEditable(int row,int column){//表格内容是否可以编辑
				if(row>0){//0是第一行，这个是从第二行开始
				return false;
				}else{
					return true;
				}
			}
		}
		;
		JTable table=new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));  //定义表格自带的升降序排列
		
	//	JTable table=new JTable(tableValues,columnNames);
	//	table.setAutoCreateRowSorter(true); //设置表格自带升降序排列
		table.setSelectionBackground(Color.yellow);//设置选中时的背景颜色
		table.setSelectionForeground(Color.red);//设置选中时的内容颜色
	//	JScrollPane sp=new JScrollPane(table);
	//	this.add(sp);
		JTableHeader tableHeader=table.getTableHeader();//得到列名（表头）
		this.add(tableHeader,BorderLayout.NORTH);//把表头添加到上部，如果不加表头就只能看到表的内容
		this.add(table);//把表添加到中间
		this.setVisible(true);
		
	}
}