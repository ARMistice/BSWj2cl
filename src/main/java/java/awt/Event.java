package java.awt;

public class Event {
	
	public static final int META_MASK = 2;
	public int id;

	public Event(Object object, int button, Object object2) {
		// TODO Auto-generated constructor stub
		id=button;
	}

	public boolean isMetaDown(){
		return id==3;
	}

	public boolean metaDown() {
		return id==3;
	}
}
