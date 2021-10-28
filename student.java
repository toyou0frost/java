package test;

public interface student {
	
	String getName(String[] name, int idx);
	int getAge(int[] age, int idx);
	
	default void data() {
		System.out.println("test");
	}
}
