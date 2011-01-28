package net.sf.wwqtools.sqrt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class SqrtSave {
	private final static SqrtSave ss = new SqrtSave();

	private SqrtSave() {
	}

	public static SqrtSave getSs() {
		return ss;
	}

	private String text = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getS_i() {
		return s_i;
	}

	public void setS_i(String s_i) {
		this.s_i = s_i;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public void setS_sqrt(String s_sqrt) {
		this.s_sqrt = s_sqrt;
	}

	public String getS_sqrt() {
		return s_sqrt;
	}

	private String s_i = "";
	private boolean ok = false;
	private volatile String s_sqrt = "";

	private String s_n = "";

	private Display display = null;

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Text getText_0() {
		return text_0;
	}

	public void setText_0(Text text_0) {
		this.text_0 = text_0;
	}

	public void setText_00(Text text_00) {
		this.text_00 = text_00;
	}

	public Text getText_00() {
		return text_00;
	}

	public void setS_n(String s_n) {
		this.s_n = s_n;
	}

	public String getS_n() {
		return s_n;
	}

	private Text text_0 = null;
	private Text text_00 = null;

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

	private Thread threadPaint = null;

}
