//���±�������

package jingjie;
import java.awt.*;
import java.io.*;

import javax.swing.*;

import java.awt.event.*;
public class L8_6 extends JFrame implements ActionListener{
	JMenuBar mb1;
	JMenu mn1,mn2;
	JMenuItem mi1,mi2;
	JTextArea t1;JScrollPane sp1;
	public static void main(String[] args){
		L8_6 aa=new L8_6();
	}
	public L8_6(){
		mb1=new JMenuBar();
		mn1=new JMenu("�ļ�(F)");mn1.setMnemonic('f');
		mn2=new JMenu("�༭(E)");mn2.setMnemonic('e');
		mi1=new JMenuItem("��");mi1.addActionListener(this);mi1.setActionCommand("open");
		mi2=new JMenuItem("����");mi2.addActionListener(this);mi2.setActionCommand("save");
		t1=new JTextArea();sp1=new JScrollPane(t1);
		
		mn1.add(mi1);mn1.add(mi2);
		mb1.add(mn1);mb1.add(mn2);
		this.setJMenuBar(mb1);this.add(sp1);
		
		this.setSize(300,300);
		this.setLocation(150,150);
		this.setDefaultCloseOperation(3);
		this.setTitle("�߼����±�");
		this.setIconImage((new ImageIcon("image/jsb.jpg").getImage()));
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {//ʵ�ּ���
		if(e.getActionCommand().equals("open")){
			//System.out.println("��");
			JFileChooser fc1=new JFileChooser();
			fc1.setToolTipText("���ļ�");//����ļ�ѡ���ı���
			fc1.showOpenDialog(null);//������ʾ�򿪶Ի���
			fc1.setVisible(true);//���ÿɼ�
			//System.out.println(lj);
			FileReader fr=null;BufferedReader br=null;
			try {
				String lj=fc1.getSelectedFile().getAbsolutePath();//�õ�ѡ���ļ���ȫ·��
				fr=new FileReader(lj);br=new BufferedReader(fr);
				String a="";
				while(br.readLine()!=null){
					a+=br.readLine()+"\n";
				}
				t1.setText(a);
			} catch (Exception x) {

			}finally{
				try {
					fr.close();
					br.close();
				} catch (IOException e1) {
				}
			}
		}else if(e.getActionCommand().equals("save")){
			//System.out.println("����");
			JFileChooser fc2=new JFileChooser();
			fc2.setToolTipText("����");
			fc2.showSaveDialog(null);
			fc2.setVisible(true);
			PrintStream ps=null;
			try{
				String lj2=fc2.getSelectedFile().getAbsolutePath();
				ps=new PrintStream(new FileOutputStream(lj2));
				System.setOut(ps);
				
				System.out.println(this.t1.getText());
			}catch(Exception e1){
				
			}finally{
				ps.close();
			}
		}
		
	}
}
