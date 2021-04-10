package ch7.data;
import javax.swing.*;
import java.awt.*;
public class Block extends JTextField {
Point point;
Object object;
Point [] [] allPoint;
int index_i, index_j ;
public Block() {
	setFocusable(false);
	setHorizontalAlignment(JTextField.CENTER);
	setFont(new Font("Arial", Font.BOLD,16));
	setForeground(Color.blue);
}
public void setAtPoint(Point p) {
	point = p;
}
public void setAllPoint(Point [] [] point) {
	allPoint = point;
}
public Point getAtPoint() {
	return point;
}
public void setObject(Object object) {
	this.object = object;
	if (object instanceof Integer) {
		Integer number = (Integer)object;
		this.setText(""+number.intValue());
	}else if(object instanceof Image) {
		this.repaint();
	}
}
public Object getObject() {
	return object;
}
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	int w= getBounds().width;
	int h = getBounds().height;
	try {
         g.drawImage((Image)object,0,0,w,h,this);		
	}catch(Exception exp) {}
}
public boolean move() {
	int m = -1,n = -1;
	boolean successMove = false;
	Point pStart = getAtPoint();
	findIndex(pStart, allPoint);
	for(int i= 0;i<allPoint.length;i++) {
		for(int j = 0;j<allPoint[i].length;j++) {
		if(!allPoint[i][j].isHaveBlock()) {
			m=i;
			n = j;
		}
	}
}
if(Math.abs(index_i-m)+Math.abs(index_j-n) == 1) {
	this.setAtPoint(allPoint[m][n]);
	successMove = true;
	allPoint[m][n].setBlock(this);
	allPoint[m][n].setHaveBlock(true);
	pStart.setHaveBlock(false);
	pStart.setBlock(null);
}
return successMove;
}
private void findIndex(Point p,Point[][] allPoint) {
	for(int i= 0;i<allPoint.length;i++) {
		for(int j = 0;j<allPoint[i].length;j++) {
		if(p == allPoint[i][j]) {
			index_i=i;
			index_j = j;
			break;
		}
	}
}
}

}
