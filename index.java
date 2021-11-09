package test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
import static test.getlunchAPI.ddish_nm; // 급식
import static test.getlunchAPI.mlsv_ymd; // 급식 요일
import static test.getTimetableAPI.all_ti_ymd;
import static test.getTimetableAPI.itrt_cntnt;
import static test.getTimetableAPI.perio;

public class index extends JFrame implements ActionListener{
	JPanel main_panel;
	JButton exit_btn, timetable_btn, login_btn;
	JTable table;
	JLabel lunch;
	
	public index() {
		boolean islunch = false;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		String today = sdf.format(date);
		int index = 0;
		for(int i = 0; i < mlsv_ymd.length; i++) {
			if(mlsv_ymd[i] == null) {
				islunch = false;
				break;
			}
			if(mlsv_ymd[i].equals(today)) {
				System.out.println(ddish_nm[i]);
				index = i;
				islunch = true;
				break;
			}
		}
		setSize(1280, 720);
		setTitle("선린 인터넷 고등학교");
		if(islunch) {
			lunch = new JLabel("<html>" + ddish_nm[index] + "</html>");
		}
		else {
			lunch = new JLabel("등록된 급식정보가 없습니다.");
		}
		login_btn = new JButton("로그인");
		main_panel = new JPanel();
		exit_btn = new JButton("종료");
		timetable_btn = new JButton("시간표");
		
		login_btn.addActionListener(this);
		exit_btn.addActionListener(this);
		timetable_btn.addActionListener(this);
		
		main_panel.add(lunch);
		main_panel.add(login_btn);
		main_panel.add(exit_btn);
		main_panel.add(timetable_btn);
		
		add(main_panel);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == exit_btn) {
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
		getlunchAPI lunchapi = new getlunchAPI();
		getTimetableAPI timetableapi = new getTimetableAPI();
		lunchapi.main();
		timetableapi.main();
		new index();
	}
	
}
