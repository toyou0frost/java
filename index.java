package project;
import static project.getTimetableAPI.all_ti_ymd;
import static project.getTimetableAPI.itrt_cntnt;
import static project.getTimetableAPI.perio;
import static project.getlunchAPI.ddish_nm;
import static project.getlunchAPI.mlsv_ymd;
import static project.login.a;
import static project.login.n;
import static project.adminLogin.a_t;
import static project.adminLogin.n_t;
import static project.adminLogin.isT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

// 사용자에게 가장 먼저 보여질 화면
public class index extends JFrame implements ActionListener{
	JPanel main_panel;
	JButton exit_btn, timetable_btn, login_btn, admin_btn;
	JTable table;
	JLabel lunch, lunch_title, title;
	
	public index() {
		boolean islunch = false;
		// 오늘의 급식을 불러오기 위해 현재 날짜를 구하는 코드 48 ~ 50 
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		String today = sdf.format(date);
		
		// 현재 날짜를 토대로 파싱해온 api 데이터와 비교하여 같은 날짜를 찾아 index 번호를 알아내는 코드 53 ~ 64
		int index = 0;
		for(int i = 0; i < mlsv_ymd.length; i++) {
			if(mlsv_ymd[i] == null) {
				islunch = false;
				break;
			}
			if(mlsv_ymd[i].equals(today)) {
				index = i;
				islunch = true;
				break;
			}
		}
		title = new JLabel("선린인");
		title.setFont(new Font("116watermelon", Font.BOLD, 50));
		
		setSize(1280, 720);
		setTitle("선린인 [ Sunrin Information ]");
		
		// 오늘 급식 정보가 존재한다면 오늘의 점심 메뉴를 label에 저장하고 없다면 다른 코멘트를 저장하는 코드 72 ~ 77
		if(islunch) {
			lunch = new JLabel("<html>" + ddish_nm[index] + "</html>");
		}
		else {
			lunch = new JLabel("등록된 급식정보가 없습니다.");
		}

		lunch_title = new JLabel("오늘의 급식");
		login_btn = new JButton("로그인");
		main_panel = new JPanel();
		exit_btn = new JButton("종료");
		timetable_btn = new JButton("시간표");
		
		// 관리자 계정으로 로그인할 경우 관리자 페이지로 이동할 수 있는 버튼을 생성하는 코드 86 ~ 92
		if(isT) {
			admin_btn = new JButton("관리자 페이지");
			admin_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 22));
			admin_btn.setBounds(980, 150, 200, 50);
			admin_btn.addActionListener(this);
			main_panel.add(admin_btn);
		}
		
		// 폰트 설정 95 ~ 99
		lunch.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));
		lunch_title.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 22));
		login_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));
		exit_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));
		timetable_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));

		// layout 설정 102 ~ 109
		main_panel.setLayout(null);
		
		title.setBounds(600, -25, 200, 200);
		lunch_title.setBounds(550, 200, 200, 100);
		lunch.setBounds(550, 220, 300, 300);
		login_btn.setBounds(380, 150, 150, 50);
		exit_btn.setBounds(580, 150, 150, 50);
		timetable_btn.setBounds(780, 150, 150, 50);
		
		// 버튼 클릭 이벤트 112 ~ 114
		login_btn.addActionListener(this);
		exit_btn.addActionListener(this);
		timetable_btn.addActionListener(this);
		
		// 오브젝트와 panel 연결 117 ~ 122
		main_panel.add(title);
		main_panel.add(lunch_title);
		main_panel.add(lunch);
		main_panel.add(login_btn);
		main_panel.add(timetable_btn);
		main_panel.add(exit_btn);
		
		// 화면에 panel 출력 125 ~ 126
		add(main_panel);
		setVisible(true);
	}

	// 버튼 클릭이벤트 130 ~ 152
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == exit_btn) {
			// 프로그램을 종료하는 코드
			System.exit(0);
		}
		else if(obj == timetable_btn) {
			// 시간표 클래스로 이동하는 코드 139 ~ 140
			setVisible(false);
			new timetable();
		}
		else if (obj == login_btn) {
			// login 클래스로 이동하는 코드 144 ~ 145
			setVisible(false);
			new login();
		}
		else if (obj == admin_btn) {
			// admin 클래스로 이동하는 코드 149 ~ 150
			setVisible(false);
			new admin();
		}
	}

	public static void main(String[] args) {
		// 코드가 처음 실행되면 api들을 호출하는 코드 156 ~ 159
		getlunchAPI lunchapi = new getlunchAPI();
		getTimetableAPI timetableapi = new getTimetableAPI();
		lunchapi.main();
		timetableapi.main();
		new index();
	}
	
}
