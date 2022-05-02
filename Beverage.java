
public abstract class Beverage {
	private String name;
	private TYPE type;
	private SIZE size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0;
	
	//Paramatarized constructor
	public Beverage(String n, SIZE s, TYPE t) {
		this.name = n;
		this.size = s;
		this.type = t;
	}

  //Copy constructor 
  public Beverage(Beverage b){
    this.name = b.name;
    this.type = b.type;
    this.size = b.size;
  }
	
	//abstract method that returns a double
	public abstract double calcPrice();

	

	@Override
	public String toString() {
		return "Beverage:" + name + ", size:" + size;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean equals = false;
		
		Beverage b = (Beverage) obj;
		
		if(this.name.equals(b.name) && this.size.equals(b.size) && this.type.equals(b.type)) {
			equals = true;
		}
		return equals;
	}



	
	
	
	//getters and setters
	public String getBevName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public SIZE getSize() {
		return size;
	}

	public void setSize(SIZE size) {
		this.size = size;
	}
	
	public double getBASE_PRICE() {
		return BASE_PRICE;
	}

	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}
	
}
