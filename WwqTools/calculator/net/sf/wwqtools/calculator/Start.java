package net.sf.wwqtools.calculator;

import net.sf.wwqtools.calculator.form.MainForm;
import net.sf.wwqtools.wlog.PrintName;

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
