package net.sf.wwqtools.datasv;

import java.util.HashMap;
import java.util.Map;

public class DataFactory {
	private static Map<String, DataCache> dMap = new HashMap<String, DataCache>();

	private DataFactory() {
	}

	public static DataCache getDataCache(String name) {
		DataCache tempDataCache = dMap.get(name);
		if (tempDataCache == null) {
			dMap.put(name, new DataCache(name));
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

	public static DataCache getPackageDataCache(Class<?> c) {
		c.getName();
		return getDataCache(c.getPackage().getName());
	}

	public static DataCache getMyPackageDataCache() {
		try {
			return getPackageDataCache(Class.forName(new Throwable()
					.getStackTrace()[1].getClassName()));
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public static DataCache getMyClassDataCache() {
		try {
			return getClassDataCache(Class.forName(new Throwable()
					.getStackTrace()[1].getClassName()));
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public static DataCache[] getAllDataCaches() {
		DataCache[] dCaches = new DataCache[dMap.size()];
		int i = 0;
		for (DataCache dc : dMap.values()) {
			dCaches[i] = dc;
			i++;

		}
		return dCaches;
	}

	public static String getMessage() {
		StringBuilder temp = new StringBuilder("");
		temp.append("\r\n Now Print DataFactory's DataCache's Objcet's Message");
		for (DataCache dc : (DataFactory.getAllDataCaches())) {
			temp = temp.append("\r\n").append(dc.getName()).append("=")
					.append(dc.toString());
		}
		return temp.toString();
	}
}
