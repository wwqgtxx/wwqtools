package net.sf.wwqtools.sqrt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SqrtShell extends Shell {
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void show(String args[]) {
		try {
			Display display = Display.getDefault();
			SqrtShell shell = new SqrtShell(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public SqrtShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		text = new Text(this, SWT.BORDER);
		text.setText("2");
		text.setBounds(112, 46, 247, 23);
		
		Label label = new Label(this, SWT.NONE);
		label.setBounds(34, 49, 61, 17);
		label.setText("\u6C42\u5E73\u65B9\u6570");
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {SqrtCount.count(text.getText());
			}
		});
		button.setBounds(166, 142, 80, 27);
		button.setText("\u8BA1\u7B97\u5E73\u65B9\u6839");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("\u8BA1\u7B97\u5E73\u65B9\u6839");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
