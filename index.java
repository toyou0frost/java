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

import static test.login.n;
import static test.login.a;

public class index extends JFrame implements ActionListener{
	JPanel main_panel;
	JButton exit_btn, timetable_btn, calendar_btn, login_btn;

	public index() {

		setSize(1280, 720);
		setTitle("선린 인터넷 고등학교");
		
		login_btn = new JButton("로그인");
		main_panel = new JPanel();
		calendar_btn = new JButton("급식");
		exit_btn = new JButton("종료");
		timetable_btn = new JButton("시간표");
		
		login_btn.addActionListener(this);
		calendar_btn.addActionListener(this);
		exit_btn.addActionListener(this);
		timetable_btn.addActionListener(this);
		
		main_panel.add(login_btn);
		main_panel.add(calendar_btn);
		main_panel.add(exit_btn);
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
		else if (obj == login_btn) {
			setVisible(false);
			new login();
		}
	}

	public static void main(String[] args) {
		new index();
	}
	
}
