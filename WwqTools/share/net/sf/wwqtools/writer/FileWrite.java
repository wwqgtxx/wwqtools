package net.sf.wwqtools.writer;

import java.io.File;
import java.io.FileWriter;

import net.sf.wlogging.Logger;
import net.sf.wlogging.LoggerFactory;

public class FileWrite {
	private static Logger paint = LoggerFactory.SHOW_All_MESSAGE_FACTORY
			.getLogger();

	private FileWrite() {
	}

	private static final FileWrite pw = new FileWrite();

	public String a = "";
	public String b = "";

	public String Writer(String s) throws Exception {
		File f = new File(b);
		if (f.exists()) {
		} else {
			f.mkdir();
		}
		FileWriter fw = new FileWriter(a);
		paint.debug(a);
		fw.write(s);
		fw.close();
		return s;
	}

	public void setPath(String s, String s2) {
		a = s + s2;
		b = s;

	}

	public static FileWrite getWt() {
		return pw;
	}
}
