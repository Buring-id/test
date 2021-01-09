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
		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	Mysql dbcs=new Mysql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=(Connection) dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶη�������
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶι˿�ID
    			row.add(rs.getString(3));//��ȡ�������ֶ�Ա��ID
    			row.add(rs.getString(4));//��ȡ���ĸ��ֶη�����Ŀ
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
	}

}
