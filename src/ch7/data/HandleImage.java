package ch7.data;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
public class HandleImage extends JComponent {
    int imageWidth, imageHeight;
    Toolkit tool;
    public HandleImage() {
    	tool = getToolkit();
    }
    public Image [] getImages(Image image, int rows, int colums) {
    	Image [] blockImage = new Image[rows*colums];
    	try {
    		imageWidth = image.getWidth(this);
    		imageHeight = image.getHeight(this);
    		int w = imageWidth /colums;
    		int h = imageHeight/rows;
    		int k = 0;
    		PixelGrabber pg = null; 
    		ImageProducer ip = null;
    		for( int i = 0 ; i< rows; i++) {
    			for (int j = 0; j< colums; j++) {
    				int pixels[]=new int [w*h];
    				pg = new PixelGrabber(image,j*w,i*h,w,h,pixels,0,w);
    				pg.grabPixels();
    				ip = new MemoryImageSource(w,h,pixels,0,w);
    				blockImage[k] = tool.createImage(ip);
    				k++;
    			}
    		}
    	}catch (Exception ee) {}
		return blockImage;
    }
	

	
	
}
