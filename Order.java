import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable{
//fields 
	private int orderNo = 0;
	private int orderTime = 0;
	private DAY orderDay;
	private Customer customer;
	private ArrayList <Beverage> beverageList = new ArrayList<Beverage>();
	
	public Order(int orderTime, DAY day, Customer c) {
		this.orderNo = randomNumber();
    this.orderTime = orderTime;
		this.orderDay = day;
		this.customer = c;
	}
	
	@Override
	public boolean isWeekend() {
		boolean weekend = false;
		
		if(orderDay.equals(DAY.SATURDAY) || orderDay.equals(DAY.SUNDAY)) {
			weekend = true;
		}
		return weekend;
	}
	
	public int randomNumber() {
		//variables to use to create random number 
		int minVal = 10000; int maxVal = 90000; int randomNum = 0; 
		//random objedct 
		Random rand = new Random();
		//set ranndNum  tot he new random bumber between min and max values 
		randomNum = rand.nextInt(maxVal)+minVal;
		return randomNum;
	}
	
	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	public void  addNewBeverage(
			String bevName,
			SIZE size,
			boolean extraShot,
			boolean extraSyrup) {
		Coffee c = new Coffee(bevName, size, extraShot, extraSyrup);
		beverageList.add(c);
	}
	
	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	public void  addNewBeverage( String bevName,
								SIZE size){
		Alcohol a = new Alcohol(bevName, size, isWeekend());
		beverageList.add(a);
	}
	
	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added
	 * @param addPRotien true if protein is added, false otherwise
	 */
	public void  addNewBeverage( String bevName,
				SIZE size,
				int numOfFruits,
				boolean addPRotien){
		Smoothie s = new Smoothie(bevName, size, numOfFruits, addPRotien);
		beverageList.add(s);
	}

	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	public double calcOrderTotal() {
		double total = 0;
		for (int index = 0; index < beverageList.size(); index++) {
			total+=beverageList.get(index).calcPrice();
		}
		return total;
	}

	@Override
	public int compareTo(Object o) {
    Order order = (Order) o;
	  if (orderNo < order.getOrderNo()){
      return -1;
    } else if (orderNo > order.getOrderNo()){
      return 1;
    } else {
      return 0;
    }
	}


	@Override
	public Beverage getBeverage(int itemNo) {
		return beverageList.get(itemNo);
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int total = 0;
		for (int index = 0; index < beverageList.size(); index++) {
			if(beverageList.get(index).getType().equals(type))
        total++;
		}
		return total;
	}

  public int getOrderNo(){
    return orderNo;
  }
	public int getOrderTime(){
    return orderTime;
  }
  public DAY getOrderDay(){
    return orderDay;
  }
  public Customer getCustomer(){
    Customer c = new Customer(customer);
    return c;
  }
  
  public int getTotalItems() {
	  return beverageList.size();
  }
  
  public ArrayList<Beverage> getbeverageList(){
    //	private ArrayList <Beverage> beverageList = new ArrayList<Beverage>();
    ArrayList <Beverage> beverageList2 = new ArrayList<Beverage>();
    for (int index = 0; index < beverageList.size(); index++) {
      if(beverageList.get(index).getType().equals(TYPE.SMOOTHIE)){
        beverageList2.add(new Smoothie((Smoothie) beverageList.get(index)));  
      } else if(beverageList.get(index).getType().equals(TYPE.COFFEE)){
        beverageList2.add(new Coffee((Coffee) beverageList.get(index))); 
      } else if(beverageList.get(index).getType().equals(TYPE.ALCOHOL)){
        beverageList2.add(new Alcohol((Alcohol) beverageList.get(index))); 
      }     
		}
    return beverageList2;
    
  }

@Override
public String toString() {
	
	return "Order Number: " + orderNo + "\n order time:" + orderTime + "\n order Day: " + orderDay + "\n customer: "
			+ customer + "\n beverageList: \n " + beverageList.toString() + "\n Total Price: " + calcOrderTotal();
}
  
  
}
