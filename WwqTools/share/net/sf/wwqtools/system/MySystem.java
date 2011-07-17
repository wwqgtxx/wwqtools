package net.sf.wwqtools.system;

import net.sf.wlogging.LoggerFactory;
import net.sf.wwqtools.datasv.DataFactory;

public class MySystem {

	private MySystem() {
	}

	public static void exit(int status) {
		LoggerFactory.SHOW_All_MESSAGE_FACTORY.getLogger().info(
				DataFactory.getMessage());
		System.exit(status);
	}

}
