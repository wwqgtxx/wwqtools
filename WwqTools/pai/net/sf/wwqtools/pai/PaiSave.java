package net.sf.wwqtools.pai;

import java.math.BigDecimal;

public class PaiSave {
	private PaiSave() {	}
	public static PaiSave getPs() {
		return ps;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getCount() {
		return count;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getS() {
		return s;
	}
	private static PaiSave ps = new PaiSave();
	private Integer count;
	private String s;
	
	public BigDecimal pie = new BigDecimal("3.14");
	
	public BigDecimal getPie() {
		return pie;
	}
	public void setPie(BigDecimal pie) {
		this.pie = pie;
	}
}
