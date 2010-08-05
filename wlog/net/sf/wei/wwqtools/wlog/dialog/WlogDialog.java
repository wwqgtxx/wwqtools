package net.sf.wei.wwqtools.wlog.dialog;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

public class WlogDialog {
	private Text txtDebug;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void run(String[] args) {
		try {
			WlogDialog window = new WlogDialog();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlDebugWindow = new Shell();
		shlDebugWindow.setSize(450, 300);
		shlDebugWindow.setText("Debug Window");
		
		txtDebug = new Text(shlDebugWindow, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI| SWT.WRAP);
		txtDebug.setText("Debug");
		txtDebug.setBounds(10, 0, 414, 252);

		shlDebugWindow.open();
		shlDebugWindow.layout();
		while (!shlDebugWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void setText(String s) {
		txtDebug.setText(s);
	}
}
