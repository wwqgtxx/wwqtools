package net.sf.wei.wwqtools.wlog.paint;

public class PrintName {
	
	private String s;
	private static boolean can = true;
	
//	public PrintName (String s) {
//		this.s=s;
//	}
	@SuppressWarnings("rawtypes")
	public PrintName (Class c) {
		this.s=c.getName();
	}
	public static boolean setPaint (boolean c) {
		can = c;
		return can;
	}
	public void paint(Object o) {
		if(can == true) {
			System.out.println("("+s+")"+": "+ o );
		}

	}
}
