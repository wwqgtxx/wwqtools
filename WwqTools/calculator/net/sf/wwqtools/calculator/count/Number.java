package net.sf.wwqtools.calculator.count;

import java.math.BigInteger;

import net.sf.wlogging.PrintName.paint;

public class Number {
	public BigInteger a = new BigInteger("0");

	public BigInteger addNumber(BigInteger b) {
		String s = b.toString();
		BigInteger n = new BigInteger(s);

		a = a.multiply(BigInteger.TEN);
		a = a.add(n);

		BigInteger r = returnNumber();
		paint.debug(r);

		return r;
	}

	public BigInteger returnNumber() {
		paint.debug(a);
		return a;

	}

	public BigInteger deleteNumber() throws ArithmeticException {
		BigInteger b = a.remainder(a);
		a = a.subtract(b);

		a = a.divide(BigInteger.TEN);
		paint.debug(a);

		return a;

	}
}
