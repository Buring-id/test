package cn.edu.jsu.mx.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.jsu.mx.vo.gly;
import cn.edu.jsu.mx.vo.xm;

public class Addinformation  {
	
	public void add(xm user) {
		
		String sql="insert into xm(xmm,id,jf,fzr) values(?,?,?,?)";//ʹ��ռλ������������
		
		mysql dbcs=new mysql();
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
}