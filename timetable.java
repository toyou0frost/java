package test;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.io.IOException; 
import java.net.URI; 
import java.net.URISyntaxException; 
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class timetable extends JFrame implements ActionListener {
	
	JButton timetable_web_btn;
	JButton exit_btn;
	JPanel main_panel;
	
	public timetable() {
		exit_btn = new JButton("돌아가기");
		timetable_web_btn = new JButton("웹으로 보기");
		main_panel = new JPanel();
		
		exit_btn.addActionListener(this);
		timetable_web_btn.addActionListener(this);
		
		main_panel.add(timetable_web_btn);
		main_panel.add(exit_btn);
		
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
