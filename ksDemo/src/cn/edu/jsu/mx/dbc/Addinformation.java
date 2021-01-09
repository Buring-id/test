package cn.edu.jsu.mx.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.jsu.mx.vo.gly;
import cn.edu.jsu.mx.vo.xm;

public class Addinformation  {
	
	public void add(xm user) {
		
		String sql="insert into xm(xmm,id,jf,fzr) values(?,?,?,?)";//使用占位符定义插入语句
		
		mysql dbcs=new mysql();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.setString(1, user.getXmm());//定义第1个占位符的内容
    		pstmt.setString(2, user.getId());
    		pstmt.setString(3, user.getJf());//定义第2个占位符的内容
    		pstmt.setString(4, user.getFzr());//定义第3个占位符的内容
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}