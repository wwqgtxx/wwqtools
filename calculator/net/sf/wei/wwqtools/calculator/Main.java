package net.sf.wei.wwqtools.calculator;

import net.sf.wei.wwqtools.calculator.form.MainForm;
import net.sf.wei.wwqtools.wlog.paint.PrintName;

public class Main{

	private static PrintName p = new PrintName(Main.class);
	
	public static void open(String[] args) {
		PrintName.setPaint(true);
		p.paint("start");	
		new MainForm().show();		
	}


} 
