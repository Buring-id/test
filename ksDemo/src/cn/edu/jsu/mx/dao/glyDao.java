package cn.edu.jsu.mx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import cn.edu.jsu.mx.dbc.Mysql;
import cn.edu.jsu.mx.vo.Gly;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class glyDao {
	private Connection conn=new Mysql().getConnection();
	public glyDao() {}
	public List<Gly> getAllScjData() {
		List<Gly> list=new ArrayList<Gly>();
		String sql="select zh,mm from gly";
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Gly user=new Gly();
				user.setZh(rs.getString(1));
				user.setMm(rs.getString(2));
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Vector<Vector> getTableRows(List<Gly> list){
		Vector<Vector> rows=new Vector<Vector>();
		for(int i=0;i<list.size();i++) {
			Vector row=new Vector();
			Gly user=list.get(i);
			Collections.addAll(row, user.getZh(),user.getMm());
			rows.add(row);
		}
		
		return rows;
	}

}
