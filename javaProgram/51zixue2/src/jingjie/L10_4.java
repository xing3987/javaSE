//���������Թ����ı��
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
		this.setTitle("���������Թ����ı��");
		this.setBounds(100,100,240,150);//�趨����λ�úͿ��
		this.setDefaultCloseOperation(3);
		Vector<String> columnNames=new Vector<>();
		columnNames.add("A");
		columnNames.add("B");
		Vector tableValues=new Vector();//tableValues�Ƕ�ά����
		for(int row=1;row<6;row++){
			Vector rowV=new Vector();
			rowV.add("A"+row);rowV.add("B"+row);
			tableValues.add(rowV);
		}
		DefaultTableModel tableModel=new DefaultTableModel(tableValues,columnNames){
			public boolean isCellEditable(int row,int column){//��������Ƿ���Ա༭
				if(row>0){//0�ǵ�һ�У�����Ǵӵڶ��п�ʼ
				return false;
				}else{
					return true;
				}
			}
		}
		;
		JTable table=new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));  //�������Դ�������������
		
	//	JTable table=new JTable(tableValues,columnNames);
	//	table.setAutoCreateRowSorter(true); //���ñ���Դ�����������
		table.setSelectionBackground(Color.yellow);//����ѡ��ʱ�ı�����ɫ
		table.setSelectionForeground(Color.red);//����ѡ��ʱ��������ɫ
	//	JScrollPane sp=new JScrollPane(table);
	//	this.add(sp);
		JTableHeader tableHeader=table.getTableHeader();//�õ���������ͷ��
		this.add(tableHeader,BorderLayout.NORTH);//�ѱ�ͷ��ӵ��ϲ���������ӱ�ͷ��ֻ�ܿ����������
		this.add(table);//�ѱ���ӵ��м�
		this.setVisible(true);
		
	}
}