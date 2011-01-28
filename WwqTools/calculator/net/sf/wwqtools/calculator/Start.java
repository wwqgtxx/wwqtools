package net.sf.wwqtools.calculator;

import net.sf.wlogging.PrintName;
import net.sf.wwqtools.calculator.form.MainForm;

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
