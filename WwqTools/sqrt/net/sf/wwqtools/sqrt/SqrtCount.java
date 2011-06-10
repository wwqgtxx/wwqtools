package net.sf.wwqtools.sqrt;

import java.math.BigDecimal;

import net.sf.wlogging.old.PrintName.paint;
import net.sf.wwqtools.datasv.DataCache;
import net.sf.wwqtools.datasv.DataFactory;
import net.sf.wwqtools.share.SetSWTText;
import net.sf.wwqtools.share.TextStringSave;

public class SqrtCount implements Runnable {

	private static DataCache dc = DataFactory.getMyPackageDataCache();

	public SqrtCount(String text, String s_i) {
		dc.set("text", text);
		dc.set("s_i", s_i);
	}

	public SqrtCount() {

	}

	@Override
	public void run() {
		setOk(false);
		try {
			look(dc.getString("text"), dc.getString("s_i"));
		} catch (IsNotNumberException e) {
			System.err.println(e);
		}

		BigDecimal num = new BigDecimal(dc.getString("text"));
		int i = Integer.parseInt(dc.getString("s_i"));
		paint.debug(sqrt(num));
		paint.debug(i);
		start(num, i + 1);
		setOk(true);
	}

	private void look(String text, String s_i) throws IsNotNumberException {
		if (isNumeric(text) == false) {
			throw new IsNotNumberException("text");
		}
		if (isNumeric(s_i) == false) {
			throw new IsNotNumberException("text");
		}

		try {
			Integer.parseInt(text);
			Integer.parseInt(s_i);
		} catch (NumberFormatException e1) {
			SetSWTText.setText((dc.getDisplay("display")), new TextStringSave(
					dc.getText("text_0"), "数字多过大无法计算，最大只能为："
							+ Integer.MAX_VALUE));

			return;
		}
	}

	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				return false;
		}
		return true;
	}

	private String sqrt(BigDecimal num) {
		return ((Double) (Math.sqrt(Double.valueOf(num.toString()))))
				.toString();
	}

	private String start(BigDecimal num, int i) {
		setS_sqrt("");
		BigDecimal nnn = new BigDecimal("1");
		nnn = run(num, nnn, new BigDecimal("1"));

		dc.set("s_n", String.valueOf(nnn.scale()));
		String s1 = "0";
		String s2 = ".";
		String s3 = "1";
		for (int x = 1; x < (i - 1); x++) {
			nnn = run(num, nnn, new BigDecimal(s1 + s2 + s3));
			s3 = "0" + s3;
			dc.set("s_n", String.valueOf(nnn.scale()));
		}
		nnn = run(num, nnn, new BigDecimal(s1 + s2 + s3));
		String s = nnn.toString();
		dc.set("s_n", String.valueOf(nnn.scale()));

		SetSWTText.setText(
				(dc.getDisplay("display")),
				new TextStringSave((dc.getText("text_0")), ((String) dc
						.get("s_sqrt"))),
				new TextStringSave((dc.getText("text_00")), ((String) dc
						.get("s_n"))));

		return s;

	}

	class PaintResult implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			while (isOk() == false) {
				SetSWTText.setText(
						(dc.getDisplay("display")),
						new TextStringSave((dc.getText("text_0")), (dc
								.getString("s_sqrt"))),
						new TextStringSave((dc.getText("text_00")), (dc
								.getString("s_n"))));

			}

		}

	}

	private BigDecimal run(BigDecimal num, BigDecimal nnn, BigDecimal c) {
		BigDecimal z[] = find(num, nnn, c);
		BigDecimal nnnx = z[0];
		for (BigDecimal a : z) {
			paint.debug(a.toString() + "  ");
			// paint("");
		}
		System.out.println();
		return nnnx;

	}

	private BigDecimal[] find(BigDecimal num, BigDecimal a, BigDecimal c) {
		BigDecimal b = new BigDecimal(0);
		while (true) {
			b = a.add(c);
			BigDecimal s_a = a.multiply(a);
			BigDecimal s_b = b.multiply(b);
			if (isBig(num, s_a) && isBig(s_b, num)) {
				// System.out.println(a+"     "+b);
				BigDecimal z[] = { a, b };
				setS_sqrt(a.toString());
				return z;
			}
			a = a.add(c);
		}

	}

	private boolean isBig(BigDecimal a, BigDecimal b) {
		BigDecimal t_max = a.max(b);
		if (a.equals(b)) {
			return true;
		} else if (t_max.toString().equals(a.toString())) {
			return true;
		} else if (t_max.toString().equals(b.toString())) {
			return false;
		}

		return false;
	}

	private static void setS_sqrt(String s_sqrt) {
		dc.set("s_sqrt", s_sqrt);

	}

	public static String getS_sqrt() {
		return dc.getString("s_sqrt");
	}

	private static void setOk(boolean ok) {
		dc.set("ok", ok);
	}

	public static boolean isOk() {

		return dc.getBoolean("ok");
	}

	// public static void count(String text) {
	// int num = Integer.parseInt(text);
	// p.paint(num);
	// int a=0,b=1;
	// while(true) {
	// int s_a=a*a;
	// p.paint(s_a);
	// int s_b=b*b;
	// if(s_a<=num){
	// if(s_b>=num){
	// p.paint(s_a+"  "+s_b);
	// break;
	// }
	// }
	// a++;
	// b++;
	//
	// }
	// }

}
