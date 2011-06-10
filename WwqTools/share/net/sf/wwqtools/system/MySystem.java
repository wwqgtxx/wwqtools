package net.sf.wwqtools.system;

import net.sf.wlogging.LogSystem;
import net.sf.wwqtools.datasv.DataFactory;

public class MySystem {

	private MySystem() {
	}

	public static void exit(int status) {
		LogSystem.paint.info(DataFactory.getMessage());
		System.exit(status);
	}

}
