
public class Alcohol extends Beverage{
//fields 
	private boolean offeredOnWeekend = false;
	private final double WEEKEND_PRICE = .60;
	
	//Paramaterized constructor
	public Alcohol(String n, SIZE s, boolean offeredOnWeekend) {
		super(n, s, TYPE.ALCOHOL);
		this.offeredOnWeekend = offeredOnWeekend;

	} 

  //copy constructor
  public Alcohol(Alcohol a){
    super(a.getBevName(), a.getSize(), TYPE.ALCOHOL);
    this.offeredOnWeekend = a.getOfferedOnWeekend();
  }
	
	@Override
	public double calcPrice() {
		double price = 0;
		switch(getSize()) {
		case SMALL: 
			if ( offeredOnWeekend == false) {
				price+=getBASE_PRICE();
			}else if(offeredOnWeekend == true) {
				price+=getBASE_PRICE() + WEEKEND_PRICE;
			}
			break;
		case MEDIUM: 
			if ( offeredOnWeekend == false) {
				price+=getBASE_PRICE() + getSIZE_PRICE() ;
			}else if(offeredOnWeekend == true) {
				price+=getBASE_PRICE() + getSIZE_PRICE() + WEEKEND_PRICE;
			}
			break;
		case LARGE: 
			if ( offeredOnWeekend == false) {
				price+=getBASE_PRICE() + (getSIZE_PRICE()*2);
			}else if(offeredOnWeekend == true) {
				price+=getBASE_PRICE() + (getSIZE_PRICE()*2) + WEEKEND_PRICE;
			}
			break;
		}
		return price;
	}
	
	@Override
	public String toString() {
		return "Name: " + super.getBevName() + "\n Size: " + super.getSize() + "\n offered on the weekend: " + offeredOnWeekend +
				"\n price: " + calcPrice();
				
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Alcohol a = (Alcohol) obj;
		boolean equals = false;
		if(super.getSize().equals(a.getSize())&&super.getBevName().equals(a.getBevName())
				&&this.offeredOnWeekend == a.offeredOnWeekend) {
			equals = true;
		}
		return equals;
	}

	public boolean getOfferedOnWeekend() {
		return offeredOnWeekend;
	}

	public void setOfferedOnWeekend(boolean offeredOnWeekend) {
		this.offeredOnWeekend = offeredOnWeekend;
	}
	
	public double getBasePrice() {
		return super.getBASE_PRICE();
	}

}
