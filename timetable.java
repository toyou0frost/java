package project;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.io.IOException; 
import java.net.URI; 
import java.net.URISyntaxException;

import static project.getTimetableAPI.all_ti_ymd;
import static project.getTimetableAPI.itrt_cntnt;
import static project.getTimetableAPI.perio;
import static project.login.a;
import static project.login.c;
import static project.login.n;

import static project.adminLogin.a_t;
import static project.adminLogin.n_t;
import static project.adminLogin.c_t;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timetable extends JFrame implements ActionListener {
	
	JButton timetable_web_btn, exit_btn;
	JLabel name, grade, class_nm;
	JPanel main_panel;
	JTable table;
	
	// 시간표를 출력하는 클래스
	public timetable() {
		setTitle("선린인 [ Sunrin Information ] 시간표");
		exit_btn = new JButton("돌아가기");
		timetable_web_btn = new JButton("웹으로 보기");
		main_panel = new JPanel();
		name = new JLabel(n);
		grade = new JLabel(a+"학년");
		class_nm = new JLabel(c+"반");
		main_panel.setLayout(null);
		String header[] = {"교시", "월", "화", "수", "목", "금"};
		
		String contents[][] = new String[7][8];
		
		// api로 가져온 시간표를 table로 표현하기위해 2차원 배열로 변환하는 코드 55 ~ 70
		int tmp = 0;
		
		for(int i = 0; i < 7; i++) {
			tmp = i;
			for(int j = 0; j < 8; j++) {
				if(j == 0) {
					contents[i][j] = Integer.toString(i+1);
					continue;
				}
				if(tmp >= 34) {
					break;
				}
				contents[i][j] = itrt_cntnt[tmp];
				tmp+=7;
			}
		}
		
		table = new JTable(contents, header);
		// 각 행의 높이를 지정 74
		table.setRowHeight(25);
		table.getColumn("월").setPreferredWidth(200);
		table.getColumn("화").setPreferredWidth(200);
		table.getColumn("수").setPreferredWidth(200);
		table.getColumn("목").setPreferredWidth(200);
		table.getColumn("금").setPreferredWidth(200);
		
		// 폰트 설정 82 ~ 87
		table.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 12));
		timetable_web_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		exit_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		name.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		class_nm.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		grade.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		
		// 테이블을 정상적으로 처리하기 위한 코드 add(table)을 바로 실행하면 오류가 생길 수 있음 90 ~ 91
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true); 
		
		// layout 설정 94 ~ 99
		scrollPane.setBounds(150, 180, 1000, 200);
		timetable_web_btn.setBounds(350, 100, 150, 30);
		exit_btn.setBounds(550, 100, 100, 30);
		name.setBounds(700, 100, 50, 50);
		class_nm.setBounds(800, 100, 50, 50);
		grade.setBounds(750, 100, 50, 50);
		
		// 버튼 클릭이벤트 102 ~ 103
		exit_btn.addActionListener(this);
		timetable_web_btn.addActionListener(this);
		
		// 판넬 설정 106 ~ 115
		main_panel.add(timetable_web_btn);
		main_panel.add(exit_btn);
		main_panel.add(name);
		main_panel.add(grade);
		main_panel.add(class_nm);
		main_panel.add(scrollPane);
		
		add(main_panel);
		setSize(1280, 720);
		setVisible(true);
	}
	
	// 버튼 클릭이벤트 119 ~ 137
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 시간표 api호출에 실패할 경우를 대비하여 웹상에서 시간표를 보여주는 코드 (현재는 2학년 6반만 구현되어있음) 123 ~ 131
		if (obj == timetable_web_btn) {
			try {
				Desktop.getDesktop().browse(new URI("https://timetable-2aace.web.app/"));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e2) {
				e2.printStackTrace();
			}
		}
		else if(obj == exit_btn) {
			setVisible(false);
			new index();
		}
		
	}

}
