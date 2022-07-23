package Java8.model;

public class Hobbies {

	private String hobbiesName;

	public Hobbies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hobbies(String hobbiesName) {
		super();
		this.hobbiesName = hobbiesName;
	}

	public String getHobbiesName() {
		return hobbiesName;
	}

	public void setHobbiesName(String hobbiesName) {
		this.hobbiesName = hobbiesName;
	}

	@Override
	public String toString() {
		return "Hobbies [hobbiesName=" + hobbiesName + "]";
	}


	
	
}
