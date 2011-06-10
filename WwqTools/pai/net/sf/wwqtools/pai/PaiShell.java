package net.sf.wwqtools.pai;

import java.math.BigDecimal;

import net.sf.wlogging.old.PrintName.paint;
import net.sf.wwqtools.datasv.DataCache;
import net.sf.wwqtools.datasv.DataFactory;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.swtdesigner.SWTResourceManager;

public class PaiShell extends Shell {
	private static DataCache dc = DataFactory.getMyPackageDataCache();
	private PaiCount c = new PaiCount();
	private Text text;
	private StyledText text_1;
	private Text txtDpaitxt;
	private Text txtPaitxt;
	private Text text_11;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	public static void show() {
		paint.start();
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					Display display = Display.getDefault();
					PaiShell shell = new PaiShell(display);
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
		});
	}

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public PaiShell(Display display) {
		super(display, SWT.SHELL_TRIM);

		addShellListener(new ShellAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void shellClosed(ShellEvent e) {
				if (dc.getThread("thread") != null
						&& dc.getThread("threadPaint") != null) {
					if ((dc.getThread("thread")).isAlive()
							&& (dc.getThread("threadPaint")).isAlive()) {
						(dc.getThread("thread")).stop();
						(dc.getThread("threadPaint")).stop();

					}
				}
				dc.set("s", "(is clean)");

			}
		});

		dc.put("display", display);

		c.setPie(new BigDecimal("3.14"));

		txtDpaitxt = new Text(this, SWT.BORDER);
		txtDpaitxt.setText("d:\\\\pai\\");
		txtDpaitxt.setBounds(78, 299, 236, 23);

		txtPaitxt = new Text(this, SWT.BORDER);
		txtPaitxt.setText("pai.txt");
		txtPaitxt.setBounds(320, 299, 107, 23);

		c.setPath(txtDpaitxt.getText(), txtPaitxt.getText());

		text = new Text(this, SWT.BORDER);
		text.setText("50");
		text.setBounds(250, 30, 70, 18);

		c.setPie(new BigDecimal("3.14"));

		Label label = new Label(this, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("宋体", 12, SWT.NORMAL));
		label.setBounds(326, 30, 39, 18);
		label.setText("\u6B21\u03C0");

		text_1 = new StyledText(this, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.READ_ONLY | SWT.WRAP | SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		text_1.setBounds(10, 10, 185, 246);

		text_11 = new Text(this, SWT.BORDER);
		text_11.setBounds(10, 262, 73, 23);

		dc.put("text_1", text_1);
		dc.put("text_11", text_11);

		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				start();
			}

		});
		button.setBounds(270, 234, 72, 22);
		button.setText("\u8BA1\u7B97");

		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3");
			}
		});
		button_1.setBounds(250, 54, 39, 22);
		button_1.setText("3");

		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3.1");
			}
		});
		button_2.setBounds(292, 54, 39, 22);
		button_2.setText("3.1");

		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3.14");
			}
		});
		button_3.setBounds(336, 54, 39, 22);
		button_3.setText("3.14");

		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3.142");
			}
		});
		button_4.setBounds(250, 82, 39, 22);
		button_4.setText("3.142");

		Button button_5 = new Button(this, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3.1416");
			}
		});
		button_5.setBounds(292, 82, 50, 22);
		button_5.setText("3.1416");

		Button button_6 = new Button(this, SWT.NONE);
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3.14159");
			}
		});
		button_6.setBounds(250, 110, 54, 22);
		button_6.setText("3.14159");

		Button button_7 = new Button(this, SWT.NONE);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3.141593");
			}
		});
		button_7.setBounds(311, 110, 64, 22);
		button_7.setText("3.141593");

		Button button_8 = new Button(this, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3.1415927");
			}
		});
		button_8.setBounds(250, 138, 64, 22);
		button_8.setText("3.1415927");

		Button button_9 = new Button(this, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3.14159265");
			}
		});
		button_9.setBounds(250, 166, 70, 22);
		button_9.setText("3.14159265");

		Button button_10 = new Button(this, SWT.NONE);
		button_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPie("3.141592653");
			}
		});
		button_10.setBounds(250, 193, 81, 22);
		button_10.setText("3.141592653");

		Label label_1 = new Label(this, SWT.BORDER | SWT.WRAP | SWT.HORIZONTAL
				| SWT.CENTER);
		label_1.setBounds(221, 54, 19, 202);
		label_1.setText("   \u03C0\u7B49\u4E8E         \u9ED8\u8BA4\u4E3A3.14  ");

		Button button_11 = new Button(this, SWT.NONE);
		button_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				c.setPath(txtDpaitxt.getText(), txtPaitxt.getText());
			}
		});
		button_11.setBounds(358, 234, 80, 27);
		button_11.setText("\u8BBE\u7F6E\u4F4D\u7F6E");

		Label label_2 = new Label(this, SWT.HORIZONTAL | SWT.CENTER);
		label_2.setBounds(10, 302, 73, 23);
		label_2.setText("\u6587\u4EF6\u4F4D\u7F6E");

		Label label_3 = new Label(this, SWT.NONE);
		label_3.setBounds(148, 276, 61, 17);
		label_3.setText("\u5730\u5740");

		Label label_4 = new Label(this, SWT.NONE);
		label_4.setBounds(338, 276, 61, 17);
		label_4.setText("\u6587\u4EF6\u540D");

		Label label_5 = new Label(this, SWT.CENTER);
		label_5.setBounds(111, 330, 275, 17);
		label_5.setText("\u8BA1\u7B97\u8FC7\u7A0B\u4E2D\u7A0B\u5E8F\u7ED3\u679C\u4E09\u79D2\u949F\u5237\u65B0\u4E00\u6B21\uFF0C\u656C\u8BF7\u7B49\u5F85");

		createContents();

	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("\u5C0F\u5DE5\u5177-\u8BA1\u7B97\u03C0");
		setSize(500, 395);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private void start() {
		c.setPath(txtDpaitxt.getText(), txtPaitxt.getText());
		String s = text.getText();
		try {
			Integer i = Integer.parseInt(s);
			paint.debug(s);
			paint.debug(i);

			dc.put("count", i);
			Thread thread = new Thread(new PaiCount());
			thread.setDaemon(true);
			thread.setPriority(Thread.MIN_PRIORITY);
			thread.start();
			dc.put("thread", thread);

			Thread threadPaint = new Thread(new PaiCount().new PaintResult());
			threadPaint.setDaemon(true);
			threadPaint.start();
			threadPaint.setPriority(Thread.MIN_PRIORITY);
			dc.put("threadPaint", threadPaint);
		} catch (java.lang.NumberFormatException e) {
			text_1.setText("超出运算范围，最大" + Integer.MAX_VALUE);
		}

	}

	private String setPie(String pie) {
		c.setPie(new BigDecimal(pie));
		paint.debug(pie);
		return pie;
	}
}
