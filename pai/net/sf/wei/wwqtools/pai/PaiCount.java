package net.sf.wei.wwqtools.pai;

import net.sf.wei.wwqtools.wlog.paint.PrintName;

public class PaiCount {
	private static PrintName p = new PrintName(PaiCount.class);
	@SuppressWarnings("unused")
	private int n;
	private double pie;
	
	public double setPie(double pie) {
		this.pie = pie;
		p.paint(pie);
		return pie;
	}


	public String count(Integer i) {
		String rt = "\r\n";
		String xx = "*************";
		String s;
		String st;
		String so;
		Double dt;
		s = "��1��"+i+"�Ħ���ˣ��е���"+pie+rt;
		for(int a=i,b=1,c=1,d=1,e=1;a>0;c++,a--,b++,e++) {
			if(e==1) {
				so = s;			
				s = so+rt+rt+xx+(d-1)*100+"-"+d*100+"��"+xx+rt;
			}
			
			so = s;
			dt = b*pie;
			st = dt.toString();
			s = so+rt+b+"�� = "+st;
			
			if(c>=99) {
				so = s;			
				s = so+rt+rt+xx+d*100+"-"+(d+1)*100+"��"+xx+rt;
				d++;
				c=-1;
			}
			
		}
		return s;
	}

	
}
