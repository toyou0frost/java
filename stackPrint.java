package project;

import static project.admin.name_stack;
import static project.admin.num_stack;

public class stackPrint {
	public stackPrint() {
		// stack에 데이터가 들어오면 가장 상단의 데이터를 출력하는 함수 9 ~ 16
		System.out.println("##############");
		if(!name_stack.empty()) {
			System.out.println("이름 : "+name_stack.peek());	
		}	 
		if(!num_stack.empty()) {
			System.out.println("학번 : "+num_stack.peek());	
		}
		System.out.println("##############");
	}
}
