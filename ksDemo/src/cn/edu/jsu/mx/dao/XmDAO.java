package cn.edu.jsu.mx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import cn.edu.jsu.mx.dbc.mysql;
import cn.edu.jsu.mx.vo.xm;


public class XmDAO {
	private Connection conn=new mysql().getConnection();
	public XmDAO() {}
	public List<xm> getAllScjData() {
		List<xm> list=new ArrayList<xm>();
		String sql="select xmm,id,jf,fzr from xm";
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				xm xm=new xm();
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
	public Vector<Vector> getTableRows(List<xm> list){
		Vector<Vector> rows=new Vector<Vector>();
		for(int i=0;i<list.size();i++) {
			Vector row=new Vector();
			xm xm=list.get(i);
			Collections.addAll(row, xm.getXmm(),xm.getId(),xm.getJf(),xm.getFzr());
			rows.add(row);
		}
		
		return rows;
	}

}
