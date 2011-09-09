package net.sf.wwqtools.calculator;

import java.math.BigInteger;

import net.sf.wlogging.LoggerFactory;
import net.sf.wlogging.old.PrintName.paint;
import net.sf.wwqtools.calculator.count.Count;
import net.sf.wwqtools.datasv.DataCache;
import net.sf.wwqtools.datasv.DataFactory;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.swtdesigner.SWTResourceManager;

public class CalculatorShell extends Shell {
	private static DataCache dataCache = DataFactory.getMyPackageDataCache();
	private Text text;
	private Count c1 = new Count();

	public static void show(final String[] args) {
		LoggerFactory.SHOW_All_MESSAGE_FACTORY.getLogger().start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				show0(args);
			}
		}).start();

	}

	private static void show0(String[] args) {
		try {
			Display display = dataCache.newDefaultDisplay();

			CalculatorShell shell = new CalculatorShell(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CalculatorShell(Display display) {
		super(display, SWT.SHELL_TRIM);

		setSize(286, 351);
		setText("\u8BA1\u7B97\u5668");

		Button b7 = new Button(this, SWT.NONE);
		b7.setText("7");
		b7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b7();
			}
		});
		b7.setBounds(10, 67, 43, 39);

		Button b8 = new Button(this, SWT.NONE);
		b8.setText("8");
		b8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b8();
			}
		});
		b8.setBounds(69, 65, 43, 42);

		Button b9 = new Button(this, SWT.NONE);
		b9.setText("9");
		b9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b9();
			}
		});
		b9.setBounds(124, 64, 43, 44);

		Button b4 = new Button(this, SWT.NONE);
		b4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b4();
			}
		});
		b4.setBounds(10, 112, 43, 39);
		b4.setText("4");

		Button b5 = new Button(this, SWT.NONE);
		b5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b5();
			}
		});
		b5.setBounds(69, 113, 43, 39);
		b5.setText("5");

		Button b6 = new Button(this, SWT.NONE);
		b6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b6();
			}
		});
		b6.setBounds(124, 114, 43, 39);
		b6.setText("6");

		Button b1 = new Button(this, SWT.NONE);
		b1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b1();
			}
		});
		b1.setBounds(10, 157, 43, 39);
		b1.setText("1");

		Button b2 = new Button(this, SWT.NONE);
		b2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b2();
			}
		});
		b2.setBounds(69, 158, 43, 39);
		b2.setText("2");

		Button b3 = new Button(this, SWT.NONE);
		b3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b3();
			}
		});
		b3.setBounds(124, 157, 43, 39);
		b3.setText("3");

		Button b0 = new Button(this, SWT.NONE);
		b0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b0();
			}
		});
		b0.setBounds(10, 202, 43, 39);
		b0.setText("0");

		Button button_10 = new Button(this, SWT.NONE);
		button_10.setBounds(69, 202, 43, 39);
		button_10.setText("New Button");

		Button bdot = new Button(this, SWT.NONE);
		bdot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bdot();
			}
		});
		bdot.setBounds(124, 202, 43, 39);
		bdot.setText(".");

		text = new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.RIGHT);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textkeyPressed(e);
			}

		});

		text.setBounds(10, 10, 258, 23);

		Button bCE = new Button(this, SWT.NONE);
		bCE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bCE();
			}
		});
		bCE.setBounds(10, 39, 72, 22);
		bCE.setText("CE");

		Button bv = new Button(this, SWT.NONE);
		bv.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bv();
			}

		});
		bv.setBounds(107, 39, 60, 22);
		bv.setText("\u2192");

		Button bplus = new Button(this, SWT.NONE);
		bplus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bplus();
			}
		});
		bplus.setBounds(189, 67, 30, 84);
		bplus.setText("+");

		Button bsubtract = new Button(this, SWT.NONE);
		bsubtract.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bsubtract();
			}
		});
		bsubtract.setBounds(189, 157, 30, 84);
		bsubtract.setText("-");

		Button bride = new Button(this, SWT.NONE);
		bride.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bride();
			}
		});
		bride.setBounds(225, 67, 30, 84);
		bride.setText("\u00D7");

		Button beliminate = new Button(this, SWT.NONE);
		beliminate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				beliminate();
			}
		});
		beliminate.setBounds(225, 157, 30, 84);
		beliminate.setText("\u00F7");

		Button bequrs = new Button(this, SWT.NONE);
		bequrs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bequrs();
			}
		});
		bequrs.setBounds(189, 39, 66, 22);
		bequrs.setText("=");

		Label label = new Label(this, SWT.NONE);
		label.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label.setBounds(10, 263, 245, 40);
		label.setText("\u738B\u4F1F\u5F3A\u5236\u4F5C  1.1\u7248     \u7248\u6743\u6240\u6709 \u00A92009-2011");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private void sh(BigInteger n) {
		BigInteger i = n;
		text.setText(i.toString());
		paint.debug(c1.returnNumber());
	}

	private void add(long n) {
		Long N = n;
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

	private void textkeyPressed(KeyEvent e) {
		int key = e.keyCode;
		// p.paint(key);
		switch (key) {
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
