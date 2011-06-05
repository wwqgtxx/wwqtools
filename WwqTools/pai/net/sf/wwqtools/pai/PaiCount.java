package net.sf.wwqtools.pai;

import java.math.BigDecimal;

import net.sf.wlogging.old.PrintName.paint;
import net.sf.wwqtools.datasv.DataCache;
import net.sf.wwqtools.datasv.DataFatory;
import net.sf.wwqtools.writer.FileWrite;

public class PaiCount implements Runnable {
	private DataCache dc = DataFatory.getClassDataCache(PaiShell.class);
	private FileWrite pw = FileWrite.getWt();

	public BigDecimal setPie(BigDecimal pie) {
		dc.set("pie", pie);
		paint.debug(pie);
		return pie;
	}

	public void setPath(String s, String s2) {
		pw.a = s + s2;
		pw.b = s;

	}

	public void count(Integer i) {
		paint.debug((dc.getInteger("count")));
		BigDecimal pie = (BigDecimal) dc.get("pie");
		String rt = "\r\n";
		String xx = "*************";
		String st;
		String s;
		String so;
		BigDecimal dt;
		paint.debug(i);
		int b = 1;
		s = "从1到" + i + "的π相乘，π等于" + pie + rt;
		for (int a = i, c = 1, d = 1, e = 1; a > 0; c++, a--, b++, e++) {
			if (e == 1) {
				so = s;
				s = so + rt + rt + xx + (d - 1) * 100 + "-" + d * 100 + "π"
						+ xx + rt;
			}

			dc.set("s", s);
			dc.set("b", b);

			so = s;
			paint.debug(b);
			dt = pie.multiply(new BigDecimal(b));
			paint.debug(dt.toString());
			st = dt.toString();
			s = so + rt + b + "π = " + st;

			dc.set("s", s);
			dc.set("b", b);

			if (c >= 99) {
				so = s;
				s = so + rt + rt + xx + d * 100 + "-" + (d + 1) * 100 + "π"
						+ xx + rt;
				d++;
				c = -1;
			}

			dc.set("s", s);
			dc.set("b", b);

		}
		dc.set("s", s);
		dc.set("b", b);
		try {
			pw.Writer(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class PaintResult implements Runnable {

		@Override
		public void run() {
			while ((dc.getBoolean("ok")).booleanValue() == false) {
				(dc.getDisplay("display")).asyncExec(new Runnable() {
					public void run() {

						(dc.getStyledText("text_1")).setText(String
								.valueOf((String) (dc.get("s"))));
						(dc.getText("text_11")).setText(String
								.valueOf((Integer) (dc.get("b"))));
					}
				});
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void run() {
		dc.set("ok", false);
		count(dc.getInteger("count"));
		dc.set("ok", true);
		(dc.getDisplay("display")).asyncExec(new Runnable() {
			public void run() {

				(dc.getStyledText("text_1")).setText(String
						.valueOf((String) (dc.get("s"))));
				(dc.getText("text_11")).setText(String.valueOf((Integer) (dc
						.get("b"))));
			}
		});
	}

}
