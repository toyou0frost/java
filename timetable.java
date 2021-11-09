package test;
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
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static test.login.n;
import static test.login.a;
import static test.login.c;

import static test.getTimetableAPI.all_ti_ymd; // 날짜
import static test.getTimetableAPI.itrt_cntnt; // 과목
import static test.getTimetableAPI.perio; // 교시

public class timetable extends JFrame implements ActionListener {
	
	JButton timetable_web_btn, exit_btn;
	JLabel name, grade, class_nm;
	JPanel main_panel;
	JTable table;
	
	public timetable() {
		Dimension dim = new Dimension(400, 150);
		exit_btn = new JButton("돌아가기");
		timetable_web_btn = new JButton("웹으로 보기");
		main_panel = new JPanel();
		name = new JLabel(n);
		grade = new JLabel(a+"학년");
		class_nm = new JLabel(c+"반");
		
		String header[] = {"시간표", "월", "화", "수", "목", "금"};
		
		String contents[][] = new String[7][8];
		
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
		
		JScrollPane scrollpane = new JScrollPane(table);
		
		exit_btn.addActionListener(this);
		timetable_web_btn.addActionListener(this);
		
		main_panel.add(timetable_web_btn);
		main_panel.add(exit_btn);
		main_panel.add(name);
		main_panel.add(grade);
		main_panel.add(class_nm);
		main_panel.add(scrollpane);
		
		add(main_panel);
		setSize(1280, 720);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
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
