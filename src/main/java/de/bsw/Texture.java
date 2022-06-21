package de.bsw;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;

import elemental2.core.Global;
import elemental2.core.JsArray;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.XMLHttpRequest;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

public class Texture {

	public static HashMap<String, BufferedImage> store = new HashMap<String, BufferedImage>();

	public static void load(String tname, Consumer<String> fn) {
		HTMLImageElement img = (HTMLImageElement) DomGlobal.document.createElement("img");
		img.src = tname+".png";
		img.onload = (event) -> {
			XMLHttpRequest xhr = new XMLHttpRequest();
			xhr.onload = eventT -> {
				JsPropertyMap<?> parsed = Js.cast(Global.JSON.parse(xhr.responseText));
				JsArray<Any> jsFrames = Js.cast(parsed.get("frames"));
				for (int i = 0; i < jsFrames.length; i++) {
					JsPropertyMap<?> frame = Js.cast(jsFrames.getAt(i));
					String name = "" + frame.get("filename");
					int fx = ((JsPropertyMap<?>) Js.cast(frame.get("frame"))).getAsAny("x").asInt();
					int fy = ((JsPropertyMap<?>) Js.cast(frame.get("frame"))).getAsAny("y").asInt();
					int fw = ((JsPropertyMap<?>) Js.cast(frame.get("frame"))).getAsAny("w").asInt();
					int fh = ((JsPropertyMap<?>) Js.cast(frame.get("frame"))).getAsAny("h").asInt();
					int ssx = ((JsPropertyMap<?>) Js.cast(frame.get("spriteSourceSize"))).getAsAny("x").asInt();
					int ssy = ((JsPropertyMap<?>) Js.cast(frame.get("spriteSourceSize"))).getAsAny("y").asInt();
					int ssw = ((JsPropertyMap<?>) Js.cast(frame.get("spriteSourceSize"))).getAsAny("w").asInt();
					int ssh = ((JsPropertyMap<?>) Js.cast(frame.get("spriteSourceSize"))).getAsAny("h").asInt();
					int sw = ((JsPropertyMap<?>) Js.cast(frame.get("sourceSize"))).getAsAny("w").asInt();
					int sh = ((JsPropertyMap<?>) Js.cast(frame.get("sourceSize"))).getAsAny("h").asInt();

					BufferedImage bi = new BufferedImage(sw, sh, 0);
					((CanvasRenderingContext2D) (Object) (bi.can.getContext("2d"))).drawImage(img, fx, fy, fw, fh, ssx,ssy, ssw, ssh);
					store.put(tname + "Pics/" + name, bi);
					DomGlobal.console.log("Stored: " + "wizard" + "Pics/" + name + " ==> " + bi.getWidth());
				}
				img.remove();
				if (img!=null) {
					while (img.firstChild!=null) {
						img.removeChild(img.firstChild);
					}
				}
				fn.accept("okay");
			};
			xhr.open("GET", "wizard.json");
			xhr.withCredentials = true;
			xhr.send();
			return event;
		};
	}
	
	public static void clear(String tname) {
		Iterator<String> it=store.keySet().iterator();
		while(it.hasNext()) {
			String key=it.next();
			if(key.startsWith(tname+"Pics")) {
				store.get(key).flush();
				it.remove();
			}
		}
	}
}
