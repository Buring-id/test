package cn.edu.jsu.mx.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.mx.dbc.Addinformation;
import cn.edu.jsu.mx.dbc.Insert;
import cn.edu.jsu.mx.vo.Xm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Addinterface extends JFrame {

	private JPanel contentPane;
	private JTextField xmmtextField;
	private JTextField jftextField_1;
	private JTextField fzrtextField_2;
	private JTextField idtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addinterface frame = new Addinterface();
					frame.setLocationRelativeTo(null);//窗体居中
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
	public Addinterface() {
		Xm user=new Xm();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("项目名称");
		label.setBounds(36, 45, 54, 15);
		contentPane.add(label);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(36, 86, 54, 15);
		contentPane.add(lblId);
		
		JLabel label_1 = new JLabel("项目经费");
		label_1.setBounds(36, 117, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("项目负责人");
		label_2.setBounds(36, 153, 75, 15);
		contentPane.add(label_2);
		
		xmmtextField = new JTextField();
		xmmtextField.setBounds(139, 42, 110, 21);
		contentPane.add(xmmtextField);
		xmmtextField.setColumns(10);
		
		jftextField_1 = new JTextField();
		jftextField_1.setBounds(139, 114, 110, 21);
		contentPane.add(jftextField_1);
		jftextField_1.setColumns(10);
		
		fzrtextField_2 = new JTextField();
		fzrtextField_2.setBounds(139, 150, 110, 21);
		contentPane.add(fzrtextField_2);
		fzrtextField_2.setColumns(10);
		
		idtextField = new JTextField();
		idtextField.setBounds(139, 83, 110, 21);
		contentPane.add(idtextField);
		idtextField.setColumns(10);
		
		JButton regibtnNewButton_1 = new JButton("注册");
		regibtnNewButton_1.setBounds(52, 194, 97, 23);
		regibtnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setXmm(xmmtextField.getText().trim());
				user.setId(idtextField.getText().trim());
				user.setJf(jftextField_1.getText().trim());
				user.setFzr(fzrtextField_2.getText().trim());
				new Addinformation().add(user);
				JOptionPane.showMessageDialog(null, "注册成功");
				new Maininterface().main(null);
				dispose();
			}
		});
		getContentPane().add(	regibtnNewButton_1);
		
		JButton qxbutton = new JButton("取消");
		qxbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Maininterface().main(null);
				dispose();
			}
		});
		qxbutton.setBounds(246, 194, 93, 23);
		contentPane.add(qxbutton);
		
	}
}
