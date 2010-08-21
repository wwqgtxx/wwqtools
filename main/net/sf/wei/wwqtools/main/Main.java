package net.sf.wei.wwqtools.main;

import net.sf.wei.wwqtools.main.shell.MainShell;
import net.sf.wei.wwqtools.wlog.paint.PaintForm;
import net.sf.wei.wwqtools.wlog.paint.PrintName;

public class Main implements Runnable{

	
	public Main() {}
	
	private static PrintName p = new PrintName(Main.class);
	
	private static PaintForm pf = PaintForm.getNewPaintForm();

	private static String[] args;

	public static void main(String[] args) {
	
		new Thread(new Main()).start();
		Main.args=args;
	}


	@Override
	public void run() {
		try {
			PrintName.setPaint(true);
			p.paint("start");
			MainShell window = new MainShell();
			pf.setPaintForm(window);
			window.open(args);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}
