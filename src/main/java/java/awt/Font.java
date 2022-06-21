package java.awt;

public class Font {
	public static final int BOLD = 1;
	public static final int PLAIN = 0;
	public static final int ITALIC = 2;
	String name;
	String mode="normal";
	int size;
	String htmlStr="";
	
	public Font(String name, int mode, int size){
//		if(name.equals("Helvetica"))
//			name="sansserif";
	//	name="sans-serif";
		this.name=name;
		this.mode=mode==0?"normal":(mode==1?"bold":"italic");
		this.size=size;
		//this.htmlStr="bold 12px sans-serif";
		this.htmlStr=this.mode+" "+size+"px '"+name+"'";
		/**
		 * @j2sNative
		 * 	this.ctx=document.getElementById("graphics").getContext("2d");
		 */ {  }
	}
	
	public String  getHtml(){
		return htmlStr;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public String getFamily() {
		// TODO Auto-generated method stub
		return "Helvetica";
	}
}
