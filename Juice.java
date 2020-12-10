package 西二二轮;

import java.time.LocalDate;

public class Juice extends Drinks{
	
	public Juice(){
		
	}
	public Juice(String name,double pay) {
		this.name=name;
		this.chengben=chengben;
		this.localdate=localdate;
		this.baozhiqi=baozhiqi;
		this.pay=pay;
	}
	
	//判断过期
	public boolean Overtime(LocalDate now,LocalDate pd,int baozhiqi) {
		int i=now.compareTo(pd);
		if(i>baozhiqi) {
			System.out.println("该饮品已过期");
		}else {
			System.out.println("该饮品尚未过期可正常饮用：");
			return true;
		}
		return false;
	}

	public String toString() {
		return "果汁:" + name+"\t价格："+pay;
	}
}
