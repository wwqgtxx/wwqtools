package net.sf.wei.wwqtools.wlog.paint;

import net.sf.wei.wwqtools.main.shell.MainShell;

public class PaintForm {
	private PaintForm() {}
	
	private static PaintForm pf = new PaintForm();
	private MainShell w ;
	
	public static PaintForm getNewPaintForm () {
		return pf;
	}
	
	public void setPaintForm (MainShell w) {
		this.w = w;
	}
	public MainShell getPaintForm () {
		return w;
	}
}
