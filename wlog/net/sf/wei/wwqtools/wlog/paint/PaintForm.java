package net.sf.wei.wwqtools.wlog.paint;

import net.sf.wei.wwqtools.wlog.dialog.WlogDialog;

public class PaintForm {
	private PaintForm() {}
	
	private static PaintForm pf = new PaintForm();
	private WlogDialog w ;
	
	public static PaintForm getNewPaintForm () {
		return pf;
	}
	
	public void setPaintForm (WlogDialog w) {
		this.w = w;
	}
	public WlogDialog getPaintForm () {
		return w;
	}
}
