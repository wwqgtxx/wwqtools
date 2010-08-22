package net.sf.wwqtools.wlog;

import net.sf.wwqtools.main.shell.MainShell;

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
