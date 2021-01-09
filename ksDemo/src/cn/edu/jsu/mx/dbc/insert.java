package cn.edu.jsu.mx.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.jsu.mx.vo.gly;

public class insert  {
	
	public void add(gly user) {
		
		String sql="insert into gly(xm,xb,nl,zh,mm) values(?,?,?,?,?)";//使用占位符定义插入语句
		
		mysql dbcs=new mysql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.setString(1, user.getXm());//定义第1个占位符的内容
    		pstmt.setString(2, user.getXb());//定义第2个占位符的内容
    		pstmt.setString(3, user.getNl());//定义第3个占位符的内容
    		pstmt.setString(4, user.getZh());
    		pstmt.setString(5, user.getMm());
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}