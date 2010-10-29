package net.sf.wwqtools.sqrt;

import java.math.BigDecimal;

import net.sf.wwqtools.main.Main;
import net.sf.wwqtools.wlog.PrintName;
import static java.math.BigDecimal.*;

public class SqrtCount {
	
	private static PrintName p = new PrintName(SqrtCount.class);

	public static void count(String text) {
		BigDecimal num = new BigDecimal(text);
		p.paint(Math.sqrt(Double.valueOf(num.toString())));
		BigDecimal nnn = new BigDecimal(1);
		nnn = run(num,nnn,new BigDecimal(1));
		nnn = run(num,nnn,new BigDecimal(0.1));


	}
	
	public static BigDecimal run(BigDecimal num,BigDecimal nnn,BigDecimal c){
		BigDecimal z[] =find(num,nnn,c);
		BigDecimal nnnx = z[0];
		for(BigDecimal a:z){
			System.out.print(a.toString()+"  ");
			System.out.println();
		}
		System.out.println();
		return nnnx;
		
	}

	public static BigDecimal[] find(BigDecimal num,BigDecimal a,BigDecimal c){
		BigDecimal b = new BigDecimal(0);
		while(true){
			b=a.add(c);
			BigDecimal s_a=a.multiply(a);
			BigDecimal s_b=b.multiply(b);
			if(whoBig(num,s_a)&&whoBig(s_b,num)){
				//System.out.println(a+"     "+b);
				BigDecimal z[] ={a,b};
				return z;
			}
			a=a.add(c);
		}
		
		
		
	}
	
	public static boolean whoBig(BigDecimal a,BigDecimal b) {
		BigDecimal t_max=a.max(b);
		if(a.equals(b)){
			return true;
		}
		else if(t_max.toString().equals(a.toString())){
			return true;
		}
		else if(t_max.toString().equals(b.toString())){
			return false;
		}
		
		return false;
	}
	
	
//	public static void count(String text) {
//		int num = Integer.parseInt(text);
//		p.paint(num);
//		int a=0,b=1;
//		while(true) {
//			int s_a=a*a;
//			p.paint(s_a);
//			int s_b=b*b;
//			if(s_a<=num){
//				if(s_b>=num){
//					p.paint(s_a+"  "+s_b);
//					break;
//				}
//			}
//			a++;
//			b++;
//			
//		}
//	}

}
