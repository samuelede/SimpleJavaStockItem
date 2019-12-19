/**
 * Java Manage StockLevel 
 */
package assignment1;

/**A product in a shop has a particular quantity in stock. There is a minimum
 * stock level, and when this is reached it indicates that the product needs 
 * to be reordered. Each item has a suggested reorder amount.
 * 
 * @author Sam
 */
public class StockLevel {
	//fields
	private String id;//identifier for the stock item
	private double price;//the price for one of the item
	private int curStock;// the number of items ordered
	private int minStock;//the least amount of items that can be in stock
	private int reOrderAmt;
	private int quantity;// the maximum amount of items that can be stocked
	int alarm;//sets status to 1 if stock runs below the limit
	
	//Constructors
	/** Default Constructor. Creates new StockLevel default values
	 *  initial price is empty, price is zero, current stock is zero
	 *  minimum stock is zero and reorder amount is also zero
	 */
	public StockLevel() {
		id = "";
		price = 0;
		curStock = 0;
		minStock = 0;
		reOrderAmt = 0;
	}
	/**
	 * Creates StockLevel with specified settings
	 * @param id, the name of the Stock Item. Item name must be String
	 * @param price, the price of stock item. Price must be numbers
	 * @param curStock, amount or quantity of stock item, cannot be less than 0
	 * @param minStock, least amount of stock
	 * @param reOrderAmt, re-stock a specific stock Item
	 */
	public StockLevel(String id, double price, int curStock, int minStock, int reOrderAmt) {
		this.id = id;
		this.price = price;
		this.curStock = curStock;
		this.minStock = minStock;
		this.reOrderAmt = reOrderAmt;
		
	}
	
	//Methods
	/* Makes an order for a specific stock Item selected,
	 * and subtracts c : quantity from the current Stock.
	 */
	public void Order(int c) {
		curStock = curStock - c;
	}
	/*
	 * Checks the status of the current stock against the amount of stock
	 * being ordered to prevent stockLevel falling bellow stock limit
	 */
	public void checkStatus() {
		if (curStock >= quantity) {
			 alarm = 1;
		} 
		if (curStock > minStock){ 
			alarm = 1;	
		} else { alarm = 0;}
	}
	
	/**Calculates the Cost of Total quantity ordered by the price of each Item 
	 * and returns the Cost
	*/
	public double getCost() {
		return price * quantity;
	}

	/**Adds the reOrder amount specified to the current stock and returns a new
	*  @param currentStock
	*/
	public int reOrder() {
		return curStock = curStock + reOrderAmt;
	}
	
	/**getters and setter methods
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the curStock
	 */
	public int getCurStock() {
		return curStock;
	}

	/**
	 * @param curStock the curStock to set
	 */
	public void setCurStock(int curStock) {
		this.curStock = curStock;
	}
	
	/**
	 * @return the minStock
	 */
	public int getMinStock() {
		return minStock;
	}

	/**
	 * @param minStock the minStock to set
	 */
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	/**
	 * @return the reOrderAmt
	 */
	public int getReOrderAmt() {
		return reOrderAmt;
	}

	/**
	 * @param reOrderAmt the reOrderAmt to set
	 */
	public void setReOrderAmt(int reOrderAmt) {
		this.reOrderAmt = reOrderAmt;
	}
	
	/** 
	 * @return a textual representation of the StockLevel */
	@Override
	public String toString() {
		return "StockLevel [id=" + id + ", price=" + price + ", curStock=" + curStock + ", minStock=" + minStock
				+ ", reOrderAmt=" + reOrderAmt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alarm;
		result = prime * result + curStock;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + minStock;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + reOrderAmt;
		return result;
	}
	//Override the equals method in the StockLevel Class
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockLevel other = (StockLevel) obj;
		if (alarm != other.alarm)
			return false;
		if (curStock != other.curStock)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (minStock != other.minStock)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (reOrderAmt != other.reOrderAmt)
			return false;
		return true;
	}
	
	
}
