package cn.edu.jsu.mx.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dateinterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dateinterface frame = new Dateinterface();
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
	String zh;
	
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public Dateinterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u65F6\u95F4");
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		label_3.setBackground(new Color(240, 240, 240));
		label_3.setBounds(163, 37, 116, 43);
		contentPane.add(label_3);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Maininterface().main(null);
				dispose();
			}
		});
		button.setBounds(284, 209, 93, 23);
		contentPane.add(button);
		
		JLabel lblZh = new JLabel(zh);
		lblZh.setBounds(153, 47, 54, 15);
		contentPane.add(lblZh);
		
		String a=gettime();
		JLabel lblTime = new JLabel(a);
		lblTime.setFont(new Font("宋体", Font.PLAIN, 18));
		lblTime.setBounds(127, 107, 181, 43);
		contentPane.add(lblTime);
		
	}
	public static String gettime(){
		SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return a.format(new Date());
		
	}
}
