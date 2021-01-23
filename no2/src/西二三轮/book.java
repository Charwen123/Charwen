package ��������;

import java.sql.*;
import java.util.*;

public class book {
	static Connection con=databases.connectDB();
	static PreparedStatement pst;
	static ResultSet rs;
	
	//����ͼ��	
	public static void addbook(int no,String name,String author,String state) {
		String str="insert into book(no,name,author,state) values (?,?,?,?)";
		try {
			pst = con.prepareStatement(str);
			pst.setInt(1, no);
			pst.setString(2, name);
			pst.setString(3, author);
			pst.setString(4, state);
			pst.executeUpdate();
			con.close();
			System.out.println("�ɹ�����"+name);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//ɾ��ͼ��
	public static void deletebook(int no) {
		String str="delete from book where no = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setInt(1, no);
			pst.executeUpdate();
			con.close();
			System.out.println("�ɹ�ɾ��"+no+"��");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//��������
	public static void searchname(String Name) {
		String str="select * from book where name = ?";
		try {
			boolean flag=false;	//true-����		false-û��
			pst = con.prepareStatement(str);
			pst.setString(1, Name);
			rs=pst.executeQuery();
			while(rs.next()) {
				flag=true;
				int no = rs.getInt(1);
				String name=rs.getString(2);
				String author=rs.getString(3);
				String state=rs.getString(4);
				System.out.println(no+"\t"+name+"\t"+author+"\t"+state);
			}
			if(!flag) {
				System.out.println("�޷���������ͼ�飬�����Ƿ�������ȷ");
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//��������
	public static void searchauthor(String Author) {
		String str="select * from book where author = ?";
		try {
			boolean flag=false;
			pst = con.prepareStatement(str);
			pst.setString(1, Author);
			rs=pst.executeQuery();
			while(rs.next()) {
				flag=true;
				int no = rs.getInt(1);
				String name=rs.getString(2);
				String author=rs.getString(3);
				String state=rs.getString(4);
				System.out.println(no+"\t"+name+"\t"+author+"\t"+state);
			}
			if(!flag) {
				System.out.println("�޷���������ͼ�飬�����Ƿ�������ȷ");
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//�������
	public static void searchno(int No) {
		String str="select * from book where no = ?";
		try {
			boolean flag=false;
			pst = con.prepareStatement(str);
			pst.setInt(1, No);
			rs=pst.executeQuery();
			while(rs.next()) {
				flag=true;
				int no = rs.getInt(1);
				String name=rs.getString(2);
				String author=rs.getString(3);
				String state=rs.getString(4);
				System.out.println(no+"\t"+name+"\t"+author+"\t"+state);
			}
			if(!flag) {
				System.out.println("�޷���������ͼ�飬�����Ƿ�������ȷ");
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
