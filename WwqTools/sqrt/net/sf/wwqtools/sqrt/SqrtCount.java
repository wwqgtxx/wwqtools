package net.sf.wwqtools.sqrt;

import java.math.BigDecimal;

import net.sf.wlogging.PrintName;

public class SqrtCount implements Runnable {

	private static PrintName p = new PrintName(SqrtCount.class);

	private static SqrtSave ss = SqrtSave.getSs();

	public SqrtCount(String text, String s_i) {
		ss.setText(text);
		ss.setS_i(s_i);
	}

	public SqrtCount() {

	}

	@Override
	public void run() {
		setOk(false);
		BigDecimal num = new BigDecimal(ss.getText());
		int i = Integer.parseInt(ss.getS_i());
		p.paint(sqrt(num));
		p.paint(i);
		start(num, i + 1);
		setOk(true);
	}

	private String sqrt(BigDecimal num) {
		return ((Double) (Math.sqrt(Double.valueOf(num.toString()))))
				.toString();
	}

	private String start(BigDecimal num, int i) {
		setS_sqrt("");
		BigDecimal nnn = new BigDecimal("1");
		nnn = run(num, nnn, new BigDecimal("1"));
		ss.setS_n(String.valueOf(nnn.scale()));
		String s1 = "0";
		String s2 = ".";
		String s3 = "1";
		for (int x = 1; x < (i - 1); x++) {
			nnn = run(num, nnn, new BigDecimal(s1 + s2 + s3));
			s3 = "0" + s3;
			ss.setS_n(String.valueOf(nnn.scale()));
		}
		nnn = run(num, nnn, new BigDecimal(s1 + s2 + s3));
		String s = nnn.toString();
		ss.setS_n(String.valueOf(nnn.scale()));

		ss.getDisplay().asyncExec(new Runnable() {
			public void run() {
				ss.getText_0().setText(ss.getS_sqrt());
				ss.getText_00().setText(ss.getS_n());
			}
		});

		return s;

	}

	class PaintResult implements Runnable {

		@Override
		public void run() {
			while (ss.isOk() == false) {
				ss.getDisplay().asyncExec(new Runnable() {
					public void run() {
						ss.getText_0().setText(ss.getS_sqrt());
						ss.getText_00().setText(ss.getS_n());
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

	private BigDecimal run(BigDecimal num, BigDecimal nnn, BigDecimal c) {
		BigDecimal z[] = find(num, nnn, c);
		BigDecimal nnnx = z[0];
		for (BigDecimal a : z) {
			p.paintDhl(a.toString() + "  ");
			p.paint("");
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
		ss.setS_sqrt(s_sqrt);

	}

	public static String getS_sqrt() {
		return ss.getS_sqrt();
	}

	private static void setOk(boolean ok) {
		ss.setOk(ok);
	}

	public static boolean isOk() {

		return ss.isOk();
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
