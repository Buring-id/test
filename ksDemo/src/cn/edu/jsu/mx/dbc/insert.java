package cn.edu.jsu.mx.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.jsu.mx.vo.gly;

public class insert  {
	
	public void add(gly user) {
		
		String sql="insert into gly(xm,xb,nl,zh,mm) values(?,?,?,?,?)";//ʹ��ռλ������������
		
		mysql dbcs=new mysql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.setString(1, user.getXm());//�����1��ռλ��������
    		pstmt.setString(2, user.getXb());//�����2��ռλ��������
    		pstmt.setString(3, user.getNl());//�����3��ռλ��������
    		pstmt.setString(4, user.getZh());
    		pstmt.setString(5, user.getMm());
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}