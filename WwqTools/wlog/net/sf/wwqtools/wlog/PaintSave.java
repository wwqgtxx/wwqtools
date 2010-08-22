package net.sf.wwqtools.wlog;

import org.eclipse.swt.custom.StyledText;

public class PaintSave {
	private String s = "";
	private PaintSave() {}
	private final static PaintSave ps = new PaintSave();
	private StyledText txtDebug;
	public void setS(String s) {
		this.s = s;
	}
	public String getS() {
		return s;
	}
	public static PaintSave getPs() {
		return ps;
	}
	public void setTxtDebug(StyledText txtDebug) {
		this.txtDebug = txtDebug;
	}
	public StyledText getTxtDebug() {
		return txtDebug;
	}
	
}
