package ch7.test;
import ch7.data.*;
public class AppTest {
  public static void main(String args[]) {
	  Point [] [] point = new Point[3][3];
	  for(int i=0;i<point.length;i++) {
		  for(int j = 0;j<point[i].length;j++) {
			  point[i][j] = new Point();
		  }
	  }
	  Block block[][] = new Block[3][3];
	  for(int i = 0;i<block.length;i++) {
		  for(int j = 0; j<block[i].length;j++) {
			  block[i][j] = new Block();
			  block[i][j].setAllPoint(point);
			  block[i][j].setAtPoint(point[i][j]);
			  point[i][j].setHaveBlock(true);
			  point[i][j].setBlock(block[i][j]);
		  }
	  }
	  point[2][2].setHaveBlock(false);
	  point[2][2].setBlock(null);
	  VerifySuccess verifySuccess = new VerifySuccess();
	  Integer [] number= {1,2,3,4,5,6,7,8,};
	  verifySuccess.setPoint(point);
	  verifySuccess.setObject(number);
	  block[0][0].setObject(number[0]);
	  block[0][1].setObject(number[1]);
	  block[0][2].setObject(number[2]);
	  block[1][0].setObject(number[3]);
	  block[1][1].setObject(number[7]);
	  block[1][2].setObject(number[4]);
	  block[2][0].setObject(number[6]);
	  block[2][1].setObject(number[5]);
	  input(point);
	  System.out.println("---------------------------");
	  System.out.println("移动2次");
	  System.out.println(point[2][1].getBlock().move());
	  System.out.println(point[1][1].getBlock().move());
	  input(point);
	  System.out.println("成功否："+verifySuccess.isSuccess());
	  System.out.println("再移动2次");
	  System.out.println(point[1][2].getBlock().move());
	  System.out.println(point[2][2].getBlock().move());
	  input(point);
	  System.out.println("成功否："+verifySuccess.isSuccess());
	  
	  
  }
  static void input(Point[][]point) {
	  int k = 0;
	  for (int i=0;i<point.length;i++) {
		  for(int j = 0;j<point[i].length;j++) {
			  String s="";
			  Block bk = point[i][j].getBlock();
			  if(bk != null) {
				  Integer object = (Integer)bk.getObject();
				  s=object.toString();
			  }
			  else 
				  s="#";
			  System.out.printf("%5s",s);
		  }
		  System.out.println();
	  }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
