package cn.edu.jsu.mx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import cn.edu.jsu.mx.dbc.mysql;
import cn.edu.jsu.mx.vo.gly;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class glyDao {
	private Connection conn=new mysql().getConnection();
	public glyDao() {}
	public List<gly> getAllScjData() {
		List<gly> list=new ArrayList<gly>();
		String sql="select zh,mm from gly";
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				gly user=new gly();
				user.setZh(rs.getString(1));
				user.setMm(rs.getString(2));
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Vector<Vector> getTableRows(List<gly> list){
		Vector<Vector> rows=new Vector<Vector>();
		for(int i=0;i<list.size();i++) {
			Vector row=new Vector();
			gly user=list.get(i);
			Collections.addAll(row, user.getZh(),user.getMm());
			rows.add(row);
		}
		
		return rows;
	}

}
