package java.awt.image;

import java.awt.Graphics;
import java.awt.Image;

public class BufferedVideo extends Image {
	public BufferedVideo(int w, int h){
		/**
		 * @j2sNative
		 * var tmp=document.createElement('video');
		 * tmp.width=w;
		 * tmp.height=h;
		 * tmp.src="img/clouds.mp4";
		 * tmp.autoplay="autoplay";
		 * tmp.loop="loop";
		 * this.img=tmp;
		 */ {  }
	}
	
	public Graphics getGraphics(){
		Graphics ret=new Graphics();
		/**
		 * @j2sNative
		 * ret.ctx=this.img.getContext("2d");
		 */ {  }
		 return ret;
	}

}
