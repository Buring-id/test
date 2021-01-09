package cn.edu.jsu.mx.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.jsu.mx.vo.Gly;
import cn.edu.jsu.mx.vo.Xm;

public class Addinformation  {
	
	public void add(Xm user) {
		
		String sql="insert into xm(xmm,id,jf,fzr) values(?,?,?,?)";//ʹ��ռλ������������
		
		Mysql dbcs=new Mysql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.setString(1, user.getXmm());//�����1��ռλ��������
    		pstmt.setString(2, user.getId());
    		pstmt.setString(3, user.getJf());//�����2��ռλ��������
    		pstmt.setString(4, user.getFzr());//�����3��ռλ��������
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

	public static boolean find(String sql) {
		Mysql a=new Mysql();
		try(Connection conn=a.getConnection();//��ȡ���ݿ�����
				Statement pstmt=conn.createStatement();){//ʵ����
			String sql2="select zh from gly";
			ResultSet rs=pstmt.executeQuery(sql2);
	    		while(rs.next()){
	    			return true;
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
		return false;
	}
}