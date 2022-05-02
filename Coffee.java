
public class Coffee extends Beverage {
	private final double EXTRA_SHOT_PRICE = 0.5;
	private final double EXTRA_SYRUP_PRICE = 0.5;
	private boolean extra_Shot = false;
	private boolean containsExtraSyrup = false;
	
	
	public Coffee(String n, SIZE s, boolean extraShot, boolean extraSysup) {
		super(n, s, TYPE.COFFEE);
		this.containsExtraSyrup = extraSysup;
		this.extra_Shot = extraShot;
		// TODO Auto-generated constructor stub
	}

  public Coffee(Coffee c) {
		super(c.getBevName(), c.getSize(), TYPE.COFFEE);
		this.containsExtraSyrup = c.getExtraSyrup();
		this.extra_Shot = c.getExtraShot();
		// TODO Auto-generated constructor stub
	}


	@Override
	public double calcPrice() {
		double price = 0;
		switch(getSize()) {
		case SMALL: 
			if (extra_Shot == false && containsExtraSyrup == false) {
				price+=getBASE_PRICE();
			}else if(extra_Shot == true && containsExtraSyrup == false) {
				price+=getBASE_PRICE() + EXTRA_SHOT_PRICE;
			}else if(extra_Shot == true && containsExtraSyrup == true) {
				price+=getBASE_PRICE() + EXTRA_SHOT_PRICE + EXTRA_SYRUP_PRICE;
			}else if(extra_Shot == false && containsExtraSyrup == true) {
				price+=getBASE_PRICE() + EXTRA_SYRUP_PRICE;
			}
			break;
		case MEDIUM: 
			if (extra_Shot == false && containsExtraSyrup == false) {
				price+=getBASE_PRICE()+getSIZE_PRICE();
			}else if(extra_Shot == true && containsExtraSyrup == false) {
				price+=getBASE_PRICE()+getSIZE_PRICE() + EXTRA_SHOT_PRICE;
			}else if(extra_Shot == true && containsExtraSyrup == true) {
				price+=getBASE_PRICE() + getSIZE_PRICE() + EXTRA_SHOT_PRICE + EXTRA_SYRUP_PRICE;
			}else if(extra_Shot == false && containsExtraSyrup == true) {
				price+=getBASE_PRICE() + getSIZE_PRICE() + EXTRA_SYRUP_PRICE;
			}
				
			break;
		case LARGE: 
			if (extra_Shot == false && containsExtraSyrup == false) {
				price+=getBASE_PRICE()+getSIZE_PRICE() + getSIZE_PRICE() ;
			}else if(extra_Shot == true && containsExtraSyrup == false) {
				price+=getBASE_PRICE()+getSIZE_PRICE() + getSIZE_PRICE() + EXTRA_SHOT_PRICE;
			}else if(extra_Shot == true && containsExtraSyrup == true) {
				price+=getBASE_PRICE() + getSIZE_PRICE() + getSIZE_PRICE() + EXTRA_SHOT_PRICE + EXTRA_SYRUP_PRICE;
			}else if(extra_Shot == false && containsExtraSyrup == true) {
				price+=getBASE_PRICE() + getSIZE_PRICE() + getSIZE_PRICE() + EXTRA_SYRUP_PRICE;
			}
			break;
		}
		return price;
	}
	
	
	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Coffee c = (Coffee) obj;
		boolean equals = false;
		if(super.getSize().equals(c.getSize())&&super.getBevName().equals(c.getBevName())&&this.extra_Shot == c.extra_Shot && this.containsExtraSyrup == c.containsExtraSyrup) {
			equals = true;
		}
		return equals;
	}


	@Override
	public String toString() {
		return "Name: " + getBevName() + " \n Type: "  + getType() + "\n Extra shot: " +  extra_Shot + "\n Extra cyrup: " + containsExtraSyrup +
				 "\n Size: " + getSize() + "\nprice: " + calcPrice();
	}


	public boolean getExtraShot() {
		return extra_Shot;
	}


	public void setExtra_Shot(boolean extra_Shot) {
		this.extra_Shot = extra_Shot;
	}


	public boolean getExtraSyrup() {
		return containsExtraSyrup;
	}


	public void setContainsExtraSyrup(boolean containsExtraSyrup) {
		this.containsExtraSyrup = containsExtraSyrup;
	}

	public String getName() {
		return getBevName();
	}
	
	

}
