package 西二二轮;

import java.time.LocalDate;

public class Beer extends Drinks{
	float vol;
	
	public Beer(String name,float vol,double pay) {
		this.vol=vol;
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
			System.out.println("该酒品尚未过期可正常饮用：");
			return true;
		}
		return false;
	}

	public String toString() {
		return "啤酒: " + name+"\t酒精度数: " + vol+ "\t价格: "+pay;
	}
}
