package cn.edu.jsu.mx.frm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.mx.dao.TxtDao;
import cn.edu.jsu.mx.dbc.mysql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Color;

public class Recordinterface {
	private static JTextField zhtextField;
	private static JTextField mmtextField_1;
	private static JTextField zhtx;
	private static JTextField mmtx;
public static void main(String[] args){
	
	JFrame frame=new JFrame("管理员登录管理系统");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(100, 100, 596, 364);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frame.setContentPane(contentPane);
	contentPane.setLayout(null);

	
	JLabel label = new JLabel("账号");
	label.setBounds(62, 46, 54, 15);
	contentPane.add(label);
	
	JLabel label_1 = new JLabel("密码");
	label_1.setBounds(62, 119, 54, 15);
	contentPane.add(label_1);
	
	zhtextField = new JTextField();
	zhtextField.setBounds(154, 43, 126, 21);
	contentPane.add(zhtextField);
	zhtextField.setColumns(10);
	
	JPasswordField mmtextField_1 = new JPasswordField();
	mmtextField_1.setEchoChar('*');
	mmtextField_1.setBounds(154, 116, 126, 21);
	contentPane.add(mmtextField_1);
	mmtextField_1.setColumns(10);
	
	JLabel lblNewLabel = new JLabel();
	lblNewLabel.setForeground(Color.RED);
	lblNewLabel.setBounds(315, 46, 162, 15);
	contentPane.add(lblNewLabel);
	
	JButton button = new JButton("登录");
	button.setBounds(98, 226, 93, 23);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			String a1=zhtextField.getText().trim();
			String a2=mmtextField_1.getText().trim();
			mysql dbcs=new mysql();
			try(Connection conn=dbcs.getConnection();//获取数据库连接
		    		Statement stmt=conn.createStatement();){//实例化
		    		String sql="select zh,mm from gly";
		    		ResultSet rs=stmt.executeQuery(sql);//执行查询语句
		    		while(rs.next()){
		    		if((a1).equals(rs.getString(1))&&(a2).equals(rs.getString(2))){ 
		    			JOptionPane.showMessageDialog(null, "登录成功");
		    try {
				new TxtDao().In(a1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    			new Maininterface().main(null);;
						frame.dispose();
		    		}
		    		}
		    		lblNewLabel.setText("账号或密码输入错误");
		    		zhtextField.setText("");
		    		mmtextField_1.setText("");
		    	}catch(SQLException e3) {
		    		e3.printStackTrace();
		    	}

			}
	});
	contentPane.add(button);
	
	JButton button_1 = new JButton("注册");
	button_1.setBounds(297, 226, 93, 23);
	button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new Registerinterface().main(null);
			frame.dispose();
		}
	});
	contentPane.add(button_1);
	
	frame.setLocationRelativeTo(null);//窗体居中
	frame.setVisible(true);
}
}
