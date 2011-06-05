package net.sf.wwqtools.share;

import org.eclipse.swt.widgets.Display;

public class SetSWTText {

	public static void setText(Display display,
			final TextStringSave textStringSave) {
		display.asyncExec(new Runnable() {
			public void run() {
				{
					TextStringSave tss = textStringSave;
					tss.getText().setText(tss.getString());
				}
			}
		});
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setText(Display display,
			final TextStringSave textStringSave,
			final TextStringSave textStringSave2) {
		display.asyncExec(new Runnable() {
			public void run() {
				{
					TextStringSave tss = textStringSave;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave2;
					tss.getText().setText(tss.getString());
				}
			}
		});
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setText(Display display,
			final TextStringSave textStringSave,
			final TextStringSave textStringSave2,
			final TextStringSave textStringSave3) {
		display.asyncExec(new Runnable() {
			public void run() {
				{
					TextStringSave tss = textStringSave;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave2;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave3;
					tss.getText().setText(tss.getString());
				}
			}
		});
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setText(Display display,
			final TextStringSave textStringSave,
			final TextStringSave textStringSave2,
			final TextStringSave textStringSave3,
			final TextStringSave textStringSave4) {
		display.asyncExec(new Runnable() {
			public void run() {
				{
					TextStringSave tss = textStringSave;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave2;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave3;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave4;
					tss.getText().setText(tss.getString());
				}
			}
		});
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setText(Display display,
			final TextStringSave textStringSave,
			final TextStringSave textStringSave2,
			final TextStringSave textStringSave3,
			final TextStringSave textStringSave4,
			final TextStringSave textStringSave5) {
		display.asyncExec(new Runnable() {
			public void run() {
				{
					TextStringSave tss = textStringSave;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave2;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave3;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave4;
					tss.getText().setText(tss.getString());
				}
				{
					TextStringSave tss = textStringSave5;
					tss.getText().setText(tss.getString());
				}
			}
		});
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
