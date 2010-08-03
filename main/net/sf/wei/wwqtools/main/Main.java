package net.sf.wei.wwqtools.main;

import net.sf.wei.wwqtools.main.shell.MainShell;
import net.sf.wei.wwqtools.wlog.paint.PrintName;

public class Main {
	
	private static PrintName p = new PrintName(Main.class);


	public static void main(String[] args) {
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
