import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterfce {
  private final int ALCOHOL_DRINKS_PER_ORDER = 3;
  ArrayList<Order> orderList = new ArrayList<Order>();
  private final int MIN_DRINKING_AGE = 21;
  private Order currentOrder;

  /**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time time represents the time 
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
  //INCLUSIVE?
	public boolean validTime(int time){
    return 8 <= time && time <= 23;
  }
	

	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	public boolean eligibleForMore(){
    return getNumOfAlcoholDrink() < ALCOHOL_DRINKS_PER_ORDER;
  }
	
	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	public  boolean validAge(int age){
    return MIN_DRINKING_AGE < age;
  }
	/**
	  * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param day day of the order of type DAY
	  * @param customerName customer name 
	  * @param customerAge customer age
	  */
	
	public void startNewOrder(int time,
						 	DAY day,
						 	String customerName,
						 	int customerAge){
    Order o = new Order(time, day,new Customer(customerName,customerAge));
    orderList.add(o);
    currentOrder = o;
              }
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
 
	public void processCoffeeOrder( String bevName,
									SIZE size,
									boolean extraShot,
									boolean extraSyrup ){
        currentOrder.addNewBeverage(bevName,size,extraShot,extraSyrup);   
                  }
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	public void  processAlcoholOrder( String bevName,
									SIZE size ){
    if(eligibleForMore() && validAge(currentOrder.getCustomer().getAge()))
      currentOrder.addNewBeverage(bevName,size);
                  }
	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */
	public void processSmoothieOrder( String bevName,
									SIZE size,
									int numOfFruits,
									boolean addProtien){
    currentOrder.addNewBeverage(bevName,size,numOfFruits,addProtien);
                  }
	
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	public int findOrder(int orderNo){
    for(int index = 0; index < orderList.size(); index++){
      if(orderList.get(index).getOrderNo() == orderNo){
        return index;
      }
    }
    return -1;
  }
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo){
    int index = findOrder(orderNo);
    if(index == -1){
      return -1;
    } else {
      return orderList.get(index).calcOrderTotal();
    } 
  }
	
	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	public double totalMonthlySale(){
    double total = 0;
    for(int index = 0; index < orderList.size(); index++){
      total += orderList.get(index).calcOrderTotal();
    }
    return total;
  }
	
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	public  void sortOrders(){
     int startScan, index, minIndex;
     Order minValue;

	 for (startScan = 0; startScan < orderList.size(); startScan++){
	      minIndex = startScan;
	       for(index = startScan+1; index < orderList.size(); index++){
	        if(orderList.get(index).getOrderNo()<orderList.get(minIndex).getOrderNo()){
	            minIndex = index;
	        }
	       }
	       Collections.swap(orderList,minIndex,startScan);
	     }
  }
	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	public Order getOrderAtIndex(int index){
    if(index >= orderList.size())
      return null;
    return orderList.get(index);
  }

  public int getMaxOrderForAlcohol() {
    return ALCOHOL_DRINKS_PER_ORDER;
  }
  public int getMinAgeForAlcohol(){
    return MIN_DRINKING_AGE;
  }
  public Order getCurrentOrder(){
    return currentOrder;
  }
  public int getNumOfAlcoholDrink(){
    return currentOrder.findNumOfBeveType(TYPE.ALCOHOL);
  }

  public int totalNumOfMonthlyOrders() {
	  return  orderList.size();
  }
  /*
WHAT IS THIS METHOD? NEVER DEFINED??????
*/
  public boolean isMaxFruit(int fruits){
    return fruits > 5;
  }


@Override
public String toString() {
	return  orderList.toString() + "\n total monthly sales: " + totalMonthlySale();
}
  
  
}