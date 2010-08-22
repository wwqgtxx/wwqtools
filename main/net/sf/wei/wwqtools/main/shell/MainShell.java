package net.sf.wei.wwqtools.main.shell;

import java.util.ArrayList;
import java.util.List;

import net.sf.wei.wwqtools.wlog.paint.PaintSave;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MainShell {

	private StyledText txtDebug;
	private PaintSave ps = PaintSave.getPs();
	public static Color red;


	
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
		red= display.getSystemColor(SWT.COLOR_RED);
		
		Shell shell = new Shell();
		shell.setSize(715, 554);
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
				net.sf.wei.wwqtools.calculator.Start.open(args);
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
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {System.exit(1);
			}
		});
		button_2.setBounds(586, 172, 80, 27);
		button_2.setText("\u5173\u95ED");
	
		txtDebug = new StyledText(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.READ_ONLY | SWT.WRAP| SWT.MULTI| SWT.H_SCROLL
		        | SWT.V_SCROLL);
		txtDebug.setBounds(10, 210, 679, 276);
		String b = ps.getS(); 
		txtDebug.setText(b);

		ps.setTxtDebug(txtDebug);
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}


	public void setText(String s) {
		txtDebug.setText(s);
	}
}
