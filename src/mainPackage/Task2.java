package mainPackage;

import java.util.ArrayList;
import java.util.List;

//Создать класс Payment с внутренним классом,
//с помощью объектов которого можно сформировать покупку из нескольких товаров.
 class Payment{//платёж
	private long id;
	private List<Product> products;
	
	Payment(int id){
		this.id=id;
	}
	Payment(long id,List<Product> products){
		this.id=id;
		this.products=products;
	}
	 void addProduct(List<Product> products) {
		//for (int i=0; i < product.size(); i++)
			Payment.this.products=products;
	}
	 @Override
		public String toString() {
			String s="";
			  for (int i=0; i < products.size(); i++)
		        {
		            s = s + "\r\n  |+++++| Наименование продукта : "
		            		+ ""+products.get(i).getName()+" "
		            				+ "|| Стоимость: "
								      	+ ""+products.get(i).getPrice()+" |+++++|"
		            						+ " ";
		        }
				 return "{" +
	            " id покупки :'" + id + '\'' +
	            ", Список покупок : ||'" + s  + '\'' +
	            '}';
		}
public class Product{
	private String name;
	private int price;
	Product(String name, int price){
		this.name=name;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public List<Product> getProducts() {
	return products;
}
}
public class Task2 {

	public static void main(String[] args) {
		List<Payment> payments = new ArrayList<>();
	    List<Payment.Product> products = new ArrayList<>();
	    Payment objPayment = new Payment(1001);
        Payment.Product objProduct = objPayment.new Product("Яблоко",100);
        Payment.Product objProduct2 = objPayment.new Product("Груша",150);
        Payment.Product objProduct3 = objPayment.new Product("Банан",50);
        Payment.Product objProduct4 = objPayment.new Product("Хлеб",10);
        Payment.Product objProduct5 = objPayment.new Product("Молоко",130);
        Payment.Product objProduct6 = objPayment.new Product("Гречка",190);
	    products.add(objProduct);
	    products.add(objProduct2);
	    products.add(objProduct3);
	    products.add(objProduct4);
	    products.add(objProduct5);
	    products.add(objProduct6);
        objPayment.addProduct(products);
        payments.add(objPayment);
        for (Payment u : payments) {
	    	System.out.println(u);
	    }
	}

}
