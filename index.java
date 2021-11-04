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

public class index extends JFrame implements ActionListener{
	JPanel main_panel;
	JButton exit_btn, timetable_btn, calendar_btn, check_btn;
	JTextField name, age;
	JLabel name_label, grade_label;
	
	String n, a;
	
	public index() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(5, 2));
		
		JPanel name_panel = new JPanel();
		name_panel.add(new JLabel(" 이름 : "));
		name = new JTextField(20);
		name_panel.add(name);
		
		JPanel age_panel = new JPanel();
		age_panel.add(new JLabel(" 학년 : "));
		age = new JTextField(3);
		age_panel.add(age);
		
		this.add(name_panel);
		add(age_panel);
		check_btn = new JButton("확인");
		add(check_btn);
		check_btn.addActionListener(this);
		
		setSize(1280, 720);
		setTitle("선린 인터넷 고등학교");
		
		name_label = new JLabel("이름");
		grade_label = new JLabel("학년");
		main_panel = new JPanel();
		calendar_btn = new JButton("급식");
		exit_btn = new JButton("종료");
		timetable_btn = new JButton("시간표");
		
		calendar_btn.addActionListener(this);
		exit_btn.addActionListener(this);
		timetable_btn.addActionListener(this);
		
		main_panel.add(calendar_btn);
		main_panel.add(exit_btn);
		main_panel.add(name_label);
		main_panel.add(grade_label);
		main_panel.add(timetable_btn);
		
		add(main_panel);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == calendar_btn) {
			setVisible(false);
			new calendar();
		}
		else if(obj == exit_btn) {
			System.exit(0);
		}
		else if(obj == timetable_btn) {
			setVisible(false);
			new timetable();
		}
		else if(obj == check_btn) {
			n = name.getText();
			a = age.getText();
			name_label.setText(n);
			grade_label.setText(a+"학년");
		}
	}
	
	public static void main(String[] args) {
		new index();
	}

}
