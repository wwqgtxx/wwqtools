package net.sf.wwqtools.datasv;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class DataCache {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private long num = 0;

	protected DataCache() {
		num++;
	}

	public void put(String name, Object obj) {
		dataMap.put(name, obj);
	}

	public void set(String name, Object obj) {
		put(name, obj);
	}

	public Object get(String name) {
		return dataMap.get(name);
	}

	public String getString(String name) {
		try {
			return (String) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public Integer getInteger(String name) {
		try {
			return (Integer) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public Thread getThread(String name) {
		try {
			return (Thread) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public Display getDisplay(String name) {
		try {
			return (Display) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public Text getText(String name) {
		try {
			return (Text) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public StyledText getStyledText(String name) {
		try {
			return (StyledText) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public BigDecimal getBigDecimal(String name) {
		try {
			return (BigDecimal) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public BigInteger getBigInteger(String name) {
		try {
			return (BigInteger) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public Boolean getBoolean(String name) {
		try {
			return (Boolean) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public Long getLong(String name) {
		try {
			return (Long) get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public int hashCode() {
		return new Long(num).hashCode();
	}

	public boolean equals(DataCache o) {
		if (o == this) {
			return true;
		} else if (o.hashCode() == this.hashCode()) {
			return true;
		} else {
			return false;
		}
	}
}
