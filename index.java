package test;
import java.awt.Container;
import java.awt.*; 
import javax.swing.*;


import javax.swing.JFrame;

public class index extends JFrame{
	
	index(){
		setTitle("메인 프레임");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton my_btn_1 = new JButton("확인");
		JButton my_btn_2 = new JButton("취소");
		
		c.add(my_btn_1);
		c.add(my_btn_2);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new index();
	}

}
