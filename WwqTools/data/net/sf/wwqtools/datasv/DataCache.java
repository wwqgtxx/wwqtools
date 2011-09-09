package net.sf.wwqtools.datasv;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class DataCache implements Iterable<Object> {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private Display display = null;
	private long num = 0;
	private final String name;

	protected DataCache(String name) {
		this.name = name;
		num++;
	}

	public void clean(boolean is) {
		if (is) {
			dataMap.clear();
		}
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

	public Display newDefaultDisplay() {
		display = new Display();
		return display;
	}

	public Display getDefaultDisplay() {
		if (display != null) {
			return display;
		}
		throw new NullPointerException("Please call \"newDefaultDisplay()\"");
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

	protected Map<String, Object> getMap() {
		return dataMap;
	}

	protected void setMap(Map<String, Object> new_dataMap) {
		dataMap = new_dataMap;
	}

	@Override
	public int hashCode() {
		return new Long(num).hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (o.hashCode() == this.hashCode()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return dataMap.values().iterator();
	}

	@Override
	public String toString() {
		return dataMap.toString();
	}

	public String getName() {
		return name;
	}
}
