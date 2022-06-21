package java.awt;

public class Graphics2D extends Graphics {

	
	public void setPaint(GradientPaint grad) {
		//if(!grad.cyclic){

		// TODO //			CanvasGradient gr=ctx.createLinearGradient(grad.xs,grad.ys,grad.xe,grad.ye);
//			gr.addColorStop(0, grad.colorS.toString());
//			gr.addColorStop(1, grad.colorE.toString());
//			ctx.setFillStyle(gr);
//			ctx.setStrokeStyle(gr);
		//}
	}

	public int getRenderingHint(int keyInterpolation) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setRenderingHint(int keyInterpolation, Object object) {
		// TODO Auto-generated method stub
		
	}

//	public Graphics create() {
//		return super.;
//	}

	// TODO
//	public FontRenderContext getFontRenderContext() {
//		FontRenderContext ctx=new FontRenderContext();
//		ctx.g=this;
//		return ctx;
//	}

	public void draw(Rectangle s) {
		drawRect(s.x, s.y, s.width, s.height);
		
	}
	public void fill(Rectangle s) {
		fillRect(s.x, s.y, s.width, s.height);
	}

	


}
