package test;
import java.awt.Container;
import java.awt.*; 
import javax.swing.*;


import javax.swing.JFrame;

public class index extends JFrame{
	
	public index() {
		setTitle("메인 프레임");
		setSize(1280 , 720);
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
		int[] age = {16, 17, 18, 16};
		String[] name = {"정원영", "이창학", "윤도현", "나제원"};
		
		interfacetest getstudent = new interfacetest();
		System.out.println(getstudent.getName(name, 3));
		System.out.println(getstudent.getAge(age, 3));
		new index();
	}

}
