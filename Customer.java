
public class Customer {
//fields 
	private String name; 
	private int age = 0;
	
//parametrized constructor 
	public Customer(String n, int a) {
		this.name = n; 
		this.age =  a;
	}
	
//copy constructor
	public Customer(Customer c) {
		this.name = c.name; 
		this.age = c.age;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
