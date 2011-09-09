package net.sf.wwqtools.main.shell;

import net.sf.wlogging.LoggerFactory;
import net.sf.wwqtools.datasv.DataCache;
import net.sf.wwqtools.datasv.DataFactory;
import net.sf.wwqtools.system.MySystem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainShell {
	public static Color red;
	private DataCache dataCache = DataFactory.getMyPackageDataCache();

	/**
	 * Open the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void open(final String[] args) {
		LoggerFactory.SHOW_All_MESSAGE_FACTORY.getLogger().start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				open0(args);
			}
		}).start();

	}

	public void open0(final String[] args) {

		Display display = dataCache.newDefaultDisplay();
		red = display.getSystemColor(SWT.COLOR_RED);

		final Shell shell = new Shell();
		shell.setSize(518, 312);
		shell.setText("\u738B\u4F1F\u5F3A\u5DE5\u5177\u5305 ");

		// Menu menu = new Menu(shell, SWT.BAR);
		// shell.setMenuBar(menu);
		//
		// MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		// menuItem.setText("New Item");
		//
		// MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		// menuItem_1.setText("New Item");
		//
		// MenuItem menuItem_2 = new MenuItem(menu, SWT.NONE);
		// menuItem_2.setText("New Item");
		//
		// MenuItem menuItem_3 = new MenuItem(menu, SWT.NONE);
		// menuItem_3.setText("New Item");
		//
		// MenuItem menuItem_4 = new MenuItem(menu, SWT.NONE);
		// menuItem_4.setText("New Item");
		//
		// MenuItem menuItem_5 = new MenuItem(menu, SWT.NONE);
		// menuItem_5.setText("New Item");

		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				net.sf.wwqtools.calculator.CalculatorShell.show(args);
			}
		});
		button.setBounds(27, 45, 80, 27);
		button.setText("\u8BA1\u7B97\u5668");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				net.sf.wwqtools.pai.PaiShell.show(args);
			}
		});
		button_1.setBounds(119, 45, 80, 27);
		button_1.setText("\u8BA1\u7B97\u03C0");

		final Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MySystem.exit(1);
			}
		});
		button_2.setBounds(398, 205, 80, 27);
		button_2.setText("\u5173\u95ED");

		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				net.sf.wwqtools.sqrt.SqrtShell.show(args);
			}
		});
		button_3.setBounds(215, 45, 80, 27);
		button_3.setText("\u8BA1\u7B97\u5E73\u65B9\u6839");

		Button button_4 = new Button(shell, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_4.setText("\u7ED9\u6570\u6392\u5E8F");
		button_4.setBounds(312, 45, 80, 27);

		Button button_5 = new Button(shell, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				net.sf.wwqtools.square.SquareShell.show(args);
			}
		});
		button_5.setBounds(27, 85, 80, 27);
		button_5.setText("\u8BA1\u7B97\u5E73\u65B9\u8868");

		shell.open();
		shell.layout();

		shell.redraw();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}
}
