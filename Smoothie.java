
public class Smoothie extends Beverage{
	private int noOfFruit = 0;
	private boolean containsProtienPowder = false;
	private final double Protien_PRICE = 1.5;
	private final double FRUIT_PRICE = 0.5;
	
		
	//Paramaterized constructor
		public Smoothie(String n, SIZE s, int noOfFruit, boolean containsProtienPowder) {
			super(n, s, TYPE.SMOOTHIE);
			this.containsProtienPowder = containsProtienPowder;
			this.noOfFruit = noOfFruit;

		}

    public Smoothie(Smoothie s) {
			super(s.getBevName(), s.getSize(), TYPE.SMOOTHIE);
			this.containsProtienPowder = s.getContainsProtienPowder();
			this.noOfFruit = s.getNumOfFruits();
		}
		
		@Override
		public double calcPrice() {
			double price = 0;
			switch(getSize()) {
			case SMALL: 
				if ( containsProtienPowder == false) {
					price+=getBASE_PRICE() + (noOfFruit*FRUIT_PRICE);
				}else if(containsProtienPowder == true) {
					price+=getBASE_PRICE() + Protien_PRICE + (noOfFruit*FRUIT_PRICE);
				}
				break;
			case MEDIUM: 
				if ( containsProtienPowder == false) {
					price+=getBASE_PRICE() + getSIZE_PRICE() + (noOfFruit*FRUIT_PRICE);
				}else if(containsProtienPowder == true) {
					price+=getBASE_PRICE() + getSIZE_PRICE() + (noOfFruit*FRUIT_PRICE) + Protien_PRICE;
				}
				break;
			case LARGE: 
				if ( containsProtienPowder == false) {
					price+=getBASE_PRICE() + (getSIZE_PRICE()*2) + (noOfFruit*FRUIT_PRICE);
				}else if(containsProtienPowder == true) {
					price+=getBASE_PRICE() + (getSIZE_PRICE()*2) + (noOfFruit*FRUIT_PRICE) + Protien_PRICE;
				}
				break;
			}
			return price;
		}

		@Override
		public String toString() {
			return "Name: " + super.getBevName() + "\n Size: " + super.getSize() + "\n protien added: " + containsProtienPowder +
					"\n Number of  fruits: " + noOfFruit + "\n price: " + calcPrice();
					
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Smoothie s = (Smoothie) obj;
			boolean equals = false;
			if(super.getSize().equals(s.getSize())&&super.getBevName().equals(s.getBevName())
					&&this.containsProtienPowder == s.containsProtienPowder && this.noOfFruit == s.noOfFruit) {
				equals = true;
			}
			return equals;
		}

		public int getNumOfFruits() {
			return noOfFruit;
		}

		public void setNoOfFruits(int noOfFruit) {
			this.noOfFruit = noOfFruit;
		}

		public boolean getContainsProtienPowder() {
			return containsProtienPowder;
		}
		
		public boolean getAddProtein() {
			return containsProtienPowder;
		}

		public void setContainsProtienPowder(boolean containsProtienPowder) {
			this.containsProtienPowder = containsProtienPowder;
		}
		
		public double getBasePrice() {
			return getBASE_PRICE();
		}
		
		
		
}
