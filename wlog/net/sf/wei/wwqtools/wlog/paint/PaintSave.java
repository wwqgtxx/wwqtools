package net.sf.wei.wwqtools.wlog.paint;

public class PaintSave {
	private String s = "";
	private PaintSave() {}
	private final static PaintSave ps = new PaintSave();
	public void setS(String s) {
		this.s = s;
	}
	public String getS() {
		return s;
	}
	public static PaintSave getPs() {
		return ps;
	}
	
}
