package java.awt;

public class BasicStroke {

	public float width=1;
	public static final int CAP_BUTT = 1,CAP_ROUND=2;
	public static final int JOIN_MITER = 0x10, JOIN_ROUND=0x20;

	public int capButt;
	int joinMiter;
	float[] dash;
	float h;
	
	public BasicStroke(int i) {
		width=i;
	}

	public BasicStroke(float i) {
		width=i;
	}
	
	public BasicStroke() {
		// TODO Auto-generated constructor stub
	}

	public BasicStroke(float f, int capButt, int joinMiter, float g, float[] dash1, float h) {
		width=f;
		dash=dash1;
		this.capButt=capButt;
		this.joinMiter=joinMiter;
	}

	public BasicStroke(int co, int cap, int join) {
		this.capButt=cap;
		this.joinMiter=join;
	}

}
