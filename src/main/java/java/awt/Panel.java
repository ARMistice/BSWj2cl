package java.awt;

import java.awt.event.MouseEvent;

public class Panel {

	private int h;
	private int w;

	public Cursor getCursor(){
		return null;
	}

	public boolean mouseDown(Event e, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean mouseMove(Event e, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean mouseUp(Event ev, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean mouseDrag(Event ev, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public void setSize(int w, int h){
		this.h=h; this.w=w;
	}
	public int getHeight(){
		return h;
	}
	public int getWidth(){
		return w;
	}
	public String getName(){
		return "noNamePanel";
	}
	public String getClientName(){
		return getName();
	}
	public void repaint(){
		
	}

	public void setCursor(Cursor c) {
		// TODO Auto-generated method stub
		
	}

	public void repaint(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}
}
