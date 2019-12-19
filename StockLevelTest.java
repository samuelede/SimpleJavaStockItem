/**
 * Test Program for StockLevel
 * @author Sam
 */
package assignment1;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class StockLevelTest {

	/**The test program creates instances of StockLevel using each
	 * constructor. Every method is tested
	 * @param args
	 */
	public static void main(String[] args) {
		// Creates an instance of StockLevel using no-argument constructor
		StockLevel s = new StockLevel();
		
		//Array List of type StockLevel
		List<StockLevel> ls = new ArrayList<>();
		
		//create Scanner object to receive keyboard input
		Scanner sc = new Scanner(System.in);
		System.out.println("***Java Program To Manage Order's & Stock Level's*****");
		System.out.println("View Current Stock Levels: ");
		ls.forEach(x -> System.out.println(x.toString()));//display details
		System.out.println("\nEmpty Stock Level, populate with new stock values\n");
		
		System.out.print("Enter a number of Stock to Enter: ");
		int stk = sc.nextInt();//read next token as an integer/number of times to input Stock
		
		//for loop to ask the user to input stock records a number of times
		for (int count = 1; count <= stk; count++) {
			System.out.print("Enter a Stock Id or Name. Eg Grapes: ");
			String sId = sc.next();//read next token as String
			System.out.print("Enter Stock Price. Eg 0.65: ");
			double price = sc.nextDouble();//read next token as double
			System.out.print("Enter Stock Quantity. Eg 50: ");
			int qty = sc.nextInt();//read next token as integer
			System.out.print("Enter Minimum Stock Level. Eg 2: ");
			int minStk = sc.nextInt();//read next token as integer
			System.out.print("Enter ReOrder Amount. Eg 1000: ");
			int roAmt = sc.nextInt(); //read next token as integer
			
			/**collect stock values specified from the keyboard and pass into the
			*  arrayList of StockLevel type
			*/
			ls.add(new StockLevel(sId, price, qty, minStk, roAmt));
			System.out.println(sc.nextLine());// display empty Line in between each set of stock record
		}	
		
		/* //For Test - ArrayList of Stock already specified in the program
		 * ls.forEach(x -> System.out.println(x.toString()));
		 * System.out.println("\n Empty Stock, populate with new values");
		 * 
		 * ls.add(new StockLevel("Grapes", 40, 45, 3, 500)); ls.add(new
		 * StockLevel("Pines", 35, 33, 2, 800)); ls.add(new StockLevel("Tomatoes", 43,
		 * 300, 4, 900)); ls.add(new StockLevel("Onions", 43, 300, 4, 1000)); ls.add(new
		 * StockLevel("Plum", 40, 45, 3, 500)); ls.add(new StockLevel("Pines", 35,
		 * 33, 2, 800)); ls.add(new StockLevel("Tomatoes", 43, 300, 4, 900)); ls.add(new
		 * StockLevel("Onions", 43, 300, 4, 1000));
		 */
		
		System.out.println(" Stock Populated ");
		System.out.println("Display Total StockLevel Details ");
		ls.forEach(x -> System.out.println(x.toString()));//display current stockLevel
		
		/**While, Switch and For Loop to ask the user for particular Items in stock 
		 * to make an order from, also specifying the index of each item to reorder
		 * or increase stock
		*/
		System.out.print("\nWhat would you like to do next? \n1. Make Order\n2. Check Stock \n3. ReOrder Items \n4. Close Application: ");
		int n = sc.nextInt();//receive instruction to carry out
		boolean closeApp = false;//set close Application to false, until user is ready to close the program = true
		while (n > 0 || n < 5) {
			switch (n) {
				case 1 : 
					System.out.print("\nSelect from Stock\n");
					for (int x = 0; x < ls.size(); x++) {
						System.out.print((x) +". "+ls.get(x).getId()+"\n");
					}System.out.print("Type a Stock number: ");
					int index = sc.nextInt();
						//checks and makes sure a correct index within the range selected, 
						//-1 make sure the order is maintained
						if (index > (ls.size()-1)) {
							index = 0;
							System.out.println("Invalid Stock Number. Default = 0");
							break;
						} else {
							System.out.print("Place an Order:Enter quantity: ");
							int a = sc.nextInt();
							double b = ls.get((index)).getPrice();
							int c = ls.get((index)).getCurStock();
							int d = ls.get((index)).getMinStock();
							//System.out.println(c);//Test a,b,c,d
							s.setPrice(b);				
							s.setQuantity(a);
							s.setCurStock(c);
							s.setMinStock(d);
							s.checkStatus();
							/**if loop to check if order amount is more than stock quantity and 
							 * if the stock quantity has reached the minimum stocklevel
							 */
							if (s.alarm > 0) {				
								ls.get(index).Order(a);
								System.out.println("Your order has been placed: \nTotal Cost of "+ls.get((index)).getId()+" = $"+ s.getCost());
							} else {
								System.out.println("No order placed. Your order is above the available StockLevel\nReorder "+ls.get(index).getId());
							}
						}
						
					System.out.println("\n**Updated Stock Level Details**");
					
					for (int i = 0; i < ls.size(); i++) { System.out.println(ls.get(i)); }//display details
				 
					break;
				case 2 :
					System.out.print("\nCheck Stock of an Item: Eg. 1 for Grapes");
					for (int i = 1; i < ls.size(); i++) {//display current StockLevels
						System.out.println(ls.get(i));
					}
					
					break;
				case 3 : //Reorder Items add Suggested reorder amount to the current stock 
					System.out.print("\nSelect Stock Item to ReOrder:\n");
					for (int x = 0; x < ls.size(); x++) {
						System.out.print((x) +". "+ls.get(x).getId()+"\n");
					}System.out.print("Type a Stock number: ");
					int index2 = sc.nextInt();//get particular item needed to be restocked
					if (index2 > (ls.size()-1)) {
						index2 = 0;
						System.out.println("Invalid Stock Number. Default = 0");
						break;
					} else {
						int d = ls.get(index2).getCurStock();//get current stock amount
						int e = ls.get(index2).getReOrderAmt();//get suggested reorder amount
						
						s.setCurStock(d);//set current stock
						s.setReOrderAmt(e);//set reorder amount
						ls.get(index2).reOrder();//get particular item needed to be restocked
						//System.out.println(s.getReOrderAmt());
						System.out.println("ReOrder Complete.");
						System.out.println("\n**Updated Stock Level Details**");
					}
					//display current StockLevels
					for (int i = 0; i < ls.size(); i++) {
						System.out.println(ls.get(i));
					}
					break;
				case 4 :
					System.out.print("");
					closeApp = true;//if condition 4 is selected then is true, close application
					break;
				default :
					System.out.println("\nYou have selected an invalid option. Choose again!");
					break;
			}if (closeApp) break;
			System.out.println("\nOptions: Select a number to Proceed");
			System.out.print("1. Make an Order\n2. Check Stock\n3. Reorder Item\n4. Close Application: ");
			n = sc.nextInt(); //receives instruction to continue the loop or end loop
		}
		
		 System.out.println("Applicaiton Closed...\n"); sc.close();//close Scanner 
		 
	}

}
