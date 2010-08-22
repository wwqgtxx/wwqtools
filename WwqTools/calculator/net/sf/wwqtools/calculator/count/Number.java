package net.sf.wwqtools.calculator.count;

import java.math.BigInteger;

import net.sf.wwqtools.wlog.PrintName;

public class Number {
	private static PrintName p = new PrintName(Number.class);
	public BigInteger a = new BigInteger("0");
	
	
	public BigInteger addNumber(BigInteger b) { 
		String s = b.toString();
		BigInteger n = new BigInteger(s);
		
		a=a.multiply(BigInteger.TEN);
		a=a.add(n);
		
		BigInteger r = returnNumber();
		p.paint(r);
		
		return r;
	}
	
	public BigInteger returnNumber() {
		p.paint(a);
		return a;
		
	}
	
	public BigInteger deleteNumber() throws ArithmeticException{
		BigInteger b = a.remainder(a);
		a=a.subtract(b);

		a=a.divide(BigInteger.TEN);
		p.paint(a);
			
		return a;


		
		
		
				
	}
}
