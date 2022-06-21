package java.awt;

import java.util.Vector;

public class MediaTracker implements Runnable{
	
	Vector<Image>[] slots=new Vector[20];
	//Runnable runnable;
	int count=0;
	
	public MediaTracker(Object obs){
		//runnable=obs;
		for(int i=0; i<20; i++){
			slots[i]=new Vector<Image>();
		}
	}


	public void addImage(Image i, int slot){
		slots[slot].add(i);
		count++;
	}
	
	public void waitForID(int slot){
		boolean notDone=true;
//		while(notDone){
//			notDone=false;
//			for (Image el : slots[slot]) {
//				if(el.status==0) notDone=true;
//			}
//		}
	}
	
	public void checkID(int slot, boolean start){
		System.err.println("Media Tracker checking ("+slots[slot].size()+")");
		for (Image el : slots[slot]) {
			el.startLoad(this);
		}
	}
	
	public void run(){
		count--;
		System.err.println("Media Tracker registered Load. ("+count+")");
		//if(count==0) runnable.run();
	}

	public void checkAll(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void waitForAll() {
		// TODO Auto-generated method stub
		
	}


	public void removeImage(Image loaded) {
		// TODO Auto-generated method stub
		
	}
}
