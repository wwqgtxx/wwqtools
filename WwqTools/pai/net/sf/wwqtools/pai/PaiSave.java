package net.sf.wwqtools.pai;

import java.math.BigDecimal;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class PaiSave {
	private PaiSave() {
	}

	public static PaiSave getPs() {
		return ps;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getS() {
		return s;
	}

	private static PaiSave ps = new PaiSave();
	private Integer count;
	private String s;

	public BigDecimal pie = new BigDecimal("3.14");

	public BigDecimal getPie() {
		return pie;
	}

	public void setPie(BigDecimal pie) {
		this.pie = pie;
	}

	public void setText_1(StyledText text_1) {
		this.text_1 = text_1;
	}

	public StyledText getText_1() {
		return text_1;
	}

	public void setText_11(Text text_11) {
		this.text_11 = text_11;
	}

	public Text getText_11() {
		return text_11;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Display getDisplay() {
		return display;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}

	private StyledText text_1;

	private Text text_11;

	private Display display;

	private boolean ok = false;

	private Thread thread = null;

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Thread getThreadPaint() {
		return threadPaint;
	}

	public void setThreadPaint(Thread threadPaint) {
		this.threadPaint = threadPaint;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getB() {
		return b;
	}

	private Thread threadPaint = null;

	private int b;
}
