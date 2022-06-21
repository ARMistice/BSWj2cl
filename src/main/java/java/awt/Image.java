package java.awt;

import java.awt.image.BufferedImage;

import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLImageElement;





public class Image implements Runnable{
	public static final int SCALE_FAST = 0;
	public static final int SCALE_AREA_AVERAGING = 1;
	int status=1;
	String source;
	public HTMLImageElement img;
	public HTMLCanvasElement can;
	
	public Image(){
		img = (HTMLImageElement) DomGlobal.document.createElement("img");
		/**
		 * @j2sNative
		 * 	this.img=new Image();
		 */ {  }
	}
	public Image(String name){
//		Client.loadAdd();
//		ImagePreloader.load(name,new ImageLoadHandler() {
//			@Override
//			public void imageLoaded(ImageLoadEvent event) {
//				// TODO Auto-generated method stub
//				Client.loadDone();
//			}
//		});
		
		img = (HTMLImageElement) DomGlobal.document.createElement("img");
	}
	
	public Graphics getGraphics(){
		Graphics ret=new Graphics2D();
		if(can!=null){
			ret.ctx=(CanvasRenderingContext2D)(Object)can.getContext("2d");
		}else{  // ist es ein image und ich brauch die graphics davon
			int w=img.width;
			int h=img.height;
			HTMLCanvasElement ca = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
		    ca.width=(w);
		    ca.height=(h);
		    ret.ctx=(CanvasRenderingContext2D)(Object)ca.getContext("2d");
			ret.ctx.drawImage(img, 0, 0);
		}
		return ret;
	}
	public void load(String src){
		img = (HTMLImageElement) DomGlobal.document.createElement("img");
		img.src=src;
//		img.setUrl(src);
//		img.addLoadHandler(new LoadHandler() {
//			
//			@Override
//			public void onLoad(LoadEvent event) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
	}

	public void startLoad(Runnable runnable){
		status=0;
		/**
		 * @j2sNative
		 *  this.img.onload=((function(runnable){return function(){runnable.run();};})(runnable));
		 * 	this.img.src=this.source;
		 */ {  }
	}
	public void setSource(String pa){
		source=pa;
	}
	
	public int getWidth(Object o){
		int ret=-1;
		if(can!=null){
			ret=can.width; //getCoordinateSpaceWidth();
		}else{  // ist es ein image und ich brauch die graphics davon
			ret=img.width;
		}
		return ret;
	}
	public int getHeight(Object o){
		int ret=-1;
		if(can!=null){
			ret=can.height;
		}else{  // ist es ein image und ich brauch die graphics davon
			ret=img.height;
		}
		return ret;
	}

	public int getWidth(){
		 return getWidth(null);
	}
	public int getHeight(){
		 return getHeight(null);
	}

	public void run() {
		status=1;
		System.err.println("Loaded...");
	}

	public void flush() {
		if(img!=null) img.remove(); //removeFromParent();
		if(can!=null) can.remove(); //FromParent();
		img=null;
		can=null;
	}


	public Image getScaledInstance(int i, int j, int scaletype) {
		BufferedImage bi=new BufferedImage(i,j,0);
		bi.getGraphics().drawImage(this, 0,0,i,j, null);
		return bi;
	}

	public Image getScaledInstance(double factorX, double factorY, int scaletype) {
		int i=(int)(factorX*getWidth());
		int j=(int)(factorX*getHeight());
		BufferedImage bi=new BufferedImage(i,j,0);
		bi.getGraphics().drawImage(this, 0,0,i,j, null);
		return bi;
	}
	public Image getSource() {
		return this;
	}
}
