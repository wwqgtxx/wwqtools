package net.sf.wei.wwqtools.calculator;

import net.sf.wei.wwqtools.calculator.form.MainForm;
import net.sf.wei.wwqtools.wlog.paint.PrintName;

public class Start{

	private static PrintName p = new PrintName(Start.class);
	
	public static void open(String[] args) {
		p.paint("start");	
		try {
			new MainForm().show();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


} 
