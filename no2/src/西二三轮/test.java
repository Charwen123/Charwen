package ��������;

import java.util.*;

public class test {
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		menutest menu=new menutest();
		int num;
		do {
			menu.menu();
			System.out.println("�������˵��밴0�������������ּ���������");
			num=sc.nextInt();
		}while(num==0);
	}
}
