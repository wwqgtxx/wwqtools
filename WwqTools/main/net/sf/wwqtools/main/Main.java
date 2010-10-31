package net.sf.wwqtools.main;

import net.sf.wwqtools.main.shell.MainShell;
import net.sf.wwqtools.wlog.PrintName;

public class Main implements Runnable{

	
	public Main() {}
	
	private static PrintName p = new PrintName(Main.class);
	

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
			window.open(args);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}
