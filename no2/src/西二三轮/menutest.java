package ��������;

import java.sql.*;
import java.util.*;

public class menutest {
	public void menu() throws Exception {
		Connection c=databases.connectDB();
		Scanner sc=new Scanner(System.in);
		if(!c.isClosed()) {
			System.out.println("��ӭ�����ª��ͼ�����ϵͳ��");
			System.out.println("1.ͼ��Ŀ¼\t2.����ͼ��\t3.ɾ��ͼ��\t4.����ͼ��\t5.������Ϣ\t6.����ͼ��\t7.�黹ͼ��");
			int num=sc.nextInt();
			Statement stm1=c.createStatement();
			Statement stm2=c.createStatement();
			String sqlbook="select * from book";
			ResultSet rsbook =stm1.executeQuery(sqlbook);
			
			String sqlbor="select * from borrow";
			ResultSet rsbor =stm2.executeQuery(sqlbor);
			
			switch (num) {
				case 1:
					System.out.println("no\tname\tauthor\tstate");
					while(rsbook.next()) {
						System.out.print(rsbook.getInt("no"+""));
						System.out.print("\t");
						System.out.print(rsbook.getString("name"+""));
						System.out.print("\t");
						System.out.print(rsbook.getString("author"+""));
						System.out.print("\t");
						System.out.print(rsbook.getString("state"+""));
						System.out.println();
					}
					break;
				case 2:
					System.out.println("�����������ţ����������ߣ��������");
					book.addbook(sc.nextInt(), sc.next(), sc.next(), sc.next());
					break;
				case 3:
					book.deletebook(sc.nextInt());
					break;
				case 4:
					System.out.println("��ѡ��������ʽ:\t1.��������\t2.��������\t3.�������");
					num=sc.nextInt();
					switch(num) {
						case 1:
							book.searchname(sc.next());
							break;
						case 2:
							book.searchauthor(sc.next());
							break;
						case 3:
							book.searchno(sc.nextInt());
							break;
					}
					break;
				case 5:
					System.out.println("no\tname\tsex\tbook");
					while(rsbor.next()) {
						System.out.print(rsbor.getInt("no"+""));
						System.out.print("\t");
						System.out.print(rsbor.getString("name"+""));
						System.out.print("\t");
						System.out.print(rsbor.getString("sex"+""));
						System.out.print("\t");
						System.out.print(rsbor.getString("book"+""));
						System.out.println();
					}
					break;
				case 6:
					System.out.println("������������ţ��������Ա𣬽���ͼ��");
					borrow.borrow(sc.nextInt(),sc.next(), sc.next(), sc.next());
					System.out.println("���������ͼ����");
					borrow.borrowstate(sc.nextInt());
					break;
				case 7:
					System.out.println("������黹������");
					borrow.Return(sc.next());
					System.out.println("������黹ͼ����");
					borrow.returnstate(sc.nextInt());
					break;
				}
		}
	}
}
