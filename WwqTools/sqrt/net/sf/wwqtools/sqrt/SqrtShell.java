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
	private Text text_1;
	private Text text_o;

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
			public void widgetSelected(SelectionEvent e) {text_o.setText(SqrtCount.count(text.getText(),text_1.getText()));
			}
		});
		button.setBounds(166, 133, 80, 27);
		button.setText("\u8BA1\u7B97\u5E73\u65B9\u6839");
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setText("20");
		text_1.setBounds(112, 84, 247, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBounds(34, 87, 50, 17);
		label_1.setText("\u7CBE\u786E\u5EA6");
		
		text_o = new Text(this,  SWT.BORDER | SWT.FULL_SELECTION | SWT.READ_ONLY | SWT.WRAP| SWT.MULTI| SWT.H_SCROLL
		        | SWT.V_SCROLL);
		text_o.setBounds(10, 175, 414, 84);
		
		Label label_2 = new Label(this, SWT.CENTER);
		label_2.setBounds(10, 265, 414, 17);
		label_2.setText("\u8BA1\u7B97\u8FC7\u7A0B\u4E2D\u7A0B\u5E8F\u4F1A\u7528\u5047\u6B7B\u73B0\u8C61\uFF0C\u656C\u8BF7\u8C05\u89E3\u3002");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("\u8BA1\u7B97\u5E73\u65B9\u6839");
		setSize(450, 330);

	}

	@Override
	protected void checkSubclass() {
		
	}
}
