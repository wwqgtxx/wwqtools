package net.sf.wei.wwqtools.wlog.paint;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.wei.wwqtools.main.shell.MainShell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class PrintName {
	
	private String s;
	private static boolean can = true;
	private PaintForm pf = PaintForm.getNewPaintForm();
	private PaintSave ps = PaintSave.getPs();
	private MainShell w = null;
	private static final String INFO = "   "+"[INFO]"+"   ";
	private static final String ERR = "   "+"[ERROR]"+"   ";

	
	@SuppressWarnings("rawtypes")
	public PrintName (Class c) {
		this.s=c.getName();
	}
	public static boolean setPaint (boolean c) {
		can = c;
		return can;
	}
	
	public String getTime() {
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  return df.format(new Date());
	}
	
	private void paintTo(String x,Object o) {
		w = pf.getPaintForm();
		String a = getTime()+x+"("+s+")"+": "+ o+"\r\n" ;
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
	
	public void paint(Object o){
		paintTo(INFO,o);
	}
	
	public void paintErr(Exception e){
		Display display = Display.getDefault();	
		Color red= display.getSystemColor(SWT.COLOR_RED);
		
		StringWriter sw=new StringWriter(); 
		PrintWriter pw=new PrintWriter(sw); 
		e.printStackTrace(pw); 
		String se =(sw.toString()); 
		
		StyledText st = ps.getTxtDebug();
		st.setForeground(w.red);
		
		paintTo(ERR,se);

		
	}
	
}


