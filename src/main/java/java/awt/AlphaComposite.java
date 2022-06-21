package java.awt;

public class AlphaComposite {

	public static final int SRC_OVER = 0;

	public static Composite getInstance(int srcOver, float f) {
		Composite ret=new Composite();
		ret.alpha=f;
		return ret;
	}

}
