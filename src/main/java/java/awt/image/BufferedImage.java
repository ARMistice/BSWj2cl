package java.awt.image;

import java.awt.Graphics;
import java.awt.Image;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.ImageData;

public class BufferedImage extends Image{
	public static final int TYPE_INT_ARGB = 0;
	public static final int TYPE_4BYTE_ABGR = 0;
	public static final int TYPE_3BYTE_BGR = 0;
	public static final int TYPE_INT_RGB = 0;
	int typ=0;
	
	public BufferedImage(String name){
		super(name);
	}
	
	public BufferedImage(int w, int h, int typ){
		this.typ=typ;
		HTMLCanvasElement ca = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
//		ca.setPixelSize(w, h);
	    ca.width=(w);
	    ca.height=(h);
		can=ca;
		img=null;
	}
	
	public BufferedImage(HTMLImageElement e) {
		img=e;
	}

	public Graphics getGraphics(){
		 return (Graphics)super.getGraphics();
	}

	public int getType() {
		// TODO Auto-generated method stub
		return typ;
	}

	public int getRGB(int sx, int sy) {
// TODO
		//		if(can!=null){
//			ImageData dat=can.getContext("2d").getImageData(sx, sy, 1, 1);
//			return dat.getBlueAt(0, 0)|dat.getGreenAt(0, 0)<<8|dat.getRedAt(0, 0)<<16;
//		}
		return 0;
	}

	public void setRGB(int i, int j, int rgb) {
		// TODO Auto-generated method stub
		
	}
}
