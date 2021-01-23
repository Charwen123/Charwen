package ��������;

import java.sql.*;

public class borrow {
	static Connection con=databases.connectDB();
	static PreparedStatement pst;
	static ResultSet rs;
	
	//����Ϊ���Ĵ���
	
	//�޸Ľ��ı���Ϣ
	public static void borrow(int no,String name,String sex,String book) {
		String str="insert into borrow(no,name,sex,book) values (?,?,?,?)";
		try {
			pst = con.prepareStatement(str);
			pst.setInt(1, no);
			pst.setString(2, name);
			pst.setString(3, sex);
			pst.setString(4, book);
			pst.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//�޸�ͼ���б��еĽ���״̬
	public static void borrowstate(int no) {
		String str="update book set state = ? where no = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, "�ѽ���");
			pst.setInt(2, no);
			pst.executeUpdate();
			con.close();
			System.out.println("�ɹ�����"+no+"���鼮");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//����Ϊ�黹����
	
	//�޸Ľ��ı���Ϣ
	public static void Return(String name) {
		String str="delete from borrow where name = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, name);
			pst.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//�޸�ͼ���б��еĽ���״̬
	public static void returnstate(int no) {
		String str="update book set state = ? where no = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, "δ����");
			pst.setInt(2, no);
			pst.executeUpdate();
			con.close();
			System.out.println("�ɹ��黹"+no+"���鼮");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
