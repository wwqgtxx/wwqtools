package net.sf.wwqtools.datasv;

import java.util.HashMap;
import java.util.Map;

public class DataFatory {
	private static Map<String, DataCache> dMap = new HashMap<String, DataCache>();

	private DataFatory() {
	}

	public static DataCache getDataCache(String name) {
		DataCache tempDataCache = dMap.get(name);
		if (tempDataCache == null) {
			dMap.put(name, new DataCache());
			tempDataCache = dMap.get(name);
		}
		return tempDataCache;
	}

	public static DataCache getDefaultDataCache() {
		return getDataCache("default");
	}

	public static DataCache getClassDataCache(Class<?> c) {
		return getDataCache(c.getName());
	}

	public static DataCache getMyDataCache() {
		return getDataCache(new Throwable().getStackTrace()[1].getClassName());
	}
}
