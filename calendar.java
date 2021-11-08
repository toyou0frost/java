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
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class calendar extends JFrame implements ActionListener{

	JPanel topPane = new JPanel();
		JButton exit_btn = new JButton("뒤로가기");
		JLabel yearLbl = new JLabel("년");
		JLabel monthLbl = new JLabel("월");
		
		Calendar cal = Calendar.getInstance();
		
		JLabel yearCombo = new JLabel();
		JLabel monthCombo = new JLabel();
		
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel titlePane = new JPanel(new GridLayout(1, 7));
			String titleStr[] = {"일", "월", "화", "수", "목", "금", "토"};
		JPanel datePane = new JPanel(new GridLayout(0, 7));

	Calendar now;
	int year, month, date;
	
	public calendar() {
		yearCombo.setFont(new Font("Serif", Font.PLAIN, 14));
		monthCombo.setFont(new Font("Serif", Font.PLAIN, 14));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		now =  Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH) + 1;
		date = now.get(Calendar.DATE);

		exit_btn.setPreferredSize(new Dimension(90, 30));
		topPane.add(exit_btn);
		
		yearCombo.setText(String.valueOf(year));
		monthCombo.setText(String.valueOf(month));

		topPane.add(yearCombo);
		
		topPane.add(yearLbl);
		
		topPane.add(monthCombo);
		
		topPane.add(monthLbl);
		
		
		exit_btn.addActionListener(this);
		
		topPane.setBackground(new Color(100, 200, 200));
		add(topPane, "North");
		
		titlePane.setBackground(Color.white);
		for(int  i = 0; i < titleStr.length; i++) {
			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);
			lbl.setFont(new Font("Serif", Font.PLAIN, 20));
			if(i == 0) {
				lbl.setForeground(Color.red);
			}
			else if(i == 6) {
				lbl.setForeground(Color.blue);
			}
			titlePane.add(lbl);
		}
		centerPane.add(titlePane, "North");
		dayPrint(year, month);
		centerPane.add(datePane, "Center");
		
		add(centerPane, "Center");
		
		setSize(1280, 720);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == exit_btn) {
			setVisible(false);
			new index();
		}
	}
	
	public void createDayStart() {
		datePane.setVisible(false);
		datePane.removeAll();
		datePane.setVisible(true);
	}
	
	public void dayPrint(int y, int m) {
		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i = 1; i < week; i++) {
			datePane.add(new JLabel(" "));
		}
		for(int i = 1; i <= lastDate; i++) {
			JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);
			lbl.setFont(new Font("Serif", Font.PLAIN, 18));
			cal.set(y, m-1, i);
			int outWeek = cal.get(Calendar.DAY_OF_WEEK);
			if(outWeek == 1) {
				lbl.setForeground(Color.red);
			}
			else if(outWeek == 7) {
				lbl.setForeground(Color.BLUE);
			}
			datePane.add(lbl);
		}
	}
}
