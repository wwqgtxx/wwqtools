package net.sf.wwqtools.share;

import org.eclipse.swt.widgets.Text;

public class TextStringSave {
	private Text text = null;
	private String string = null;

	public TextStringSave(Text text, String string) {
		this.setText(text);
		this.setString(string);
	}

	private void setText(Text text) {
		this.text = text;
	}

	public Text getText() {
		return text;
	}

	private void setString(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}
