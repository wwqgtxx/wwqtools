package net.sf.wwqtools.main;

import net.sf.wlogging.PrintName.paint;
import net.sf.wwqtools.main.shell.MainShell;

public class Main implements Runnable {

	public Main() {
	}

	private static String[] args;

	public static void main(String[] args) {
		paint.start();
		new Thread(new Main()).start();
		Main.args = args;
	}

	@Override
	public void run() {
		try {
			paint.start();
			MainShell window = new MainShell();
			window.open(args);

		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
