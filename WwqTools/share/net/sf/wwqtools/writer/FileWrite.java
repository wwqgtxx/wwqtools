package net.sf.wwqtools.writer;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;

import net.sf.wwqtools.wlog.PrintName;

public class FileWrite {
	
	private static PrintName p = new PrintName(FileWrite.class);
	
	private FileWrite() {}
	
	private static final FileWrite pw = new FileWrite();
	
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
	public static FileWrite getWt() {
		return pw;
	}
}