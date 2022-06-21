package java.util;

public class Properties extends HashMap{

	public String getProperty(String s){
		return (String)get(s);
	}
	
	public String getProperty(String s, String def){
		if(get(s)==null) return def;
		return (String)get(s);
	}
	
	public void setProperty(String s, String v){
		put(s,v);
	}
	
	public void load(String file){
		
	}
}
