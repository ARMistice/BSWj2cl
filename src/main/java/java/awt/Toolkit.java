package java.awt;

public class Toolkit {

	static Toolkit defTool;
	
	public static Toolkit getDefaultToolkit() {
		if(defTool==null) defTool=new Toolkit();
		return defTool;
	}

	public Cursor createCustomCursor(Image image, Point point, String string) {
		return new Cursor("url("+image.img.src+") "+point.x+" "+point.y+", auto");
	}

}
