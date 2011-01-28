package net.sf.wwqtools.sqrt;

import java.math.BigDecimal;

import net.sf.wlogging.PrintName;

public class SqrtCount {

	private static String s_sqrt = "";

	private static PrintName p = new PrintName(SqrtCount.class);

	public static String count(String text, String s_i) {
		BigDecimal num = new BigDecimal(text);
		int i = Integer.parseInt(s_i);
		p.paint(sqrt(num));
		p.paint(i);
		String s = start(num, i);
		return s;

	}

	private static String sqrt(BigDecimal num) {
		return ((Double) (Math.sqrt(Double.valueOf(num.toString()))))
				.toString();
	}

	private static String start(BigDecimal num, int i) {
		setS_sqrt("");
		BigDecimal nnn = new BigDecimal("1");
		nnn = run(num, nnn, new BigDecimal("1"));
		setS_sqrt(nnn.toString());
		String s1 = "0";
		String s2 = ".";
		String s3 = "1";
		for (int x = 1; x < (i - 1); x++) {
			nnn = run(num, nnn, new BigDecimal(s1 + s2 + s3));
			setS_sqrt(nnn.toString());
			s3 = "0" + s3;
		}
		String s = run(num, nnn, new BigDecimal(s1 + s2 + s3)).toString();
		return s;

	}

	private static BigDecimal run(BigDecimal num, BigDecimal nnn, BigDecimal c) {
		BigDecimal z[] = find(num, nnn, c);
		BigDecimal nnnx = z[0];
		for (BigDecimal a : z) {
			p.paintDhl(a.toString() + "  ");
			p.paint("");
		}
		System.out.println();
		return nnnx;

	}

	private static BigDecimal[] find(BigDecimal num, BigDecimal a, BigDecimal c) {
		BigDecimal b = new BigDecimal(0);
		while (true) {
			b = a.add(c);
			BigDecimal s_a = a.multiply(a);
			BigDecimal s_b = b.multiply(b);
			if (isBig(num, s_a) && isBig(s_b, num)) {
				// System.out.println(a+"     "+b);
				BigDecimal z[] = { a, b };
				return z;
			}
			a = a.add(c);
		}

	}

	private static boolean isBig(BigDecimal a, BigDecimal b) {
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
		SqrtCount.s_sqrt = s_sqrt;

	}

	public static String getS_sqrt() {
		return s_sqrt;
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
