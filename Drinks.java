package ��������;

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
	
	//�жϹ���
	public boolean Overtime(LocalDate now,LocalDate date,int baozhiqi) {
		int i=now.compareTo(date);
		if(i>baozhiqi) {
			System.out.println("����Ʒ�ѹ���");
		}else {
			System.out.println("��δ���ڿ���������");
			return true;
		}
		return false;
	}
		
	public String toString() {
		return "Drinks [name:" + name + "]";
	}
}
