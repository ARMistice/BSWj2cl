package java.util;

public class Hashtable<T,U> extends HashMap {

	public Enumeration elements(){
		return Collections.enumeration(entrySet());
	}
	public Enumeration keys(){
		return Collections.enumeration(keySet());
	}
}
