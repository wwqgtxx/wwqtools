package net.sf.wwqtools.sqrt;

import net.sf.wlogging.LoggerFactory;
import net.sf.wwqtools.datasv.DataCache;
import net.sf.wwqtools.datasv.DataFactory;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SqrtShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_0;
	private static DataCache dataCache = DataFactory.getMyPackageDataCache();
	// private static SqrtSave ss = SqrtSave.getSs();
	private Text text_00;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	public static void show(final String[] args) {
		LoggerFactory.SHOW_All_MESSAGE_FACTORY.getLogger().start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				show0(args);
			}
		}).start();
	}

	public static void show0(String args[]) {
		try {
			Display display = dataCache.newDefaultDisplay();
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
	 * 
	 * @param display
	 */
	public SqrtShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		addShellListener(new ShellAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void shellClosed(ShellEvent e) {
				if (dataCache.getThread("thread") != null
						&& dataCache.getThread("threadPaint") != null) {
					if ((dataCache.getThread("thread")).isAlive()
							&& (dataCache.getThread("threadPaint")).isAlive()) {
						(dataCache.getThread("thread")).stop();
						(dataCache.getThread("threadPaint")).stop();

					}
				}

			}
		});

		text = new Text(this, SWT.BORDER);
		text.setText("2");
		text.setBounds(112, 46, 247, 23);

		Label label = new Label(this, SWT.NONE);
		label.setBounds(34, 49, 61, 17);
		label.setText("\u6C42\u5E73\u65B9\u6570");

		text_0 = new Text(this, SWT.BORDER | SWT.FULL_SELECTION | SWT.READ_ONLY
				| SWT.WRAP | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		text_0.setText("\u7ED3\u679C");
		text_0.setBounds(10, 175, 414, 84);
		text_00 = new Text(this, SWT.BORDER | SWT.READ_ONLY);
		text_00.setText("\u4F4D\u6570");
		text_00.setBounds(11, 265, 132, 23);

		dataCache.put("text_0", text_0);
		dataCache.put("text_00", text_00);

		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// try {
				// Integer.parseInt(text.getText());
				// Integer.parseInt(text_1.getText());
				// } catch (NumberFormatException e1) {
				// text_0.setText("数字多过大无法计算，最大只能为：" + Integer.MAX_VALUE);
				// return;
				// }

				Thread thread = new Thread(new SqrtCount(text.getText(), text_1
						.getText()));
				Thread threadPaint = new Thread(
						new SqrtCount().new PaintResult());

				dataCache.put("thread", thread);
				dataCache.put("threadPaint", threadPaint);
				dataCache.put("ok", false);

				thread.setDaemon(true);
				thread.start();
				thread.setPriority(Thread.MIN_PRIORITY);

				threadPaint.setDaemon(true);
				threadPaint.start();
				threadPaint.setPriority(Thread.MIN_PRIORITY);

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

		Label label_2 = new Label(this, SWT.CENTER);
		label_2.setBounds(149, 268, 275, 17);
		label_2.setText("\u8BA1\u7B97\u8FC7\u7A0B\u4E2D\u7A0B\u5E8F\u7ED3\u679C\u4E09\u79D2\u949F\u5237\u65B0\u4E00\u6B21\uFF0C\u656C\u8BF7\u7B49\u5F85");

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
