package net.sf.wwqtools.pai;

import java.math.BigDecimal;

import net.sf.wlogging.PrintName;
import net.sf.wwqtools.writer.FileWrite;

public class PaiCount implements Runnable {
	private static PrintName p = new PrintName(PaiCount.class);
	private PaiSave ps = PaiSave.getPs();
	private FileWrite pw = FileWrite.getWt();

	public BigDecimal setPie(BigDecimal pie) {
		ps.setPie(pie);
		p.paint(pie);
		return pie;
	}

	public void setPath(String s, String s2) {
		pw.a = s + s2;
		pw.b = s;

	}

	public void count(Integer i) {
		p.paint(ps.getCount());
		BigDecimal pie = ps.getPie();
		String rt = "\r\n";
		String xx = "*************";
		String st;
		String s;
		String so;
		BigDecimal dt;
		p.paint(i);
		int b = 1;
		s = "��1��" + i + "�Ħ���ˣ��е���" + pie + rt;
		for (int a = i, c = 1, d = 1, e = 1; a > 0; c++, a--, b++, e++) {
			if (e == 1) {
				so = s;
				s = so + rt + rt + xx + (d - 1) * 100 + "-" + d * 100 + "��"
						+ xx + rt;
			}

			ps.setS(s);
			ps.setB(b);

			so = s;
			p.paint(b);
			dt = pie.multiply(new BigDecimal(b));
			p.paint(dt.toString());
			st = dt.toString();
			s = so + rt + b + "�� = " + st;

			ps.setS(s);
			ps.setB(b);

			if (c >= 99) {
				so = s;
				s = so + rt + rt + xx + d * 100 + "-" + (d + 1) * 100 + "��"
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
					// TODO Auto-generated catch block
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
