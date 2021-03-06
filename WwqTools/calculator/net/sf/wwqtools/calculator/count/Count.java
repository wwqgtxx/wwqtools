package net.sf.wwqtools.calculator.count;

import java.math.BigInteger;

import net.sf.wlogging.old.PrintName.paint;

public class Count {
	private Number n = new Number();
	private Number n2 = new Number();

	/**
	 * now = 0 =
	 * 
	 * now = 1 = +
	 * 
	 * now = 2 = -
	 * 
	 * now = 3 = *
	 * 
	 * now = 4 = /
	 * 
	 */
	private int now;

	public BigInteger p(BigInteger a) {
		BigInteger r = a;
		paint.debug(r);
		return r;
	}

	public BigInteger addNumber(BigInteger a) {
		return p(n.addNumber(a));
	}

	public BigInteger returnNumber() {
		return p(n.returnNumber());
	}

	public BigInteger deleteNumber() {
		try {
			return p(n.deleteNumber());
		} catch (ArithmeticException e) {
			paint.warn(e);

			return BigInteger.ZERO;
		}

	}

	public BigInteger removeAllNumber() {
		n = new Number();
		n2 = new Number();
		now = 0;
		return p(n.returnNumber());
	}

	public BigInteger removeAllNumber1() {
		n = new Number();
		return p(n.returnNumber());
	}

	public BigInteger eliminate() {
		equrs();
		now = 4;
		n2 = n;
		paint.debug(now);
		return removeAllNumber1();
	}

	public BigInteger ride() {
		equrs();
		now = 3;
		n2 = n;
		paint.debug(now);
		return removeAllNumber1();
	}

	public BigInteger subtract() {
		equrs();
		now = 2;
		n2 = n;
		paint.debug(now);
		return removeAllNumber1();
	}

	public BigInteger plus() {
		equrs();
		now = 1;
		n2 = n;
		paint.debug(now);
		return removeAllNumber1();
	}

	public BigInteger equrs() {
		paint.debug(now);
		if (now == 1) {
			BigInteger b = n.returnNumber();
			BigInteger a = n2.returnNumber();
			BigInteger c = a.add(b);
			n.deleteNumber();
			n2.deleteNumber();
			n.addNumber(c);
			BigInteger r = n.returnNumber();
			paint.debug(r);
			return r;
		}
		if (now == 2) {
			BigInteger b = n.returnNumber();
			BigInteger a = n2.returnNumber();
			BigInteger c = a.subtract(b);
			n.deleteNumber();
			n2.deleteNumber();
			n.addNumber(c);
			BigInteger r = n.returnNumber();
			paint.debug(r);
			return r;
		}
		if (now == 3) {

			BigInteger b = n.returnNumber();
			BigInteger a = n2.returnNumber();
			BigInteger c = a.multiply(b);
			n.deleteNumber();
			n2.deleteNumber();
			n.addNumber(c);
			BigInteger r = n.returnNumber();
			paint.debug(r);
			return r;
		}
		if (now == 4) {
			BigInteger b = n.returnNumber();
			BigInteger a = n2.returnNumber();
			try {
				BigInteger c = a.divide(b);
				n.deleteNumber();
				n2.deleteNumber();
				n.addNumber(c);
				BigInteger r = n.returnNumber();
				paint.debug(r);
				return r;
			} catch (ArithmeticException e) {
				paint.warn(e);
				return BigInteger.ZERO;
			}

		} else {
			return BigInteger.ZERO;
		}
	}
}
