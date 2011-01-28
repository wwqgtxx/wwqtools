package net.sf.wwqtools.calculator.form;

import java.math.BigInteger;

import net.sf.wlogging.PrintName;
import net.sf.wwqtools.calculator.about.AboutShell;
import net.sf.wwqtools.calculator.count.Count;
import net.sf.wwqtools.pai.PaiShell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.swtdesigner.SWTResourceManager;

public class MainForm { 
	private FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private static PrintName p = new PrintName(MainForm.class);
	private Display display = Display.getDefault();
	private Shell shlCalculator = new Shell();
	private Text text;
	private Count c1= new Count();
	
	
	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPolong
	 * @wbp.parser.entryPoint
	 */
	public void show() {
		shlCalculator.setImage(SWTResourceManager.getImage(MainForm.class, "/net/sf/wwqtools/calculator/about/iocs/calc.PNG"));
		
		shlCalculator.setSize(286, 351);
		shlCalculator.setText("\u8BA1\u7B97\u5668");
		
		Menu menu = new Menu(shlCalculator, SWT.BAR);
		shlCalculator.setMenuBar(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("New SubMenu");
		
		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.CASCADE);
		menuItem_1.setText("\u5C0F\u5DE5\u5177");
		
		Menu menu_2 = new Menu(menuItem_1);
		menuItem_1.setMenu(menu_2);
		
		MenuItem menuItem_2 = new MenuItem(menu_2, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {PaiShell.show();
			}
		});
		menuItem_2.setText("\u5C0F\u5DE5\u5177-\u8BA1\u7B97\u03C0");
		
		MenuItem mntmh = new MenuItem(menu, SWT.CASCADE);
		mntmh.setText("\u5E2E\u52A9(&H)");
		
		Menu menu_4 = new Menu(mntmh);
		mntmh.setMenu(menu_4);
		
		MenuItem menuItem_3 = new MenuItem(menu_4, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {nabout();
			}
		});
		menuItem_3.setText("\u5173\u4E8E");
		
		Button b7 = formToolkit.createButton(shlCalculator, "7", SWT.NONE);
		b7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b7();
			}
		});
		b7.setBounds(10, 67, 43, 39);
		
		Button b8 = formToolkit.createButton(shlCalculator, "8", SWT.NONE);
		b8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b8();
			}
		});
		b8.setBounds(69, 65, 43, 42);
		
		Button b9 = formToolkit.createButton(shlCalculator, "9", SWT.NONE);
		b9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b9();
			}
		});
		b9.setBounds(124, 64, 43, 44);
		
		Button b4 = new Button(shlCalculator, SWT.NONE);
		b4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b4();
			}
		});
		b4.setBounds(10, 112, 43, 39);
		formToolkit.adapt(b4, true, true);
		b4.setText("4");
		
		Button b5 = new Button(shlCalculator, SWT.NONE);
		b5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b5();
			}
		});
		b5.setBounds(69, 113, 43, 39);
		b5.setText("5");
		formToolkit.adapt(b5, true, true);
		
		Button b6 = new Button(shlCalculator, SWT.NONE);
		b6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b6();
			}
		});
		b6.setBounds(124, 114, 43, 39);
		b6.setText("6");
		formToolkit.adapt(b6, true, true);
		
		Button b1 = new Button(shlCalculator, SWT.NONE);
		b1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b1();
			}
		});
		b1.setBounds(10, 157, 43, 39);
		b1.setText("1");
		formToolkit.adapt(b1, true, true);
		
		Button b2 = new Button(shlCalculator, SWT.NONE);
		b2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b2();
			}
		});
		b2.setBounds(69, 158, 43, 39);
		b2.setText("2");
		formToolkit.adapt(b2, true, true);
		
		Button b3 = new Button(shlCalculator, SWT.NONE);
		b3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b3();
			}
		});
		b3.setBounds(124, 157, 43, 39);
		b3.setText("3");
		formToolkit.adapt(b3, true, true);
		
		Button b0 = new Button(shlCalculator, SWT.NONE);
		b0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {b0();
			}
		});
		b0.setBounds(10, 202, 43, 39);
		b0.setText("0");
		formToolkit.adapt(b0, true, true);
		
		Button button_10 = new Button(shlCalculator, SWT.NONE);
		button_10.setBounds(69, 202, 43, 39);
		button_10.setText("New Button");
		formToolkit.adapt(button_10, true, true);
		
		Button bdot = new Button(shlCalculator, SWT.NONE);
		bdot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bdot();
			}
		});
		bdot.setBounds(124, 202, 43, 39);
		bdot.setText(".");
		formToolkit.adapt(bdot, true, true);
		
		text = formToolkit.createText(shlCalculator, "", SWT.READ_ONLY | SWT.RIGHT);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {textkeyPressed(e);
			}

		});
		
		text.setBounds(10, 10, 258, 23);
		
		Button bCE = new Button(shlCalculator, SWT.NONE);
		bCE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {bCE();
			}
		});
		bCE.setBounds(10, 39, 72, 22);
		formToolkit.adapt(bCE, true, true);
		bCE.setText("CE");
		
		Button bv = new Button(shlCalculator, SWT.NONE);
		bv.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {bv();
			}

		});
		bv.setBounds(107, 39, 60, 22);
		bv.setText("\u2192");
		formToolkit.adapt(bv, true, true);
		
		Button bplus = new Button(shlCalculator, SWT.NONE);
		bplus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {bplus();
			}
		});
		bplus.setBounds(189, 67, 30, 84);
		bplus.setText("+");
		formToolkit.adapt(bplus, true, true);
		
		Button bsubtract = new Button(shlCalculator, SWT.NONE);
		bsubtract.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {bsubtract();
			}
		});
		bsubtract.setBounds(189, 157, 30, 84);
		bsubtract.setText("-");
		formToolkit.adapt(bsubtract, true, true);
		
		Button bride = new Button(shlCalculator, SWT.NONE);
		bride.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {bride();
			}
		});
		bride.setBounds(225, 67, 30, 84);
		bride.setText("\u00D7");
		formToolkit.adapt(bride, true, true);
		
		Button beliminate = new Button(shlCalculator, SWT.NONE);
		beliminate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {beliminate();
			}
		});
		beliminate.setBounds(225, 157, 30, 84);
		beliminate.setText("\u00F7");
		formToolkit.adapt(beliminate, true, true);
		
		Button bequrs = new Button(shlCalculator, SWT.NONE);
		bequrs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {bequrs();
			}
		});
		bequrs.setBounds(189, 39, 66, 22);
		bequrs.setText("=");
		formToolkit.adapt(bequrs, true, true);
		
		Label label = new Label(shlCalculator, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label.setBounds(10, 263, 245, 12);
		formToolkit.adapt(label, true, true);
		label.setText("\u738B\u4F1F\u5F3A\u5236\u4F5C  1.1\u7248     \u7248\u6743\u6240\u6709 \u00A92009-2010");

		shlCalculator.open();
		shlCalculator.layout();

		
		
		while (!shlCalculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void sh(BigInteger n) {
		BigInteger i = n;
		text.setText(i.toString());
		p.paint(c1.returnNumber());
	}

	private void add(long n) {
		Long N =n;
		BigInteger l = new BigInteger(N.toString());
		sh(c1.addNumber(l));
	}
	
	private void b1() {	
		add(1L);
	}
	private void b2() {
		add(2L);
	}
	private void b3() {
		add(3L);		
	}
	private void b4() {
		add(4L);
	}
	private void b5() {
		add(5L);
	}
	private void b6() {
		add(6L);	
	}
	private void b7() {
		add(7L);
	}
	private void b8() {
		add(8L);	
	}
	private void b9() {
		add(9L);		
	}
	private void b0() {
		add(0L);	
	}
	private void bdot() {
		
	}
	private void bCE() {	
		sh(c1.removeAllNumber());
	}
	private void bv() {
		sh(c1.deleteNumber());
	}	
	private void beliminate() {
		sh(c1.eliminate());
	}
	private void bride() {
		sh(c1.ride());
	}
	private void bsubtract() {
		sh(c1.subtract());
	}
	private void bplus() {
		sh(c1.plus());
	}
	private void bequrs() {
		sh(c1.equrs());
	}
	private void nabout() {
		AboutShell.show();		
	}
	
	private void textkeyPressed(KeyEvent e) {
		int key = e.keyCode;
		//p.paint(key);
		switch(key) {
		case SWT.KEYPAD_1:
			b1();
			break;
		case SWT.KEYPAD_2:
			b2();
			break;
		case SWT.KEYPAD_3:
			b3();
			break;
		case SWT.KEYPAD_4:
			b4();
			break;
		case SWT.KEYPAD_5:
			b5();
			break;
		case SWT.KEYPAD_6:
			b6();
			break;
		case SWT.KEYPAD_7:
			b7();
			break;
		case SWT.KEYPAD_8:
			b8();
			break;
		case SWT.KEYPAD_9:
			b9();
			break;
		case SWT.KEYPAD_0:
			b0();
			break;
		case SWT.KEYPAD_ADD:
			bplus();
			break;
		case SWT.KEYPAD_EQUAL:
			System.out.println("=");
			bequrs();
			break;
		case SWT.KEYPAD_SUBTRACT:
			bsubtract();
			break;
		case SWT.KEYPAD_DECIMAL:
			bequrs();
			break;
		case SWT.KEYPAD_MULTIPLY:
			bride();
			break;
		case SWT.KEYPAD_DIVIDE:
			beliminate();
			break;
		
		}
	}
}
