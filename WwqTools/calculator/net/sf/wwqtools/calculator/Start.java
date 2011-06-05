package net.sf.wwqtools.calculator;

import net.sf.wlogging.old.PrintName.paint;
import net.sf.wwqtools.calculator.form.MainForm;

public class Start {

	public static void open(String[] args) {
		paint.info("start");
		try {
			new MainForm().show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
