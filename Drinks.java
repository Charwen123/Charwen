package 西二二轮;

import java.time.*;

public abstract class Drinks {
	protected double chengben;
	protected String name;
	protected LocalDate localdate;
	protected double pay;
	protected int baozhiqi;
	
	Drinks() {
	}
	Drinks(String name,double chengben,LocalDate localdate,int baozhiqi,double pay) {
		this.name=name;
		this.chengben=chengben;
		this.localdate=localdate;
		this.baozhiqi=baozhiqi;
		this.pay=pay;
	}
	
	//判断过期
	public boolean Overtime(LocalDate now,LocalDate date,int baozhiqi) {
		int i=now.compareTo(date);
		if(i>baozhiqi) {
			System.out.println("该饮品已过期");
		}else {
			System.out.println("尚未过期可正常饮用");
			return true;
		}
		return false;
	}
		
	public String toString() {
		return "Drinks [name:" + name + "]";
	}
}
