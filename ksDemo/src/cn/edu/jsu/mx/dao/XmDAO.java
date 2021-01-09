package cn.edu.jsu.mx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import cn.edu.jsu.mx.dbc.Mysql;
import cn.edu.jsu.mx.vo.Xm;


public class XmDAO {
	private Connection conn=new Mysql().getConnection();
	public XmDAO() {}
	public List<Xm> getAllScjData() {
		List<Xm> list=new ArrayList<Xm>();
		String sql="select xmm,id,jf,fzr from xm";
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Xm xm=new Xm();
				xm.setXmm(rs.getString(1));
				xm.setId(rs.getString(2));
				xm.setJf(rs.getString(3));
				xm.setFzr(rs.getString(4));
				list.add(xm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Vector<Vector> getTableRows(List<Xm> list){
		Vector<Vector> rows=new Vector<Vector>();
		for(int i=0;i<list.size();i++) {
			Vector row=new Vector();
			Xm xm=list.get(i);
			Collections.addAll(row, xm.getXmm(),xm.getId(),xm.getJf(),xm.getFzr());
			rows.add(row);
		}
		
		return rows;
	}
	public Vector<Vector> getTableRows(String sql) {
		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	Mysql dbcs=new Mysql();//使用1中定义的连接数据库的类
    	try(Connection conn=(Connection) dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段服务序数
    			row.add(rs.getString(2));//获取第二个字段顾客ID
    			row.add(rs.getString(3));//获取第三个字段员工ID
    			row.add(rs.getString(4));//获取第四个字段服务项目
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//返回所有行数据
	}

}
