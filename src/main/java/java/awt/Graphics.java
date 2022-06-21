package java.awt;

import java.awt.geom.AffineTransform;

import elemental2.dom.BaseRenderingContext2D.FillStyleUnionType;
import elemental2.dom.BaseRenderingContext2D.StrokeStyleUnionType;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;


public class Graphics {
	Font font;
	Color col;
	Composite comp=new Composite();
	public CanvasRenderingContext2D ctx;
	int clX,clY,clW,clH=-1;
	BasicStroke stroke;

	public Graphics(){
	}
	
	public void initDef(){
		HTMLCanvasElement ca = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
	    ca.width=(10);
	    ca.height=(10);
//	    ca.getElement().getStyle().setProperty("webkitTransform", "rotate(45deg) scale(2)");
//	    ca.getElement().getStyle().setProperty("mozTransform", "rotate(45deg) scale(2)");
	    //setAttribute("style", "-webkit-transform: rotate(45deg) scale(2)");
		ctx=(CanvasRenderingContext2D)(Object)ca.getContext("2d");
	}
	
	public Composite getComposite() {
		return comp;
	}

	public void setComposite(Composite c) {
		comp=c;
		ctx.globalAlpha=(c.alpha);
	}
	
	public void setLineWidth(float w){
		ctx.setLineWidth(w);
	}

	public void setRenderingHint(int keyAntialiasing, int valueAntialiasOn) {
		// TODO Auto-generated method stub
		
	}

	public void rotate(double radians, float x, float y) {
		ctx.translate(x, y);
		ctx.rotate(radians);
		ctx.translate(-x, -y);
	}
	public void translate(float x, float y) {
		ctx.translate(x, y);
	}
	public void translate(double x, double y) {
		ctx.translate(x, y);
	}
	public void scale(double x, double y) {
		ctx.scale(x, y);
	}
	public void shear(double x, double y) {
		ctx.transform(1, y, x, 1, 0, 0);
	}
	
	public void rotate(double radians) {
		ctx.rotate(radians);
	}

	java.awt.geom.AffineTransform curTransform=new AffineTransform();
	
	public void setTransform(java.awt.geom.AffineTransform state) {
		//ctx.restore();
		//if(state==null) return;
//		public void getMatrix(double[] flatmatrix) {
//	        flatmatrix[0] = m00;
//	        flatmatrix[1] = m10;
//	        flatmatrix[2] = m01;
//	        flatmatrix[3] = m11;
//	        if (flatmatrix.length > 5) {
//	            flatmatrix[4] = m02;
//	            flatmatrix[5] = m12;
//	        }
//	    }

		curTransform=state;
		double[] te=new double[6];
		curTransform.getMatrix(te);
		ctx.setTransform(te[0],te[1],te[2],te[3],te[4],te[5]);
	}

	public java.awt.geom.AffineTransform getTransform() {
		//ctx.save();
		return curTransform;
	}
	// -------------------------------------------------------------
	


	public void setFont(Font f){
		font=f;
		//ctx.setTextBaseline("alphabetic");
		ctx.setTextBaseline("Alphabetic");
		ctx.setFont(f.getHtml());
	}
	
	public int getWidth(){
		int ret=ctx.canvas.width;
		 return ret;
	}
	
	public int getHeight(){
		int ret=ctx.canvas.height;
		 return ret;
	}
	
	public void setColor(Color c){
		col=c;
		ctx.fillStyle=FillStyleUnionType.of("rgba("+c.getRed()+","+c.getGreen()+","+c.getBlue()+","+((double)c.getAlpha()/255.0D)+")");
		ctx.strokeStyle=StrokeStyleUnionType.of("rgba("+c.getRed()+","+c.getGreen()+","+c.getBlue()+","+((double)c.getAlpha()/255.0D)+")");
	}
	public void setBackground(Color c){
		ctx.fillStyle=FillStyleUnionType.of("rgba("+c.getRed()+","+c.getGreen()+","+c.getBlue()+","+((double)c.getAlpha()/255.0D)+")");
	}
	public void drawImage(Image a, int x, int y, Object o){
		if(a==null) return;
		if(a.img!=null)
			ctx.drawImage(a.img, x, y);
		else
			ctx.drawImage(a.can, x, y);
	}
	public void drawImage(Image a, int x, int y, int w, int h, Object o){
		if(a==null) return;
		if(w<0) {
			ctx.save();
			ctx.translate(x, y);
			ctx.scale(-1,1);
			if(a.img!=null)
				ctx.drawImage(a.img, 0, 0, w, h);
			else
				ctx.drawImage(a.can, 0, 0, w, h);
			ctx.restore();
		}else {
			if(a.img!=null)
				ctx.drawImage(a.img, x, y, w, h);
			else
				ctx.drawImage(a.can, x, y, w, h);
		}
	}
	
	public void drawImage(Image image, AffineTransform at, Object object) {
		ctx.save();
		setTransform(at);
		drawImage(image,0,0,null);
		ctx.restore();
	}

	public void drawImage(Image a, int dx, int dy, int dx2, int dy2, int sx, int sy, int sx2, int sy2, Object object) {
		if(a==null) return;
		if(dx2-dx<0 || sx2-sx<0) {
			ctx.save();
			ctx.translate(dx+(dx2-dx), dy);
			ctx.scale(-1,1);
			if(a.img!=null){
				int sw=sx2-sx;
				int sh=sy2-sy;
				if(sw>a.img.width) sw=a.img.width;
				if(sh>a.img.height) sh=a.img.height;
				//ctx.drawImage(ImageElement.as(a.img.getElement()), dx,dy,dx2-dx,dy2-dy);
				ctx.drawImage(a.img, sx,sy,sw,sh, 0,0,dx2-dx,dy2-dy);
			}else
				ctx.drawImage(a.can, sx,sy,sx2-sx,sy2-sy, 0,0,dx2-dx,dy2-dy);
			ctx.restore();
		}else {
			if(a.img!=null){
				int sw=sx2-sx;
				int sh=sy2-sy;
				if(sw>a.img.width) sw=a.img.width;
				if(sh>a.img.height) sh=a.img.height;
				//ctx.drawImage(ImageElement.as(a.img.getElement()), dx,dy,dx2-dx,dy2-dy);
				ctx.drawImage(a.img, sx,sy,sw,sh, dx,dy,dx2-dx,dy2-dy);
			}else
				ctx.drawImage(a.can, sx,sy,sx2-sx,sy2-sy, dx,dy,dx2-dx,dy2-dy);
		}
	}
	
	public void fillRect(int x, int y,int w, int h){
		ctx.fillRect(x, y, w, h);
	}
	public void fill3DRect(int x, int y,int w, int h, boolean up){
		ctx.fillRect(x, y, w, h); // FIXME
	}
	public void drawRect(int x, int y,int w, int h){
		ctx.strokeRect(x, y, w, h);
	}
	public void fillRoundRect(int x, int y,int w, int h, int rw, int rh){
		x=(x|0);
		y=(y|0);
		w=(w|0);
		h=(h|0);
		rw=((rw/2)|0);
		rh=((rh/2)|0);
		ctx.beginPath();
		ctx.moveTo(x+rw, y);
		ctx.lineTo(x+w-rw, y);
		ctx.quadraticCurveTo(x+w, y, x+w, y+rh);
		ctx.lineTo(x+w, y+h-rh);
		ctx.quadraticCurveTo(x+w, y+h, x+w-rw, y+h);
		ctx.lineTo(x+rw, y+h);
		ctx.quadraticCurveTo(x, y+h, x, y+h-rh);
		ctx.lineTo(x, y+rh);
		ctx.quadraticCurveTo(x, y, x+rw, y);
		ctx.fill(); 
	}
	public void drawRoundRect(int x, int y,int w, int h, int rw, int rh){
		x=(x|0);
		y=(y|0);
		w=(w|0);
		h=(h|0);
		rw=((rw/2)|0);
		rh=((rh/2)|0);
		ctx.beginPath();
		ctx.moveTo(x+rw, y);
		ctx.lineTo(x+w-rw, y);
		ctx.quadraticCurveTo(x+w, y, x+w, y+rh);
		ctx.lineTo(x+w, y+h-rh);
		ctx.quadraticCurveTo(x+w, y+h, x+w-rw, y+h);
		ctx.lineTo(x+rw, y+h);
		ctx.quadraticCurveTo(x, y+h, x, y+h-rh);
		ctx.lineTo(x, y+rh);
		ctx.quadraticCurveTo(x, y, x+rw, y);
		ctx.stroke(); 
	}
	
	public void drawArc(int x, int y, int r, double sw, double ew ){
		ctx.beginPath();
		ctx.arc(x,y,r,sw,ew);
		ctx.closePath();
		ctx.stroke();
	}
	public void fillArc(int x, int y, int r, double sw, double ew ){
		ctx.beginPath();
		ctx.moveTo(x+r/2,y+r/2);
		ctx.arc(x+r/2,y+r/2,r/2,(double)(sw+270.0)*Math.PI/180.0,(double)(sw+ew+270)*Math.PI/180.0,false);
		ctx.closePath();
		ctx.fill();
	}
	public void fillArc(int x, int y, int w, int h,  double sw, double ew ){
		ctx.beginPath();
		ctx.moveTo(x+w/2,y+h/2);
		ctx.arc(x+w/2,y+h/2,w/2,(double)(sw+270.0)*Math.PI/180.0,(double)(sw+ew+270)*Math.PI/180.0,false);
		ctx.closePath();
		ctx.fill();
	}
	
	public void drawOval(int x, int y, int w, int h){
		int centerX = x+w/2;
		int centerY = y+h/2; 
		double controlRectWidth = w * 1.33;
		ctx.beginPath();
		ctx.moveTo(centerX,centerY - h/2);
		ctx.bezierCurveTo(centerX-controlRectWidth/2,centerY-h/2,centerX-controlRectWidth/2,centerY+h/2,centerX,centerY+h/2);
		ctx.bezierCurveTo(centerX+controlRectWidth/2,centerY+h/2,centerX+controlRectWidth/2,centerY-h/2,centerX,centerY-h/2);
		ctx.closePath();
		ctx.stroke();

	}
	public void fillOval(int x, int y, int w, int h){
		int centerX = x+w/2;
		int centerY = y+h/2; 
		double controlRectWidth = w * 1.33;
		ctx.beginPath();
		ctx.moveTo(centerX,centerY - h/2);
		ctx.bezierCurveTo(centerX-controlRectWidth/2,centerY-h/2,centerX-controlRectWidth/2,centerY+h/2,centerX,centerY+h/2);
		ctx.bezierCurveTo(centerX+controlRectWidth/2,centerY+h/2,centerX+controlRectWidth/2,centerY-h/2,centerX,centerY-h/2);
		ctx.closePath();
		ctx.fill();
	}
	public void drawString(String str, int x, int y){
		ctx.fillText(str, x, y);
	}
	public void drawString(String str, float x, float y){
		ctx.fillText(str, x, y);
	}
	public void setClip(int x, int y, int w, int h){
		 ctx.beginPath();
		 ctx.rect(x,y,w,h);
		 ctx.closePath();
		 ctx.clip();
	}
	public void clipRect(int x, int y, int w, int h){
		setClip(x, y, w, h);
	}
	public void setClip(Object object) {
//		if(object!=null) 
//		else{
//			ctx.beginPath();
//			 ctx.rect(0,0,1024,768);
//			 ctx.closePath();
//			 ctx.clip();
//		}
	}

	public FontMetrics getFontMetrics() {
		return new FontMetrics(this);
	}

	public FontMetrics getFontMetrics(Font fontDefault) {
		FontMetrics f=new FontMetrics(this,fontDefault);
		return f;
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
		ctx.beginPath();
		ctx.moveTo(x1,y1);
		ctx.lineTo(x2,y2);
		ctx.closePath();
		ctx.stroke();
	}

	public void save() {
		ctx.save();
	}

	public void restore() {
		ctx.restore();
	}


	public void clearRect(int x, int y, int w, int h) {
		ctx.clearRect(x,y,w,h);
	}

	public Rectangle getClipBounds() {
		// TODO Auto-generated method stub
		if(clH>-1)
			return new Rectangle(clX,clY,clW,clH);
		else return new Rectangle(0,0,getWidth(),getHeight());
	}

	public Color getColor() {
		return col;
	}


//	public void setStroke(BasicStroke basicStroke) {
//		// TODO Auto-generated method stub
//		
//	}

	public Font getFont() {
		if(font==null) font=new Font("Helvetica",0,12);
		return font;
	}

	public void fillPolygon(int[] wx, int[] wy, int ia) {
		ctx.beginPath();
		ctx.moveTo(wx[0],wy[0]);
		for(int i=1; i<ia; i++)
			ctx.lineTo(wx[i],wy[i]);
		ctx.closePath();
		ctx.fill();
	}

	public void draw3DRect(int posX, int posY, int width, int i, boolean b) {
		drawRect( posX,  posY,  width,  i);
	}

	public void copyArea(Image img,int i, int j, int w, int h, int k, int l) {
		drawImage(img,k,l,k+w,l+h,i,j,i+w,i+h,null);
	}

	public void setStroke(BasicStroke basicStroke) {
		ctx.setLineWidth(basicStroke.width);
		ctx.lineCap=(basicStroke.capButt==BasicStroke.CAP_BUTT?"butt":"square");
		ctx.lineJoin=("miter");
	}

	private boolean created=false;
	public Graphics create() {
		created=true;
		ctx.save();
		return this;
	}

	public Graphics create(int x, int y, int w, int h) {
		created=true;
		ctx.save();
		this.setClip(x, y, w, h);
		this.translate(x, y);
		return this;
	}

	public void dispose() {
		if(created)
			ctx.restore();
	}

}
