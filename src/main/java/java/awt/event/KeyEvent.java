package java.awt.event;

import java.awt.Point;

public class KeyEvent {
	Object src=null;
	private boolean consumed;
	public char keyChar;
	
	public Object getSource(){
		return src;
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
	
	public char getKeyChar() {
		return keyChar;
	}
}
