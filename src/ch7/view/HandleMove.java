package ch7.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ch7.data.Block;
import ch7.data.Point;
import ch7.data.VerifySuccess;
public class HandleMove extends JPanel implements MouseListener,ActionListener{
Point [][] point ;
int spendTime = 0;
Timer recordTime;
JTextField showTime;
VerifySuccess verify;
HandleMove(){
	recordTime = new Timer(1000,this);
	showTime = new JTextField(16);
	showTime.setEditable(false);
	showTime.setHorizontalAlignment(JTextField.CENTER);
	showTime.setFont(new Font("楷体_GB2312",Font.BOLD,16));
	JLabel hitMess = new JLabel("用鼠标单击方块",JLabel.CENTER);
	hitMess.setFont(new Font("楷体_GB2312",Font.BOLD,18));
	add(hitMess);
	add(showTime);
	setBackground(Color.cyan);
}

	public static void play() {
	}

	public void setPoint(Point [][] p) {
	point = p ;
}
public void initSpendTime() {
	recordTime.stop();
	spendTime = 0;
	showTime.setText(null);
}
public void setVerifySuccess(VerifySuccess verify) {
	this.verify = verify;
}
public void mousePressed(MouseEvent e) {
	recordTime.start();
	Block block = null;
	block = (Block)e.getSource();
	Point startPoint = block.getAtPoint();
	int w= block.getBounds().width;
	int h = block.getBounds().height;
	if(block.move()) {
		Point pEnd = block.getAtPoint();
		int x= pEnd.getX();
		int y= pEnd.getY();
		block.setLocation(x,y);
		block.setAtPoint(pEnd);
		pEnd.setBlock(block);
		pEnd.setHaveBlock(true);
		startPoint.setHaveBlock(false);
	}
}
public void actionPerformed(ActionEvent e) {
	spendTime++;
	showTime.setText("您所用的时间: "+spendTime+"秒");
}
public void mouseReleased(MouseEvent e) {
	if(verify.isSuccess()) {
		recordTime.stop();
		JOptionPane.showMessageDialog(this,"雷思龙♥林紫曦","消息框",JOptionPane.INFORMATION_MESSAGE);
		
	}
}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseClicked(MouseEvent e) {}
}
