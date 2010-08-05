package net.sf.wei.wwqtools.main.shell;

import net.sf.wei.wwqtools.wlog.dialog.WlogDialog;
import net.sf.wei.wwqtools.wlog.paint.PaintForm;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainShell {

	/**
	 * Launch the application.
	 * @param args
	 */


	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(final String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(459, 397);
		shell.setText("\u738B\u4F1F\u5F3A\u5DE5\u5177\u5305 ");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("New Item");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.setText("New Item");
		
		MenuItem menuItem_2 = new MenuItem(menu, SWT.NONE);
		menuItem_2.setText("New Item");
		
		MenuItem menuItem_3 = new MenuItem(menu, SWT.NONE);
		menuItem_3.setText("New Item");
		
		MenuItem menuItem_4 = new MenuItem(menu, SWT.NONE);
		menuItem_4.setText("New Item");
		
		MenuItem menuItem_5 = new MenuItem(menu, SWT.NONE);
		menuItem_5.setText("New Item");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				net.sf.wei.wwqtools.calculator.Main.open(args);
			}
		});
		button.setBounds(27, 45, 80, 27);
		button.setText("\u8BA1\u7B97\u5668");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				net.sf.wei.wwqtools.pai.PaiShell.show();
			}
		});
		button_1.setBounds(119, 45, 80, 27);
		button_1.setText("\u8BA1\u7B97\u03C0");
		
		Button btnDebug = new Button(shell, SWT.NONE);
		btnDebug.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WlogDialog win = new WlogDialog();
				PaintForm pf = PaintForm.getNewPaintForm();
				pf.setPaintForm(win);
				win.open();						
			}
		});
		btnDebug.setBounds(236, 45, 80, 27);
		btnDebug.setText("Debug");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
