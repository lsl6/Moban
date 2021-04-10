package ch7.data;

public class Point {
int x,y;
boolean haveBlock;
Block block = null;
public Point() {
}
public Point(int x , int y) {
	this.x = x;
	this.y = y;
}
public boolean isHaveBlock() {
	return haveBlock;
}
public void setHaveBlock(boolean b) {
	haveBlock = b;	
}
public int getX() {
	return x;
}
public int getY() {
	return y;
}
public void setBlock(Block block) {
	this.block = block;
}
public Block getBlock() {
	return block;
}
}
