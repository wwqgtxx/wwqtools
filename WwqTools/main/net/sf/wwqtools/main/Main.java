package net.sf.wwqtools.main;

import net.sf.wlogging.old.PrintName.paint;
import net.sf.wwqtools.main.shell.MainShell;

public class Main implements Runnable {

	public Main() {
	}

	private static String[] args;

	public static void main(String[] args) {
		// paint.warn("AA");
		paint.start();
		new Thread(new Main()).start();
		Main.args = args;
	}

	@Override
	public void run() {
		try {
			paint.warn("AA");
			paint.start();
			MainShell window = new MainShell();
			window.open(args);

		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
