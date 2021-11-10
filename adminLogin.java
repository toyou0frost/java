package project;

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

public class adminLogin extends JFrame implements ActionListener{
	JButton check_btn, admin_btn;
	JPanel main_panel;
	JTextField name, class_nm, grade;
	
	public static String n_t, a_t, c_t;
	public static Boolean isT = false;
	
	// 관리자 권한으로 로그인하는 페이지
	public adminLogin() {
		setTitle("선린인 [ Sunrin Information ] 관리자 로그인");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(5, 2));

		// main_panel에 사용될 버튼, 텍스트필드, 라벨등을 설정 39 ~ 68
		main_panel = new JPanel();
		JPanel name_panel = new JPanel();
		JLabel name_label = new JLabel(" 이름 : ");
		name_label.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		name_panel.add(name_label);
		name = new JTextField(20);
		name_panel.add(name);
		
		JPanel grade_panel = new JPanel();
		JLabel grade_label = new JLabel(" 학년 : ");
		grade_label.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		grade_panel.add(grade_label);
		grade = new JTextField(3);
		grade_panel.add(grade);
		
	
		JPanel class_nm_panel = new JPanel();
		JLabel class_label = new JLabel(" 반 :  ");
		class_label.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		class_nm_panel.add(class_label);
		class_nm = new JTextField(3);
		class_nm_panel.add(class_nm);
		
		this.add(name_panel);
		add(grade_panel);
		add(class_nm_panel);
		check_btn = new JButton("확인");
		check_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 20));
		add(check_btn);
		check_btn.addActionListener(this);
		
		// main_panel을 화면에 띄워줌 71 ~ 73
		add(main_panel);
		setSize(500, 300);
		setVisible(true);
		}
	
	// 버튼 클릭이벤트에 대한 설정 77 ~ 91
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == check_btn) {
			// 텍스트 필드에 들어온 값들을 각각의 static 변수에 저장 후 시간표 api 호출한 뒤 메인 클래스로 이동 82 ~ 89 
			n_t = name.getText();
			a_t = grade.getText();
			c_t = class_nm.getText();
			isT = true;
			getTimetableAPI timetableapi = new getTimetableAPI();
			timetableapi.main();
			setVisible(false);
			new index();
		}
	}
}
