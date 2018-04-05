//记事本的制作

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
		mn1=new JMenu("文件(F)");mn1.setMnemonic('f');
		mn2=new JMenu("编辑(E)");mn2.setMnemonic('e');
		mi1=new JMenuItem("打开");mi1.addActionListener(this);mi1.setActionCommand("open");
		mi2=new JMenuItem("保存");mi2.addActionListener(this);mi2.setActionCommand("save");
		t1=new JTextArea();sp1=new JScrollPane(t1);
		
		mn1.add(mi1);mn1.add(mi2);
		mb1.add(mn1);mb1.add(mn2);
		this.setJMenuBar(mb1);this.add(sp1);
		
		this.setSize(300,300);
		this.setLocation(150,150);
		this.setDefaultCloseOperation(3);
		this.setTitle("高级记事本");
		this.setIconImage((new ImageIcon("image/jsb.jpg").getImage()));
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {//实现监听
		if(e.getActionCommand().equals("open")){
			//System.out.println("打开");
			JFileChooser fc1=new JFileChooser();
			fc1.setToolTipText("打开文件");//设计文件选择框的标题
			fc1.showOpenDialog(null);//设置显示打开对话框
			fc1.setVisible(true);//设置可见
			//System.out.println(lj);
			FileReader fr=null;BufferedReader br=null;
			try {
				String lj=fc1.getSelectedFile().getAbsolutePath();//得到选择文件的全路径
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
			//System.out.println("保存");
			JFileChooser fc2=new JFileChooser();
			fc2.setToolTipText("保存");
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
