package cn.edu.jsu.mx.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.mx.dao.TxtDao;
import cn.edu.jsu.mx.dbc.Addinformation;
import cn.edu.jsu.mx.vo.xm;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Maininterface extends JFrame {
	private JPanel contentPane;
	String zh;
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maininterface frame = new Maininterface();
					frame.setLocationRelativeTo(null);//�������
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Maininterface() {
		xm user=new xm();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("��Ŀ��Ϣ");
		menuBar.add(menu);
		
		JMenuItem momenuItem_3 = new JMenuItem("�޸���Ϣ");
		momenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reviseinterface().main(null);
				dispose();
			}
		});
		menu.add(momenuItem_3);
		
		JMenuItem findmenuItem_1 = new JMenuItem("��ѯ��Ϣ");
		findmenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Selectinterface().main(null);
				dispose();
			}
		});
		menu.add(findmenuItem_1);
		
		JMenuItem deletemenuItem_2 = new JMenuItem("ɾ����Ϣ");
		deletemenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Selectinterface().main(null);
				dispose();
			}
		});
		menu.add(deletemenuItem_2);
		
		JMenuItem addmenuItem = new JMenuItem("������Ϣ");//������Ŀ��Ϣ
		addmenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Addinterface().main(null);
				dispose();
			}
		});
		menu.add(addmenuItem);
		
		JMenu menu_1 = new JMenu("������Ϣ");
		menuBar.add(menu_1);
		
		JMenuItem mntmExcel = new JMenuItem("�ı��ĵ�");
		mntmExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new TxtDao().export();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		menu_1.add(mntmExcel);
		
		JMenu menu_2 = new JMenu("ʱ��");
		menuBar.add(menu_2);
		
		
		
		JMenuItem timemenuItem = new JMenuItem("��ʾʱ��");
		timemenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dateinterface().main(null);
				dispose();
			}
		});
		menu_2.add(timemenuItem);
		
		JMenu menu_3 = new JMenu("�˳�");
		menuBar.add(menu_3);
		
		JMenuItem menuItem = new JMenuItem("ȷ���˳�");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		menu_3.add(menuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u2501(*\uFF40\u2200\u00B4*)\u30CE\u4EBB!\u4F7F\u7528");
		label.setBounds(10, 45, 424, 110);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("΢���ź�", Font.PLAIN, 38));
		contentPane.add(label);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		
	}
	
}
