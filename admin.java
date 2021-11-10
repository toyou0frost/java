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


@SuppressWarnings("serial")
public class admin extends JFrame implements ActionListener{
	JPanel main_panel;
	JButton print_btn, exit_btn, add_name_btn, add_num_btn, del_btn, table_btn;
	JLabel lunch, lunch_title, title;
	JTextField name, num;
	
	public static Stack<String> name_stack = new Stack<>();
	public static Stack<String> num_stack = new Stack<>();
	
	public admin() {
		// JFrame 기본 설정 (화면 사이즈와 frame title)
		setSize(1280, 720);
		setTitle("선린인 [ Sunrin Information ] 관리자");
		
		// 버튼, 텍스트 필드 등 JFrame에 있는 오브젝트 생성 35 ~ 43
		print_btn = new JButton("데이터 보기");
		table_btn = new JButton("데이터 보기");
		main_panel = new JPanel();
		exit_btn = new JButton("돌아가기");
		add_name_btn = new JButton("학생 추가");
		add_num_btn = new JButton("학번 추가");
		del_btn = new JButton("학생 삭제");
		name = new JTextField("이름");
		num = new JTextField("학번");

		// 오브젝트들의 폰트 지정 46 ~ 50 
		table_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));
		exit_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));
		add_name_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));
		add_num_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));
		del_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 18));

		// 오브젝트들의 Layout 지정 53 ~ 60
		print_btn.setBounds(530, 50, 150, 50);
		table_btn.setBounds(530, 50, 150, 50);
		name.setBounds(220, 150, 150, 50);
		num.setBounds(380, 150, 150, 50);
		add_name_btn.setBounds(540, 150, 150, 50);
		add_num_btn.setBounds(530, 150, 150, 50);
		del_btn.setBounds(730, 150, 150, 50);
		exit_btn.setBounds(930, 150, 150, 50);

		// 판넬의 레이아웃을 null로 해줘야 setBounds를 통해 Layout 지정이 가능함 63
		main_panel.setLayout(null);

		// 버튼 클릭이벤트 연결 66 ~ 71 
		print_btn.addActionListener(this);
		table_btn.addActionListener(this);
		add_name_btn.addActionListener(this);
		add_num_btn.addActionListener(this);
		del_btn.addActionListener(this);
		exit_btn.addActionListener(this);
		
		// 오브젝트들을 판넬에 추가 74 ~ 81
//		main_panel.add(table_btn);
//		main_panel.add(print_btn);
		main_panel.add(name);
		main_panel.add(num);
		main_panel.add(exit_btn);
		main_panel.add(add_name_btn);
//		main_panel.add(add_num_btn);
		main_panel.add(del_btn);

		// 판넬을 화면에 보여줌 84 ~ 85
		add(main_panel);
		setVisible(true);
	}

	// 버튼 클릭이벤트 
	@Override
	public void actionPerformed(ActionEvent e) {
		// 현재 클릭된 버튼의 소스를 obj 변수에 저장해줌 92
		Object obj = e.getSource();
		// obj 변수와 실제 버튼의 코드를 비교하여 어떠한 버튼이 클릭되었는지 확인 94 ~ 119
		if(obj == exit_btn) {
			// 현재 보여지고있는 admin frame을 끄고 index 클래스를 호출하여 기본화면으로 돌아감 96 ~ 97
			setVisible(false);
			new index();
		}
		else if(obj == add_name_btn) {
			// name_stack과 num_stack에 현재 name 텍스트 필드와 num 텍스트 필드에 있는 데이터를 저장해주고 출력함 101 ~ 103
			name_stack.push(name.getText());
			num_stack.push(num.getText());
			new stackPrint();
		}
		else if(obj == add_num_btn) {
			// 코드가 수정되면서 사용하지 않는 코드 
			new stackPrint();
		}
		else if(obj == del_btn) {
			// name_stack과 num_stack의 데이터를 하나씩 삭제하고 가장 위에있는 데이터를 출력
			name_stack.pop();
			num_stack.pop();
			new stackPrint();
		}
		else if(obj == table_btn) {
			// 코드가 수정되면서 사용하지 않는 코드
			setVisible(false);
			new adminTable();
		}
	}
}
