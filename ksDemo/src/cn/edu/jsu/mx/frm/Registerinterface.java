package cn.edu.jsu.mx.frm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.edu.jsu.mx.dbc.Insert;
import cn.edu.jsu.mx.vo.Gly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Registerinterface {
	private static JTextField xmtextField;
	private static JTextField xbextField_1;
	private static JTextField nltextField_2;
	private static JTextField zhtextField_3;
	private static JTextField mmtextField_4;
public static void main(String[] args){
	Gly user=new Gly();
	JFrame frame=new JFrame("×¢²áÒ³Ãæ");
	frame.setBounds(100,100,450,300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	
	JLabel label = new JLabel("\u59D3\u540D");
	label.setBounds(27, 31, 54, 15);
	frame.getContentPane().add(label);
	
	JLabel label_1 = new JLabel("\u6027\u522B");
	label_1.setBounds(27, 66, 54, 15);
	frame.getContentPane().add(label_1);
	
	JLabel label_2 = new JLabel("\u5E74\u9F84");
	label_2.setBounds(27, 99, 54, 15);
	frame.getContentPane().add(label_2);
	
	JLabel label_3 = new JLabel("\u8D26\u53F7");
	label_3.setBounds(27, 132, 54, 15);
	frame.getContentPane().add(label_3);
	
	JLabel label_4 = new JLabel("\u5BC6\u7801");
	label_4.setBounds(27, 166, 54, 15);
	frame.getContentPane().add(label_4);
	
	xmtextField = new JTextField();
	xmtextField.setBounds(91, 28, 66, 21);
	frame.getContentPane().add(xmtextField);
	xmtextField.setColumns(10);
	
	xbextField_1 = new JTextField();
	xbextField_1.setBounds(91, 63, 66, 21);
	frame.getContentPane().add(xbextField_1);
	xbextField_1.setColumns(10);
	
	nltextField_2 = new JTextField();
	nltextField_2.setBounds(91, 96, 66, 21);
	frame.getContentPane().add(nltextField_2);
	nltextField_2.setColumns(10);
	
	zhtextField_3 = new JTextField();
	zhtextField_3.setBounds(91, 129, 66, 21);
	frame.getContentPane().add(zhtextField_3);
	zhtextField_3.setColumns(10);
	
	mmtextField_4 = new JTextField();
	mmtextField_4.setBounds(91, 163, 66, 21);
	frame.getContentPane().add(mmtextField_4);
	mmtextField_4.setColumns(10);
	
	JButton regibtnNewButton_1 = new JButton("×¢²á");
	regibtnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			user.setXm(xmtextField.getText().trim());
			user.setXb(xbextField_1.getText().trim());
			user.setNl(nltextField_2.getText().trim());
			user.setZh(zhtextField_3.getText().trim());
			user.setMm(mmtextField_4.getText().trim());
			new Insert().add(user);
			JOptionPane.showMessageDialog(null, "×¢²á³É¹¦");
			new Recordinterface().main(null);
			frame.dispose();
		}
	});
	regibtnNewButton_1.setBounds(216, 186, 97, 23);
	frame.getContentPane().add(	regibtnNewButton_1);
	
}
}
