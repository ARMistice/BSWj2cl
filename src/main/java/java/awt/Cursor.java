package java.awt;

public class Cursor {


	public static final int DEFAULT_CURSOR = 0;
	public static final int NW_RESIZE_CURSOR = 0;
	public static final int W_RESIZE_CURSOR = 0;
	public static final int N_RESIZE_CURSOR = 0;
	public static final int WAIT_CURSOR = 0;
	public static final int HAND_CURSOR = 0;

	public int cursorTyp=-1;
	public String cursorStyle;

	public Cursor(int cu){
		cursorTyp=cu;
	}

	public Cursor(String style) {
		cursorStyle=style;
	}
}
