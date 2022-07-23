package Java8.model;



public class Employee {

	private String empName;
	private int noOfKids;
	private String city;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empName, int noOfKids, String city) {
		super();
		this.empName = empName;
		this.noOfKids = noOfKids;
		this.city = city;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getNoOfKids() {
		return noOfKids;
	}
	public void setNoOfKids(int noOfKids) {
		this.noOfKids = noOfKids;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", noOfKids=" + noOfKids + ", city=" + city + "]";
	}
	
	
}
