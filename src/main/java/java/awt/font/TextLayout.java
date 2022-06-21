package java.awt.font;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.text.AttributedCharacterIterator;
import java.text.CharacterIterator;

public class TextLayout {
    Font font;
    FontRenderContext frc;
    String string;
    AttributedCharacterIterator atString;
    
	public TextLayout(String string, FontRenderContext frc) {
		this.string=string;
		this.font=frc.g.getFont();
		this.frc=frc;
    }
	public TextLayout(AttributedCharacterIterator string, FontRenderContext frc) {
		this.atString=string;
		this.string="";
		for(char c = string.first(); c != CharacterIterator.DONE; c = string.next()) {
	        this.string+=(c);
	     }
		this.font=frc.g.getFont();
		this.frc=frc;
    }
	public TextLayout(AttributedCharacterIterator string, Font font, FontRenderContext frc) {
		this.atString=string;
		this.string="";
		for(char c = string.first(); c != CharacterIterator.DONE; c = string.next()) {
	        this.string+=(c);
	     }
		this.font=font;
		this.frc=frc;
    }

    public TextLayout(String string, Font font, FontRenderContext frc) {
		this.string=string;
		this.font=font;
		this.frc=frc;
    }

	public Rectangle getBounds() {
		return new Rectangle(0,-frc.g.getFontMetrics(font).getAscent()
				,frc.g.getFontMetrics(font).stringWidth(string),font.getSize());
	}
	// c== AffineTransform
	public Rectangle getOutline(Object c) {
		return new Rectangle(0,-frc.g.getFontMetrics(font).getAscent()
				,frc.g.getFontMetrics(font).stringWidth(string),font.getSize());
	}

	public void draw(Graphics2D g2, float x, float y) {
		Font backup = null;
		if (font != null) {
			backup = g2.getFont();
			g2.setFont(font);
		}
		g2.drawString(string, x, y);
		if (font != null && backup != null) {
			g2.setFont(backup);
		}
	}

	public int getAscent() {
		return frc.g.getFontMetrics(font).getAscent();
	}

	public int getDescent() {
		return frc.g.getFontMetrics(font).getDescent();
	}

	public int getLeading() {
		return frc.g.getFontMetrics(font).getLeading();
	}
}
