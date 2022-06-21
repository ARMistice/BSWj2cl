package java.awt;

public class GradientPaint {
	int xs,ys;
	Color colorS;
	int xe,ye;
	Color colorE;
	boolean cyclic;
	
	public GradientPaint(int xs, int ys, Color colorS, int xe, int ye, Color colorE, boolean cyclic) {
		this.xs = xs;
		this.ys = ys;
		this.colorS = colorS;
		this.xe = xe;
		this.ye = ye;
		this.colorE = colorE;
		this.cyclic = cyclic;
	}

}
