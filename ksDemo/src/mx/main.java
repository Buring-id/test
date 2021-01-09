package mx;


import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.mx.dbc.mysql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public main() {
		setTitle("��Ŀ�ʽ����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel background = new JLabel(new ImageIcon());//url������ͼƬ��·��
		getContentPane().add(background);//�����jlabel�����ӵ�jframe��
		
		JLabel lblNewLabel = new JLabel("�˻���");
		lblNewLabel.setBounds(41, 58, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("���룺");
		lblNewLabel_1.setBounds(41, 127, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(107, 55, 153, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(104, 124, 153, 21);
		contentPane.add(passwordField);
		
		JButton signbtnNewButton = new JButton("��¼");
		signbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(passwordField.getText(),textField.getText());
			}
		});
		signbtnNewButton.setBounds(57, 186, 97, 23);
		contentPane.add(signbtnNewButton);
		
		JButton regibtnNewButton_1 = new JButton("ע��");
		regibtnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new bbb().main(null);
				dispose();
			}
		});
		regibtnNewButton_1.setBounds(216, 186, 97, 23);
		contentPane.add(regibtnNewButton_1);
		
		
		JLabel lblNewLabel_2 = new JLabel();//����
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setText("\u5BC6\u7801\u4E0D\u80FD\u4E3A\u7A7A");
		lblNewLabel_2.setBounds(288, 127, 83, 15);
		contentPane.add(lblNewLabel_2);
		if(textField.getText().length()==0){
			lblNewLabel_2.setText("���벻��Ϊ��");
			textField.requestFocus();
		}
		else lblNewLabel_2.setText(" ");
		
		JLabel lblNewLabel_3 = new JLabel("\u8D26\u53F7\u4E0D\u80FD\u4E3A\u7A7A");//�˺�
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(288, 58, 83, 15);
		contentPane.add(lblNewLabel_3);
		if(passwordField.getText().length()==0){
			lblNewLabel_3.setText("�˺Ų���Ϊ��");
			passwordField.requestFocus();
		}
		else lblNewLabel_3.setText(" ");
	}
	public static void login(String username,String password) {
		my db=new my();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			String sql="select * from gly where zh="+username+"and mm="+password;
			ResultSet rs=stm.executeQuery(sql); 
			if(rs.next()) { 
				JOptionPane.showMessageDialog(null, "��ӭ����������Ա");
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}   
	}
}
