package java.awt.event;

import java.awt.Point;

public class MouseEvent {
	public static final int BUTTON1 = 0;
	public int x;
	public int y;
	public int button=1;
	Object src=null;
	private boolean consumed;
	public boolean metaDown=false;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getButton() {
		// TODO Auto-generated method stub
		return button;
	}
	public Object getSource(){
		return src;
	}
	
	public boolean isMetaDown(){
		return metaDown;
	}
	public void setConsumed(boolean b){
		consumed=b;
	}	
	public void consume(){
		consumed=true;
	}
	public boolean isConsumed(){
		return consumed;
	}
	public Point getPoint() {
		return new Point(getX(),getY());
	}
	public int getModifiers() {
		return 0;
	}
}
