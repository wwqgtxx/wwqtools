package net.sf.wwqtools.wlog;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.wwqtools.main.shell.MainShell;

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
	private static final String RN = "\r\n";
	private static final String NULL = "";

	
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
	
	private void paintTo(String x,String n,Object o) {
		w = pf.getPaintForm();
		String a = getTime()+x+"("+s+")"+": "+ o+n ;
		String b = ps.getS(); 
		b=a+b;
		ps.setS(b);
		if (w != null) {
			w.setText(b);
		}
		if(can == true) {
			if(x.equals(ERR)){
				System.err.print(a);
			}
			else if(x.equals(NULL)){
				System.out.print(o);
			}
			else if(o.toString().equals(NULL)){
				System.out.println();
			}
			else{
				System.out.print(a);
			}
			
		}

	}
	
	public void paint(Object o){
		paintTo(INFO,RN,o);
	}
	
	public void paintDhl(Object o){
		paintTo(INFO,NULL,o);
	}
	
	public void paintErr(Exception e){
//		Display display = Display.getDefault();	
//		Color red= display.getSystemColor(SWT.COLOR_RED);					
//		StyledText st = ps.getTxtDebug();
//		st.setForeground(red);
		
		StringWriter sw=new StringWriter(); 
		PrintWriter pw=new PrintWriter(sw); 
		e.printStackTrace(pw); 
		String se =(sw.toString()); 
		
		paintTo(ERR,RN,se);

		
	}
	
}


