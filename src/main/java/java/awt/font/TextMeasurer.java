package java.awt.font;

import java.text.AttributedCharacterIterator;
import java.text.CharacterIterator;

public class TextMeasurer {

	AttributedCharacterIterator aci;
	FontRenderContext frc;
	
	public TextMeasurer(AttributedCharacterIterator aci, FontRenderContext frc) {
		this.aci=aci;
		this.frc=frc;
	}

	public int getLineBreakIndex(int index, float maxWidth) {
		int backup=aci.getIndex();
		aci.setIndex(index);
		String b="";
		char ch;
		int c=0;
		while((ch=aci.current())!=CharacterIterator.DONE){
			b+=ch;
			if(frc.g.getFontMetrics().stringWidth(b)>maxWidth){
				// zu groß, Endindex bis vorheriges Zeichen
				aci.setIndex(backup);
				return c+index;
			}
			c++;
			aci.next();
		}
		aci.setIndex(backup);
		return c+index;
	}

}
