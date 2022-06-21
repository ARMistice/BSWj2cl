package java.awt;

public class Ticker implements Runnable{
	Runnable ru;
	
	
	public Ticker(Runnable runnable, int w){
		ru=runnable;
		/**
		 * @j2sNative
		 *  
		 *  this.id=window.setInterval((function(runnable){return function(){runnable.run();};})(runnable),w);
		 */ {  }	
	}

	public void run(){
		ru.run();
	}

	public void stop(){
		/**
		 * @j2sNative
		 *  
		 *  window.clearInterval(this.id);
		 */ {  }	
	}

}