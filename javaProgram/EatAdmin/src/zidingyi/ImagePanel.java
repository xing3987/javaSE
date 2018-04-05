package zidingyi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	Image im;
	public ImagePanel(Image im){
		this.im=im;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		this.setSize(height,width);
	}
	public void paintComponent(Graphics g){//用paintConponent不用paint可以保留imagePanel上的组件不被覆盖
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
