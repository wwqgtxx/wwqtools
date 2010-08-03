package net.sf.wei.wwqtools.pai;

import java.io.FileWriter;

public class Write {
	public static String Write(String s) throws Exception {
		FileWriter fw = null;
	      fw = new FileWriter("d:\\pai.txt");
	        fw.write(s);
	      fw.close();
		return "successfull";		
	}
}
