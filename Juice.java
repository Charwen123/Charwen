package ��������;

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
	
	//�жϹ���
	public boolean Overtime(LocalDate now,LocalDate pd,int baozhiqi) {
		int i=now.compareTo(pd);
		if(i>baozhiqi) {
			System.out.println("����Ʒ�ѹ���");
		}else {
			System.out.println("����Ʒ��δ���ڿ��������ã�");
			return true;
		}
		return false;
	}

	public String toString() {
		return "��֭:" + name+"\t�۸�"+pay;
	}
}
