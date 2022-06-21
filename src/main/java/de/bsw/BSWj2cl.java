package de.bsw;

import java.awt.Graphics2D;
import java.util.Random;

import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsMethod;

public class BSWj2cl {

    public static final String HELLO_WORLD = "Naja J2CL world!";
    
    public void onModuleLoad() {
    	Texture.load( "wizard" , (result) -> { onModuleReady(); });    	
    }
    
    public HTMLButtonElement createButton(String text) {
        HTMLButtonElement emw=(HTMLButtonElement)DomGlobal.document.createElement("button");
        HTMLDivElement ripple = (HTMLDivElement) DomGlobal.document.createElement("div");
        HTMLElement span = (HTMLElement) DomGlobal.document.createElement("span");
        HTMLElement icon = (HTMLElement) DomGlobal.document.createElement("i");
        emw.setAttribute("class", "mdc-button mdc-button--raised");
        ripple.setAttribute("class", "mdc-button__ripple");
        span.setAttribute("class", "mdc-button__label");
        icon.setAttribute("class", "material-icons mdc-button__icon");
        icon.textContent="bookmark";
        icon.setAttribute("aria-hidden", true);
        span.textContent=text;
        emw.append(ripple);
        emw.append(icon);
        emw.append(span);
        attachTo(emw);
        return emw;
    }

    public HTMLDivElement createCard(String text) {
        HTMLDivElement card = (HTMLDivElement) DomGlobal.document.createElement("div");
        card.setAttribute("class", "mdc-card mdc-card--outlined");
        return card;
    }

    @JsMethod(namespace = "mdc.ripple.MDCRipple")
    public static native void attachTo(HTMLElement a);
    
    public void onModuleReady() {
        Graphics2D g=new Graphics2D();
        Random r=new Random();
        
        
        HTMLDivElement wrapper = (HTMLDivElement) DomGlobal.document.createElement("div");
        wrapper.classList.add("wrapper");

        HTMLButtonElement btn = (HTMLButtonElement) DomGlobal.document.createElement("button");
        btn.classList.add("myButton");
        btn.textContent = "Click here";
 
        
        btn.addEventListener("click", evt -> { 
        	btn.textContent = helloWorldString();
        	g.drawImage(Texture.store.get("wizardPics/1.png"), r.nextInt()&255,r.nextInt()&255, null);
        	g.fillRect(r.nextInt()&255,r.nextInt()&255,10,10);
        } );
        wrapper.appendChild(btn);
        DomGlobal.document.body.appendChild(wrapper);
        
        HTMLCanvasElement ca = (HTMLCanvasElement) DomGlobal.document.createElement("canvas");
	    ca.width=(255);
	    ca.height=(255);
	    CanvasRenderingContext2D ctx=(CanvasRenderingContext2D)(Object)ca.getContext("2d");
		g.ctx=ctx;
		
//		BufferedImage rp=imageStore.get("wizardPics/bg.jpg");
//		rp.img=img;
//		g.drawImage(rp, 0,0, null);
		g.fillOval(70, 70, 80, 80);
		
//        Graphics g=new Graphics();
		HTMLDivElement card=createCard("");
		wrapper.append(ca);
		card.append(createButton("Test"));
		
		wrapper.append(createButton("Master Button"));
		wrapper.append(createButton("Second"));
		wrapper.append(card);
    }

    public String helloWorldString() {
        return HELLO_WORLD;
    }
}
