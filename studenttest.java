package test;

public abstract class studenttest implements student{

	@Override
	public String getName(String[] name, int idx) {
		return name[idx];
	}
	
	@Override
	public int getAge(int[] age, int idx) {
		return age[idx];
	}

}
