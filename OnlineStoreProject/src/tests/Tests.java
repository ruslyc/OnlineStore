package tests;




import static org.junit.Assert.*;
import org.junit.Test;
import store.OnlineCTStores;


public class Tests {
	
	OnlineCTStores orderBin = new OnlineCTStores();
	String[] order1={"Cactus", "T Shirt", "Gold Metal Frame Mirror", "Fork",  "Anchor", "Sunlight", "planet Saturn"};		
	String[] order2={"Cactus", "Marble Clock", "Natural Bench", "T Shirt", "Gold Metal Frame Mirror", "T Shirt", "T Shirt", "Fork",  "Anchor", "Sunlight", "planet Saturn"};	
	String[] order3={"Cactus", "Wood Crate Wall Storage", "Marble Clock", "Natural Bench","Coffee Mug", "Coffee Mug", "Coffee Mug", "T Shirt", "Gold Metal Frame Mirror", "Star Wars game", "T Shirt", "T Shirt", "Fork",  "Anchor", "Sunlight", "planet Saturn"};	
	String[] order4={"Cactus", "Marble Clock", "Natural Bench", "Wood Crate Wall Storage", "T Shirt", "Star Wars game","Coffee Mug",  "Gold Metal Frame Mirror", "T Shirt", "T Shirt", "Fork",  "Anchor", "Sunlight", "planet Saturn"};	
	String[] order5={"Coffee Mug", "Coffee Mug", "Coffee Mug", "T Shirt",  "Coffee Mug",  "Coffee Mug", "T Shirt", "T Shirt"};	
	String[] order6={"Star Wars game",  "Gold Metal Frame Mirror", "T Shirt", "T Shirt", "Sunlight", "planet Saturn"};	
	String[] order7={"Cactus"};		
	String[] order8={"Coffee Mug", "Coffee Mug"};
	String[] order9={"Cactus", "T Shirt", "Gold Metal Frame Mirror", "Fork",  "Anchor","Fork","Fork", "Sunlight", "planet Saturn"};		
	String[] order10={"Cactus", "Marble Clock", "Natural Bench", "Cactus", "Cactus", "T Shirt", "T Shirt", "Cactus", "Cactus"};	
	
	@Test
	public void findItemPrice(){		
		assertEquals(49.99, orderBin.findItemPrice("Cactus"), 0);
		assertEquals(4.99, orderBin.findItemPrice("Fork"), 0);
		
	}
	@Test
	public void findItemPrice2(){
		assertEquals(55.00, orderBin.findItemPrice("Llama Valley Framed Print"), 0);
		assertEquals(79.99, orderBin.findItemPrice("Blanket"), 0);
	}
	@Test
	public void findItemPrice3(){

		assertEquals(27.99, orderBin.findItemPrice("Copper Coffee and Tea Kettle"), 0);
		assertEquals(400.00, orderBin.findItemPrice("planet Saturn"), 0);
	}
	@Test
	public void discountByItemCount(){
		
		assertEquals(0, orderBin.discountByItemCount(order1, true));
		assertEquals(10, orderBin.discountByItemCount(order2, true));

	}
	
	@Test
	public void discountByItemCount2(){
		
		assertEquals(0, orderBin.discountByItemCount(order1, false));
		assertEquals(5, orderBin.discountByItemCount(order2, false));
		
	}
	
	@Test
	public void discountByItemCount3(){

		assertEquals(10, orderBin.discountByItemCount(order3, true));
		assertEquals(10, orderBin.discountByItemCount(order4, true));
		
	}
	@Test
	public void discountByItemCount4(){

		assertEquals(5, orderBin.discountByItemCount(order3, false));
		assertEquals(5, orderBin.discountByItemCount(order4, false));
		
	}
	@Test
	public void getNumberOfDuplicateItems(){
		assertEquals(0, orderBin.getNumberOfDuplicateItems(order1));
		assertEquals(1, orderBin.getNumberOfDuplicateItems(order2));

	}
	@Test
	public void getNumberOfDuplicateItems2(){

		assertEquals(2, orderBin.getNumberOfDuplicateItems(order3));
		assertEquals(1, orderBin.getNumberOfDuplicateItems(order4));
	}
	@Test
	public void getNumberOfDuplicateItems3(){
		assertEquals(2, orderBin.getNumberOfDuplicateItems(order5));
		assertEquals(1, orderBin.getNumberOfDuplicateItems(order6));
		
	}
	@Test
	public void getNumberOfItemOccurrences(){

		assertEquals(1, orderBin.getNumberOfItemOccurrences(order1, "Gold Metal Frame Mirror"));
		assertEquals(3, orderBin.getNumberOfItemOccurrences(order2, "T Shirt"));

	}
	@Test
	public void getNumberOfItemOccurrences2(){

		assertEquals(3, orderBin.getNumberOfItemOccurrences(order3, "Coffee Mug"));
		assertEquals(3, orderBin.getNumberOfItemOccurrences(order4, "T Shirt"));
		assertEquals(1, orderBin.getNumberOfItemOccurrences(order4, "Coffee Mug"));
	}
	@Test
	public void getNumberOfItemOccurrences3(){

		assertEquals(5, orderBin.getNumberOfItemOccurrences(order5, "Coffee Mug"));
		assertEquals(2, orderBin.getNumberOfItemOccurrences(order6, "T Shirt"));
		
	}
	

	@Test
	public void buyThreeDiscount(){
		String[] expected = {"Cactus", "T Shirt", "Gold Metal Frame Mirror", "Fork", "Anchor", "Sunlight", "planet Saturn"};				
		assertArrayEquals(expected, orderBin.buyThreeDiscount(order1, true));		
		assertArrayEquals(expected, orderBin.buyThreeDiscount(order1, false));
	}
	
	@Test
	public void buyThreeDiscount2(){

		String[] expected ={"Cactus", "Marble Clock", "Natural Bench", "T Shirt", "Gold Metal Frame Mirror", "T Shirt", "T Shirt", "Fork", "Anchor", "Sunlight", "planet Saturn", "T Shirt", "T Shirt"};
		String[] expected1 ={"Cactus", "Marble Clock", "Natural Bench", "T Shirt", "Gold Metal Frame Mirror", "T Shirt", "T Shirt", "Fork", "Anchor", "Sunlight", "planet Saturn", "T Shirt"};
		
		
		assertArrayEquals(expected, orderBin.buyThreeDiscount(order2, true));
		assertArrayEquals(expected1, orderBin.buyThreeDiscount(order2, false));
	}
	@Test
	public void buyThreeDiscount3(){
		String[] expected ={"Cactus", "Wood Crate Wall Storage", "Marble Clock", "Natural Bench", "Coffee Mug", "Coffee Mug", "Coffee Mug", "T Shirt", "Gold Metal Frame Mirror", "Star Wars game", "T Shirt", "T Shirt", "Fork", "Anchor", "Sunlight", "planet Saturn", "T Shirt"};
		String[] expected1 ={"Cactus", "Wood Crate Wall Storage", "Marble Clock", "Natural Bench", "Coffee Mug", "Coffee Mug", "Coffee Mug", "T Shirt", "Gold Metal Frame Mirror", "Star Wars game", "T Shirt", "T Shirt", "Fork", "Anchor", "Sunlight", "planet Saturn", "T Shirt", "T Shirt"};

		assertArrayEquals(expected, orderBin.buyThreeDiscount(order3, false));
		assertArrayEquals(expected1, orderBin.buyThreeDiscount(order3, true));



		
	}
	@Test
	public void buyThreeDiscount4(){
		String[] expected ={"Cactus", "T Shirt", "Gold Metal Frame Mirror", "Fork",  "Anchor","Fork","Fork", "Sunlight", "planet Saturn", "Fork", "Fork"};
		String[] expected1 ={"Cactus", "T Shirt", "Gold Metal Frame Mirror", "Fork",  "Anchor","Fork","Fork", "Sunlight", "planet Saturn", "Fork"};

		assertArrayEquals(expected, orderBin.buyThreeDiscount(order9, true));
		assertArrayEquals(expected1, orderBin.buyThreeDiscount(order9, false));
		
	}
	
	@Test
	public void buyThreeDiscount5(){
		String[] expected ={"Cactus", "Marble Clock", "Natural Bench", "Cactus", "Cactus", "T Shirt", "T Shirt", "Cactus", "Cactus","Cactus", "Cactus"};	
		String[] expected1 ={"Cactus", "Marble Clock", "Natural Bench", "Cactus", "Cactus", "T Shirt", "T Shirt", "Cactus", "Cactus","Cactus"};

		assertArrayEquals(expected, orderBin.buyThreeDiscount(order10, true));
		assertArrayEquals(expected1, orderBin.buyThreeDiscount(order10, false));
		
	}
	@Test
	public void getOrderTotalWithoutDiscount(){
		
		assertEquals(2195.86, orderBin.getOrderTotalWithoutDiscount(order1),0);
		assertEquals(2601.54, orderBin.getOrderTotalWithoutDiscount(order2),0);

	}
	
	@Test
	public void getOrderTotalWithoutDiscount2(){
		assertEquals(2770.01, orderBin.getOrderTotalWithoutDiscount(order3),0);
		assertEquals(2710.03, orderBin.getOrderTotalWithoutDiscount(order4),0);

		
	}

	@Test
	public void getOrderTotalWithoutDiscount4(){

		assertEquals(2171.87, orderBin.getOrderTotalWithoutDiscount(order6),0);

	}
	@Test
	public void getOrderTotalWithoutDiscount5(){

		assertEquals(49.99, orderBin.getOrderTotalWithoutDiscount(order7),0);

	}
	@Test
	public void getOrderTotalWithoutDiscount6(){

		assertEquals(59.98, orderBin.getOrderTotalWithoutDiscount(order8),0);

	}
	@Test
	public void discountByItemPrice(){

		assertEquals(18, orderBin.discountByItemPrice(order1, true));
		assertEquals(18, orderBin.discountByItemPrice(order2, true));
		assertEquals(7, orderBin.discountByItemPrice(order1, false));
		assertEquals(7, orderBin.discountByItemPrice(order2, false));
	}
	
	@Test
	public void discountByItemPrice2(){
		assertEquals(18, orderBin.discountByItemPrice(order3, true));
		assertEquals(18, orderBin.discountByItemPrice(order4, true));
		assertEquals(7, orderBin.discountByItemPrice(order3, false));
		assertEquals(7, orderBin.discountByItemPrice(order4, false));		
	}
	@Test
	public void discountByItemPrice3(){
		assertEquals(0, orderBin.discountByItemPrice(order5, true));
		assertEquals(18, orderBin.discountByItemPrice(order6, true));
		assertEquals(0, orderBin.discountByItemPrice(order5, false));
		assertEquals(7, orderBin.discountByItemPrice(order6, false));
		
	}
	@Test
	public void isShippingFree(){
		assertEquals(true, orderBin.isShippingFree(order1, true));
		assertEquals(true, orderBin.isShippingFree(order1, false));

		
	}
	
	@Test
	public void isShippingFree2(){
		assertEquals(true, orderBin.isShippingFree(order2, true));
		assertEquals(true, orderBin.isShippingFree(order2, false));
		
	}
	@Test
	public void isShippingFree3(){
		assertEquals(true, orderBin.isShippingFree(order3, true));
		assertEquals(true, orderBin.isShippingFree(order3, false));
		assertEquals(true, orderBin.isShippingFree(order4, true));
		assertEquals(true, orderBin.isShippingFree(order4, false));
		
	}
	@Test
	public void isShippingFree4(){
		assertEquals(true, orderBin.isShippingFree(order5, true));
		assertEquals(true, orderBin.isShippingFree(order5, false));
		assertEquals(true, orderBin.isShippingFree(order6, true));
		assertEquals(true, orderBin.isShippingFree(order6, false));
		
	}
	@Test
	public void calculateOrderTotalWithDiscountsAndShipping(){
		assertEquals(1800.61, orderBin.calculateOrderTotalWithDiscountsAndShipping(order1, true),0.99);
		assertEquals(2133.26, orderBin.calculateOrderTotalWithDiscountsAndShipping(order2, true),0.99);

		
	}
	
	@Test
	public void calculateOrderTotalWithDiscountsAndShipping2(){

		assertEquals(2042.15, orderBin.calculateOrderTotalWithDiscountsAndShipping(order1, false),0.99);
		assertEquals(2419.43, orderBin.calculateOrderTotalWithDiscountsAndShipping(order2, false),0.99);
		
	}
	@Test
	public void calculateOrderTotalWithDiscountsAndShipping3(){
		assertEquals(2576.11, orderBin.calculateOrderTotalWithDiscountsAndShipping(order3, false),0.99);
		assertEquals(2520.33, orderBin.calculateOrderTotalWithDiscountsAndShipping(order4, false),0.99);
		assertEquals(2271.41, orderBin.calculateOrderTotalWithDiscountsAndShipping(order3, true),0.99);
		assertEquals(2222.22, orderBin.calculateOrderTotalWithDiscountsAndShipping(order4, true),0.99);
		
	}
	@Test
	public void calculateOrderTotalWithDiscountsAndShipping4(){
		assertEquals(191.94, orderBin.calculateOrderTotalWithDiscountsAndShipping(order5, false),0.99);
		assertEquals(2019.84, orderBin.calculateOrderTotalWithDiscountsAndShipping(order6, false),0.99);
		assertEquals(191.94, orderBin.calculateOrderTotalWithDiscountsAndShipping(order5, true),0.99);
		assertEquals(1780.93, orderBin.calculateOrderTotalWithDiscountsAndShipping(order6, true),0.99);
		
	}
	@Test
	public void calculateOrderTotalWithDiscountsAndShipping5(){
		assertEquals(61.49, orderBin.calculateOrderTotalWithDiscountsAndShipping(order7, false),0.99);
		assertEquals(71.48, orderBin.calculateOrderTotalWithDiscountsAndShipping(order8, false),0.99);
		assertEquals(61.49, orderBin.calculateOrderTotalWithDiscountsAndShipping(order7, true),0.99);
		assertEquals(71.48, orderBin.calculateOrderTotalWithDiscountsAndShipping(order8, true),0.99);
		assertEquals(1808.79, orderBin.calculateOrderTotalWithDiscountsAndShipping(order9, true),0.99);
		assertEquals(2051.43, orderBin.calculateOrderTotalWithDiscountsAndShipping(order9, false),0.99);		
	}
}
