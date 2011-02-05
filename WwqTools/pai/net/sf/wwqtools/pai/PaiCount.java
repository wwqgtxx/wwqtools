package net.sf.wwqtools.pai;

import java.math.BigDecimal;

import net.sf.wlogging.PrintName.paint;
import net.sf.wwqtools.writer.FileWrite;

public class PaiCount implements Runnable {
	private PaiSave ps = PaiSave.getPs();
	private FileWrite pw = FileWrite.getWt();

	public BigDecimal setPie(BigDecimal pie) {
		ps.setPie(pie);
		paint.debug(pie);
		return pie;
	}

	public void setPath(String s, String s2) {
		pw.a = s + s2;
		pw.b = s;

	}

	public void count(Integer i) {
		paint.debug(ps.getCount());
		BigDecimal pie = ps.getPie();
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

			ps.setS(s);
			ps.setB(b);

			so = s;
			paint.debug(b);
			dt = pie.multiply(new BigDecimal(b));
			paint.debug(dt.toString());
			st = dt.toString();
			s = so + rt + b + "π = " + st;

			ps.setS(s);
			ps.setB(b);

			if (c >= 99) {
				so = s;
				s = so + rt + rt + xx + d * 100 + "-" + (d + 1) * 100 + "π"
						+ xx + rt;
				d++;
				c = -1;
			}

			ps.setS(s);
			ps.setB(b);

		}
		ps.setS(s);
		ps.setB(b);
		try {
			pw.Writer(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class PaintResult implements Runnable {

		@Override
		public void run() {
			while (ps.isOk() == false) {
				ps.getDisplay().asyncExec(new Runnable() {
					public void run() {
						ps.getText_1().setText(String.valueOf(ps.getS()));
						ps.getText_11().setText(String.valueOf(ps.getB()));
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
		ps.setOk(false);
		count(ps.getCount());
		ps.setOk(true);
		ps.getDisplay().asyncExec(new Runnable() {
			public void run() {
				ps.getText_1().setText(String.valueOf(ps.getS()));
				ps.getText_11().setText(String.valueOf(ps.getB()));
			}
		});
	}

}
