package net.sf.wwqtools.square;

import java.math.BigDecimal;

import net.sf.wlogging.PrintName;
import net.sf.wwqtools.pai.PaiCount;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.swtdesigner.SWTResourceManager;

public class SquareShell extends Shell {
	private static PrintName p = new PrintName(SquareShell.class);
	private PaiCount c = new PaiCount();
	private Text text;
	private StyledText text_1;
	private Text txtDpaitxt;
	private Text txtPaitxt;

	/**
	 * Launch the application.
	 * @param args
	 */
	

	public static void show() {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					Display display = Display.getDefault();
					SquareShell shell = new SquareShell(display);
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
	 * @param display
	 */
	public SquareShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		c.setPie(new BigDecimal("3.14"));
		

		txtDpaitxt = new Text(this, SWT.BORDER);
		txtDpaitxt.setText("d:\\\\pai\\");
		txtDpaitxt.setBounds(84, 387, 236, 23);
		
		txtPaitxt = new Text(this, SWT.BORDER);
		txtPaitxt.setText("square.txt");
		txtPaitxt.setBounds(326, 387, 107, 23);
		
		c.setPath(txtDpaitxt.getText(),txtPaitxt.getText());
		
		text = new Text(this, SWT.BORDER);
		text.setText("50");
		text.setBounds(262, 30, 78, 23);
		
		c.setPie(new BigDecimal("3.14"));
		
		Label label = new Label(this, SWT.CENTER);
		label.setFont(SWTResourceManager.getFont("ËÎÌו", 12, SWT.NORMAL));
		label.setBounds(364, 32, 55, 18);
		label.setText("\u6B21");
		
		text_1 = new StyledText(this, SWT.BORDER | SWT.FULL_SELECTION | SWT.READ_ONLY | SWT.WRAP| SWT.MULTI| SWT.H_SCROLL
		        | SWT.V_SCROLL);
		text_1.setBounds(10, 10, 185, 324);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_1.setBounds(262, 108, 58, 33);
		button_1.setText("\u5E73\u65B9");
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_2.setBounds(361, 108, 58, 33);
		button_2.setText("\u7ACB\u65B9");
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_3.setBounds(308, 170, 58, 33);
		button_3.setText("4\u6B21\u65B9");
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_4.setBounds(250, 229, 70, 49);
		button_4.setText("\u5E73\u65B9\u6839");
		
		Button button_5 = new Button(this, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_5.setBounds(358, 229, 75, 49);
		button_5.setText("\u7ACB\u65B9\u6839");
		
		Label label_1 = new Label(this, SWT.BORDER | SWT.WRAP | SWT.HORIZONTAL | SWT.CENTER);
		label_1.setBounds(221, 10, 19, 324);
		label_1.setText("\u8BA1\u7B97\u8FC7\u7A0B\u4E2D\u7A0B\u5E8F\u4F1A\u7528\u5047\u6B7B\u73B0\u8C61\uFF0C\u656C\u8BF7\u8C05\u89E3\u3002");
		
		Label label_2 = new Label(this, SWT.HORIZONTAL | SWT.CENTER);
		label_2.setBounds(10, 390, 73, 23);
		label_2.setText("\u6587\u4EF6\u4F4D\u7F6E");
		
		
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setBounds(150, 354, 61, 17);
		label_3.setText("\u5730\u5740");
		
		Label label_4 = new Label(this, SWT.NONE);
		label_4.setBounds(358, 354, 61, 17);
		label_4.setText("\u6587\u4EF6\u540D");
		createContents();
		
		
	}


	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("\u8BA1\u7B97\u5E73\u65B9\u8868");
		setSize(500, 461);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	

}
