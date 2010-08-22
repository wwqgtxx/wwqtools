package net.sfi.wwqtools.calculator.about;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

import com.swtdesigner.SWTResourceManager;


public class AboutShell extends Shell {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void show() {
		try {
			Display display = Display.getDefault();
			AboutShell shell = new AboutShell(display);
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
	public AboutShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(AboutShell.class, "/net/sf/wei/calculator/iocs/calc.PNG"));
		setText("\u5173\u4E8E");
		setSize(420, 390);
		setMinimumSize(new Point(123, 32));		
		ImageHyperlink imageHyperlink = formToolkit.createImageHyperlink(getShell(), SWT.NONE);
		imageHyperlink.setImage(SWTResourceManager.getImage(AboutShell.class, "/net/sf/wei/calculator/about/iocs/calcabout.png"));
		imageHyperlink.setBounds(0, 0, 414, 76);
		formToolkit.paintBordersFor(imageHyperlink);
		imageHyperlink.setText("");
		
		ImageHyperlink imageHyperlink_1 = formToolkit.createImageHyperlink(getShell(), SWT.NONE);
		imageHyperlink_1.setImage(SWTResourceManager.getImage(AboutShell.class, "/net/sf/wei/calculator/about/iocs/calc2.PNG"));
		imageHyperlink_1.setBounds(10, 82, 22, 29);
		formToolkit.paintBordersFor(imageHyperlink_1);
		imageHyperlink_1.setText("");
		
		ImageHyperlink imageHyperlink_2 = formToolkit.createImageHyperlink(getShell(), SWT.NONE);
		imageHyperlink_2.setImage(SWTResourceManager.getImage(AboutShell.class, "/net/sf/wei/calculator/about/iocs/calcabout2.png"));
		imageHyperlink_2.setBounds(157, 86, 44, 25);
		formToolkit.paintBordersFor(imageHyperlink_2);
		imageHyperlink_2.setText("");
		
		ImageHyperlink imageHyperlink_3 = formToolkit.createImageHyperlink(getShell(), SWT.NONE);
		imageHyperlink_3.setImage(SWTResourceManager.getImage(AboutShell.class, "/net/sf/wei/calculator/about/iocs/calcabout3.png"));
		imageHyperlink_3.setBounds(48, 196, 356, 88);
		formToolkit.paintBordersFor(imageHyperlink_3);
		imageHyperlink_3.setText("");
		
		ImageHyperlink imageHyperlink_4 = formToolkit.createImageHyperlink(getShell(), SWT.NONE);
		imageHyperlink_4.setImage(SWTResourceManager.getImage(AboutShell.class, "/net/sf/wei/calculator/about/iocs/calcabout4.png"));
		imageHyperlink_4.setBounds(26, 290, 356, 16);
		formToolkit.paintBordersFor(imageHyperlink_4);
		imageHyperlink_4.setText("");
		
		ImageHyperlink imageHyperlink_5 = formToolkit.createImageHyperlink(getShell(), SWT.NONE);
		imageHyperlink_5.setImage(SWTResourceManager.getImage(AboutShell.class, "/net/sf/wei/calculator/about/iocs/calcabout5.png"));
		imageHyperlink_5.setBounds(145, 146, 73, 16);
		formToolkit.paintBordersFor(imageHyperlink_5);
		imageHyperlink_5.setText("");
		
		Label lblV = new Label(getShell(), SWT.NONE);
		lblV.setAlignment(SWT.CENTER);
		lblV.setBounds(157, 324, 44, 12);
		formToolkit.adapt(lblV, true, true);
		lblV.setText("V1.1");
		getShell().setTabList(new Control[]{imageHyperlink, imageHyperlink_1, imageHyperlink_2, imageHyperlink_3, imageHyperlink_4, imageHyperlink_5, lblV});
	}

	/**
	 * Create contents of the shell.
	 */
	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
