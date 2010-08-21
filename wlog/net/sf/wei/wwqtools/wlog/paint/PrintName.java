package net.sf.wei.wwqtools.wlog.paint;

import net.sf.wei.wwqtools.main.shell.MainShell;

public class PrintName {
	
	private String s;
	private static boolean can = true;
	private PaintForm pf = PaintForm.getNewPaintForm();
	private PaintSave ps = PaintSave.getPs();
	private MainShell w = null;

	
	@SuppressWarnings("rawtypes")
	public PrintName (Class c) {
		this.s=c.getName();
	}
	public static boolean setPaint (boolean c) {
		can = c;
		return can;
	}
	public void paint(Object o) {
		w = pf.getPaintForm();
		String a = "("+s+")"+": "+ o+"\r\n" ;
		String b = ps.getS(); 
		b=a+b;
		ps.setS(b);
		if(can == true) {
			
			if (w != null) {
				w.setText(b);
			}			
			System.out.print(a);
		}

	}
	
}


