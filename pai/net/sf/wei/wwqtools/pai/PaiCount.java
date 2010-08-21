package net.sf.wei.wwqtools.pai;

import java.math.BigDecimal;

import net.sf.wei.wwqtools.wlog.paint.PrintName;

public class PaiCount implements Runnable{
	private static PrintName p = new PrintName(PaiCount.class);	
	private PaiSave ps = PaiSave.getPs();
	private PaiWrite pw = PaiWrite.getWt();
	
	public BigDecimal setPie(BigDecimal pie) {
		ps.setPie(pie);
		p.paint(pie);
		return pie;
	}
	
	public void setPath(String s, String s2) {
		pw.a=s+s2;
		pw.b=s;
		
	}
	
	public void count(Integer i) {
		ps.setCount(i);
		p.paint(ps.getCount());
		new Thread(new PaiCount()).start();
		BigDecimal pie = ps.getPie();
		String rt = "\r\n";
		String xx = "*************";
		String s;
		String st;
		String so;
		BigDecimal dt;
		p.paint(i);
		s = "从1到"+i+"的π相乘，π等于"+pie+rt;
		for(int a=i,b=1,c=1,d=1,e=1;a>0;c++,a--,b++,e++) {
			if(e==1) {
				so = s;			
				s = so+rt+rt+xx+(d-1)*100+"-"+d*100+"π"+xx+rt;
			}
			
			so = s;
			p.paint(b);
			dt = pie.multiply(new BigDecimal(b));
			p.paint(dt.toString());
			st = dt.toString();
			s = so+rt+b+"π = "+st;
			
			if(c>=99) {
				so = s;			
				s = so+rt+rt+xx+d*100+"-"+(d+1)*100+"π"+xx+rt;
				d++;
				c=-1;
			}
			
		}
		ps.setS(s);
		try {
			pw.Writer(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		
		
	}
	public String getS() {
		String s = "";
		while(true){
			if(ps.getS()!= null) {
				s=ps.getS();
				break;
			}
			else{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		return s;
	}

	
}
