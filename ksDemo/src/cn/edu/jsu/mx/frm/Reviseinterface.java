package cn.edu.jsu.mx.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.mx.dbc.mysql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Reviseinterface extends JFrame {

	private JPanel contentPane;
	private JTextField xmtextField;
	private JTextField idtextField;
	private JTextField jftextField;
	private JTextField fzrtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reviseinterface frame = new Reviseinterface();
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
	public Reviseinterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("项目名称");
		label.setBounds(31, 24, 54, 15);
		contentPane.add(label);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(31, 60, 54, 15);
		contentPane.add(lblId);
		
		JLabel label_1 = new JLabel("项目经费");
		label_1.setBounds(31, 95, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("负责人");
		label_2.setBounds(31, 133, 54, 15);
		contentPane.add(label_2);
		
		xmtextField = new JTextField();
		xmtextField.setBounds(143, 21, 66, 21);
		contentPane.add(xmtextField);
		xmtextField.setColumns(10);
		
		idtextField = new JTextField();
		idtextField.setText("");
		idtextField.setBounds(143, 57, 66, 21);
		contentPane.add(idtextField);
		idtextField.setColumns(10);
		
		jftextField = new JTextField();
		jftextField.setText("");
		jftextField.setBounds(143, 92, 66, 21);
		contentPane.add(jftextField);
		jftextField.setColumns(10);
		
		fzrtextField = new JTextField();
		fzrtextField.setText("");
		fzrtextField.setBounds(143, 130, 66, 21);
		contentPane.add(fzrtextField);
		fzrtextField.setColumns(10);
		
		JButton revisebutton = new JButton("确定修改");
		String sql="select * from xm";
		revisebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String key=idtextField.getText().trim();
				String xm=xmtextField.getText().trim();
				String jf=jftextField.getText().trim();
				String fzr=fzrtextField.getText().trim();
				Connection conn=new mysql().getConnection();
				Statement state=null;
				try{
					state = conn.createStatement();
				}catch(SQLException b){
					b.printStackTrace();
				}
				if(key.length()!=0){
					String sql2="update xm set xmm="+("'"+xm+"'")+",id="+("'"+key+"'")+",jf="+("'"+jf+"'")+",fzr="+("'"+fzr+"'")+" where id="+key;
					try{
						state.executeUpdate(sql2);
					}catch(SQLException e1){
						e1.printStackTrace();
					}
				}JOptionPane.showMessageDialog(null, "修改信息成功");
				new Maininterface().main(null);
				dispose();
			}
			
		});
		revisebutton.setBounds(71, 198, 93, 23);
		contentPane.add(revisebutton);

		
		JButton qxbutton = new JButton("取消");
		qxbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Maininterface().main(null);
				dispose();
			}
		});
		qxbutton.setBounds(250, 198, 93, 23);
		contentPane.add(qxbutton);
	}

}
