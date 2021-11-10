package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import static project.admin.name_stack;
import static project.admin.num_stack;

// 원래 테이블을 활용하여 스텍의 값들을 표현하려 했지만 구현에 실패하여 지금은 쓰이지 않는 코드
public class adminTable extends JFrame implements ActionListener{

	JButton exit_btn;
	JPanel main_panel;
	JTable table;
	
	public adminTable() {
		List<String[]> itemList = new ArrayList<String[]>();
		if(!(num_stack.empty()) && !(name_stack.empty())) {
			if(num_stack.size() == name_stack.size()) {
				int tmp = num_stack.size();
;				for(int i=0; i < tmp; i++)  {
					itemList.add(new String[]{name_stack.pop(),num_stack.pop()});
				}
			}
		}

		String[] header = {"학생", "학번"};	
		String[][] items = new String[itemList.size()][];
		for(int i = 0; i < itemList.size(); i++) {
			String[] row = itemList.get(i);
			items[i] = new String[row.length];
			for(int j = 0; j < row.length; j++) {
				items[i][j] = row[j];
			}
		}
		
		exit_btn = new JButton("돌아가기");
		main_panel = new JPanel();
		table = new JTable(items, header);
		
		main_panel.setLayout(null);
		
		
		table.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 12));
		exit_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true); 

		exit_btn.setBounds(580, 50, 150, 50);
		scrollPane.setBounds(150, 180, 1000, 200);

		exit_btn.addActionListener(this);
		
		main_panel.add(exit_btn);
		main_panel.add(scrollPane);
		
		add(main_panel);
		setSize(1280, 720);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == exit_btn) {
			setVisible(false);
			new admin();
		}
	}
}
