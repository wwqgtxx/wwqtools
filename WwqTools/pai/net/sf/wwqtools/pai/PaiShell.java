package net.sf.wwqtools.pai;

import java.math.BigDecimal;

import net.sf.wwqtools.wlog.PrintName;

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
 
public class PaiShell extends Shell{
	private static PrintName p = new PrintName(PaiShell.class);
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
	 * @param display
	 */
	public PaiShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		c.setPie(new BigDecimal("3.14"));
		

		txtDpaitxt = new Text(this, SWT.BORDER);
		txtDpaitxt.setText("d:\\\\pai\\");
		txtDpaitxt.setBounds(78, 299, 236, 23);
		
		txtPaitxt = new Text(this, SWT.BORDER);
		txtPaitxt.setText("pai.txt");
		txtPaitxt.setBounds(320, 299, 107, 23);
		
		c.setPath(txtDpaitxt.getText(),txtPaitxt.getText());
		
		text = new Text(this, SWT.BORDER);
		text.setText("50");
		text.setBounds(250, 30, 70, 18);
		
		c.setPie(new BigDecimal("3.14"));
		
		Label label = new Label(this, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("ËÎÌו", 12, SWT.NORMAL));
		label.setBounds(326, 30, 39, 18);
		label.setText("\u6B21\u03C0");
		
		text_1 = new StyledText(this, SWT.BORDER | SWT.FULL_SELECTION | SWT.READ_ONLY | SWT.WRAP| SWT.MULTI| SWT.H_SCROLL
		        | SWT.V_SCROLL);
		text_1.setBounds(10, 10, 185, 246);
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {start();
			}

		});
		button.setBounds(270, 234, 72, 22);
		button.setText("\u8BA1\u7B97");
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3");
			}
		});
		button_1.setBounds(250, 54, 39, 22);
		button_1.setText("3");
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3.1");
			}
		});
		button_2.setBounds(292, 54, 39, 22);
		button_2.setText("3.1");
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3.14");
			}
		});
		button_3.setBounds(336, 54, 39, 22);
		button_3.setText("3.14");
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3.142");
			}
		});
		button_4.setBounds(250, 82, 39, 22);
		button_4.setText("3.142");
		
		Button button_5 = new Button(this, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3.1416");
			}
		});
		button_5.setBounds(292, 82, 50, 22);
		button_5.setText("3.1416");
		
		Button button_6 = new Button(this, SWT.NONE);
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3.14159");
			}
		});
		button_6.setBounds(250, 110, 54, 22);
		button_6.setText("3.14159");
		
		Button button_7 = new Button(this, SWT.NONE);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3.141593");
			}
		});
		button_7.setBounds(311, 110, 64, 22);
		button_7.setText("3.141593");
		
		Button button_8 = new Button(this, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3.1415927");
			}
		});
		button_8.setBounds(250, 138, 64, 22);
		button_8.setText("3.1415927");
		
		Button button_9 = new Button(this, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3.14159265");
			}
		});
		button_9.setBounds(250, 166, 70, 22);
		button_9.setText("3.14159265");
		
		Button button_10 = new Button(this, SWT.NONE);
		button_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPie("3.141592653");
			}
		});
		button_10.setBounds(250, 193, 81, 22);
		button_10.setText("3.141592653");
		
		Label label_1 = new Label(this, SWT.BORDER | SWT.WRAP | SWT.HORIZONTAL | SWT.CENTER);
		label_1.setBounds(221, 54, 19, 202);
		label_1.setText("   \u03C0\u7B49\u4E8E         \u9ED8\u8BA4\u4E3A3.14  ");
		
		
		Button button_11 = new Button(this, SWT.NONE);
		button_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {c.setPath(txtDpaitxt.getText(),txtPaitxt.getText());
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
		c.setPath(txtDpaitxt.getText(),txtPaitxt.getText());
		String s = text.getText();
		Integer i = Integer.parseInt(s);
		p.paint(s);
		p.paint(i);
		c.count(i);
		String s2 = c.getS();
		text_1.setText(s2);
	}
	
	private String setPie(String pie) {
		c.setPie(new BigDecimal(pie));
		p.paint(pie);
		return pie;
	}
}
