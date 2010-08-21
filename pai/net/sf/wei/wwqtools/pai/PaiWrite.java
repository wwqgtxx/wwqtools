package net.sf.wei.wwqtools.pai;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;

import net.sf.wei.wwqtools.wlog.paint.PrintName;

public class PaiWrite {
	
	private static PrintName p = new PrintName(PaiWrite.class);
	
	private PaiWrite() {}
	
	private static final PaiWrite pw = new PaiWrite();
	
	public String a = "";
	public String b = "";

	public String Writer(String s) throws Exception {
		File f = new File(b);
		if(f.exists()){	}
		else{
			f.mkdir(); 
		}
		FileWriter fw = new FileWriter(a);
		p.paint(a);
	    fw.write(s);
	    fw.close();
		return s;		
	}
	public void setPath(String s, String s2) {
		a=s+s2;
		b=s;
		
	}
	public static PaiWrite getWt() {
		return pw;
	}
}
