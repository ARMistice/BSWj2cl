package java.applet;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAudioElement;

public class AudioClip {
	HTMLAudioElement sample;
	
	public AudioClip(String string) {
		sample=(HTMLAudioElement)DomGlobal.document.createElement("audio");
		sample.src=string; //setSrc(string);
	}
	public void play(){
		sample.play();
	}
	public void stop(){
	}
	public void loop(){
	}
	public void setVolume(double v){
		sample.volume=v;
	}
}
