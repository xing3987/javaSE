package jiemian;
import java.awt.*;
import javax.swing.*;
import gonggong.*;
import gongju.Gliaotian;
import java.awt.event.*;

public class Liebiao extends JFrame implements ActionListener,MouseListener{
	JPanel pn1,pn11,pn2,pn21,pn22;
	JButton bt1,bt11,bt2,bt21;
	JLabel[] lb1,lb2;
	JScrollPane sp1,sp2;
	CardLayout c1;
	String name;
	public static void main(String[] args){
		String a=null;
		Liebiao aa=new Liebiao(a);
	}
	public Liebiao(String name){
		this.name=name;
		bt1=new JButton("我的好友");bt1.addActionListener(this);
		bt11=new JButton("陌生人");bt11.addActionListener(this);
		lb1=new JLabel[50];
		pn11=new JPanel(new GridLayout(lb1.length,1,3,3));
		for(int i=0;i<lb1.length;i++){
			lb1[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			lb1[i].addMouseListener(this);lb1[i].setEnabled(false);
			if(lb1[i].getText().equals(name)){
				lb1[i].setEnabled(true);
			}
			pn11.add(lb1[i]);
		}
		sp1=new JScrollPane(pn11);
		pn1=new JPanel(new BorderLayout());
		pn1.add(bt1,BorderLayout.NORTH);
		pn1.add(sp1,BorderLayout.CENTER);
		pn1.add(bt11,BorderLayout.SOUTH);
		
		lb2=new JLabel[20];
		pn21=new JPanel(new GridLayout(lb2.length,1,3,3));
		for(int i=0;i<lb2.length;i++){
			lb2[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			lb2[i].addMouseListener(this);
			pn21.add(lb2[i]);
		}
		sp2=new JScrollPane(pn21);
		pn22=new JPanel(new GridLayout(2,1));
		bt2=new JButton("我的好友");bt2.addActionListener(this);
		bt21=new JButton("陌生人");bt21.addActionListener(this);
		pn22.add(bt2);pn22.add(bt21);
		pn2=new JPanel(new BorderLayout());
		pn2.add(pn22,BorderLayout.NORTH);
		pn2.add(sp2,BorderLayout.CENTER);
		
		c1=new CardLayout();
		this.setLayout(c1);
		this.add(pn1,"1");this.add(pn2,"2");
		
		this.setBounds(200,100,150,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		this.setTitle(name);
	}
	public void updateFriend(Message ms){
		String onLineFriend[]=ms.getCon().split(" ");
		
		for(int i=0;i<onLineFriend.length;i++)
		{			
			lb1[Integer.parseInt(onLineFriend[i])-1].setEnabled(true);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1||e.getSource()==bt2){
			this.c1.show(this.getContentPane(),"1");
		}else if(e.getSource()==bt11||e.getSource()==bt21){
			this.c1.show(this.getContentPane(), "2");
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			String friendNo=((JLabel)e.getSource()).getText();
			Liaotian lt=new Liaotian(name,friendNo);
			Gliaotian.addLiaotian(name+" "+friendNo, lt);
		}
		
	}
	
	public void mouseEntered(MouseEvent e) {
		JLabel lb=(JLabel)e.getSource();
		lb.setForeground(Color.red);
		
	}
	
	public void mouseExited(MouseEvent e) {
		JLabel lb=(JLabel)e.getSource();
		lb.setForeground(Color.black);
	}

	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
}
