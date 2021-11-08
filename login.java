package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{
	JButton check_btn;
	JPanel main_panel;
	JTextField name, class_nm, grade;
	
	public static String n, a, c;
	
	public login() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(5, 2));

		main_panel = new JPanel();
		JPanel name_panel = new JPanel();
		name_panel.add(new JLabel(" 이름 : "));
		name = new JTextField(20);
		name_panel.add(name);
		
		JPanel grade_panel = new JPanel();
		grade_panel.add(new JLabel(" 학년 : "));
		grade = new JTextField(3);
		grade_panel.add(grade);
		
		JPanel class_nm_panel = new JPanel();
		class_nm_panel.add(new JLabel(" 반 : "));
		class_nm = new JTextField(3);
		class_nm_panel.add(class_nm);
		
		this.add(name_panel);
		add(grade_panel);
		add(class_nm_panel);
		check_btn = new JButton("확인");
		add(check_btn);
		check_btn.addActionListener(this);

		add(main_panel);
		setSize(500, 300);
		setVisible(true);
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == check_btn) {
			n = name.getText();
			a = grade.getText();
			c = class_nm.getText();
			setVisible(false);
			new index();
		}
	}
}
