package cn.edu.jsu.mx.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//testdb
public class mysql {
	//����MySQL���ݿ���������
	private static final String DBRIVER="org.gjt.mm.mysql.Driver";
	//����MySQL���ݿ����ӵ�ַ
	private static final String DBURL="jdbc:mysql://localhost:3306/demo";
	private static final String DBUSER="root"; //MySQL���ݿ������û���
	private static final String PASSWORD="20010401"; //MySQL���ݿ���������
	private Connection conn=null; //�������Ӷ���
	public mysql() {//���췽���������ݿ�
		try {
			Class.forName(DBRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		} catch (Exception e) {e.printStackTrace();}
	}
	public Connection getConnection() {//�������ݿ����Ӷ���
		return this.conn;
	}
	public void close() {//�ر���������
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}