package java.awt;

import java.awt.image.BufferedImage;

import elemental2.dom.ImageData;

public class GraphicsConfiguration {

	public static Image createCompatibleImage(int w, int h, int type) {
		Image ret = new BufferedImage(w, h, type);
		/**
		 * @j2sNative var tmp=document.createElement('canvas'); tmp.width=w;
		 *            this.height=h; var dataURL = tmp.toDataURL("image/png");
		 *            ret.img=new Image(); ret.img.src=dataURL;
		 */
		{
		}
		return ret;
	}

	public static void grabPixels(Image img, int sx, int sy, int sw, int sh, int[] target, int off, int scan) {
		BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), 0);
		Graphics gt = image.getGraphics();
		gt.drawImage(img, 0, 0, null); // Now the canvas contains the image.

		// TODO
//		ImageData imageData = gt.ctx.getImageData(0, 0, image.getWidth(), image.getHeight());
//
//		for (int x = sx; x < sx+sw; ++x) {
//			for (int y = sy; y < sy+sh; ++y) {
//				int val=(imageData.getRedAt(x, y)<<16)|(imageData.getGreenAt(x, y)<<8)|(imageData.getBlueAt(x, y))|(imageData.getAlphaAt(x, y)<<24);
//				target[off+(y-sy)*scan+(x-sx)]=val;
//			}
//		}
	}

	public static Image cropImage(Image img, int x, int y, int w, int h) {
		BufferedImage bi=new BufferedImage(w,h,BufferedImage.TYPE_4BYTE_ABGR);
		bi.getGraphics().drawImage(img, -x,-y, null);
		return bi;
	}

	public static Image colorateImage(Image img, int col) {
		int cr = (col >> 16) & 255;
		int cg = (col >> 8) & 255;
		int cb = (col >> 0) & 255;
		BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), 0);
		Graphics gt = image.getGraphics();
		gt.drawImage(img, 0, 0, null); // Now the canvas contains the image.

		ImageData imageData = gt.ctx.getImageData(0, 0, image.getWidth(), image.getHeight());

//		for (int x = 0; x < imageData.width; ++x) {
//			for (int y = 0; y < imageData.height; ++y) {
//				int h = (imageData.getRedAt(x, y) + imageData.data.getGreenAt(x, y) + imageData.getBlueAt(x, y)) / 3;
//				imageData.setRedAt((h * cr) >> 8, x, y);
//				imageData.setGreenAt((h * cg) >> 8, x, y);
//				imageData.setBlueAt((h * cb) >> 8, x, y);
//			}
//		}
		gt.ctx.putImageData(imageData, 0, 0);
		return image;
	}
	public static Image colorateImage(Image img, int col, boolean inv) {
		int cr = (col >> 16) & 255;
		int cg = (col >> 8) & 255;
		int cb = (col >> 0) & 255;
		BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), 0);
		Graphics gt = image.getGraphics();
		gt.drawImage(img, 0, 0, null); // Now the canvas contains the image.

		ImageData imageData = gt.ctx.getImageData(0, 0, image.getWidth(), image.getHeight());

//		for (int x = 0; x < imageData.getWidth(); ++x) {
//			for (int y = 0; y < imageData.getHeight(); ++y) {
//				int h = 255-((imageData.getRedAt(x, y) + imageData.getGreenAt(x, y) + imageData.getBlueAt(x, y)) / 3);
//				imageData.setRedAt((h * cr) >> 8, x, y);
//				imageData.setGreenAt((h * cg) >> 8, x, y);
//				imageData.setBlueAt((h * cb) >> 8, x, y);
//			}
//		}
		gt.ctx.putImageData(imageData, 0, 0);
		return image;
	}

	public static Image brightenImage(Image img, int bright) {
		int modus = 0; // Additiv==0 .. mult==1
		int wot=img.getWidth();
		BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), 0);
		Graphics gt = image.getGraphics();
		gt.drawImage(img, 0, 0, null); // Now the canvas contains the image.

		ImageData imageData = gt.ctx.getImageData(0, 0, image.getWidth(), image.getHeight());

//		for (int x = 0; x < imageData.getWidth(); ++x) {
//			for (int y = 0; y < imageData.getHeight(); ++y) {
//				int r, g, b, a, m;
//
//				// a=(rgb&0xff000000)>>24;
//				r = imageData.getRedAt(x, y);
//				g = imageData.getGreenAt(x, y);
//				b = imageData.getBlueAt(x, y);
//				if (modus == 0) {
//					r = r + bright > 255 ? 255 : r + bright;
//					g = g + bright > 255 ? 255 : g + bright;
//					b = b + bright > 255 ? 255 : b + bright;
//				}
//				if (modus == 1) {
//					r = r * bright > 255 ? 255 : r * bright;
//					g = g * bright > 255 ? 255 : g * bright;
//					b = b * bright > 255 ? 255 : b * bright;
//				}
//				imageData.setRedAt(r, x, y);
//				imageData.setGreenAt(g, x, y);
//				imageData.setBlueAt(b, x, y);
//			}
//		}
		gt.ctx.putImageData(imageData, 0, 0);
		return image;
	}

}
