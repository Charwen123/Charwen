package ��������;

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
	
	//�жϹ���
	public boolean Overtime(LocalDate now,LocalDate pd,int baozhiqi) {
		int i=now.compareTo(pd);
		if(i>baozhiqi) {
			System.out.println("����Ʒ�ѹ���");
		}else {
			System.out.println("�þ�Ʒ��δ���ڿ��������ã�");
			return true;
		}
		return false;
	}

	public String toString() {
		return "ơ��: " + name+"\t�ƾ�����: " + vol+ "\t�۸�: "+pay;
	}
}
