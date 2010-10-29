package net.sf.wwqtools.sqrt;

import java.math.BigDecimal;

import net.sf.wwqtools.main.Main;
import net.sf.wwqtools.wlog.PrintName;
import static java.math.BigDecimal.*;

public class SqrtCount {
	
	private static PrintName p = new PrintName(SqrtCount.class);

	public static void count(String text) {
		BigDecimal num = new BigDecimal(text);
		int z[] =find(num);
		for(int a:z){
			System.out.print(a+"  ");
		}
	}

	public static int[] find(BigDecimal num){
		
		for(int a=1,b=2;;){
			BigDecimal s_a=new BigDecimal(a*a);
			BigDecimal s_b=new BigDecimal(b*b);
			if(whoBig(num,s_a)&&whoBig(s_b,num)){
				//System.out.println(a+"     "+b);
				int z[] ={a,b};
				return z;
			}
			a=a+1;
			b=b+1;
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
