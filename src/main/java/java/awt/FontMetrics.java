package java.awt;

public class FontMetrics {
	Graphics g;
	Font lf=null;
	
	public FontMetrics(Graphics gf){
		g=gf;
	}
	
	public FontMetrics(Graphics gf, Font f){
		g=gf;
		lf=f;
	}
	public int stringWidth(String str) {
		Font backup=null;
		if(lf!=null){ 
			backup=g.font; 
			g.setFont(lf);
		} 
		int ret=(int)g.ctx.measureText(""+str).width;
		if(lf!=null && backup!=null) g.setFont(backup);
		return	ret;
	}

	// height = ascent + descent + leading

	public int getHeight() {
		Font effective = lf != null ? lf : g.font;
		int size = effective != null ? effective.size : 12;
		return size*128/100;
	}
	public int getAscent() {
		Font effective = lf != null ? lf : g.font;
		int size = effective != null ? effective.size : 12;
		return size*101/100;
	}
	public int getLeading() {
		Font effective = lf != null ? lf : g.font;
		int size = effective != null ? effective.size : 12;
		return size*5/100;
	}
	public int getDescent() {
		Font effective = lf != null ? lf : g.font;
		int size = effective != null ? effective.size : 12;
		return size*22/100;
	}
}
