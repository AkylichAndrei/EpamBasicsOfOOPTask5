package mainPackage;

import java.util.ArrayList;
import java.util.List;

//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Корректно спроектируйте и реализуйте предметную область задачи.  +
//• Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования. +
//• Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента. +
//• для проверки корректности переданных данных можно применить регулярные выражения, а можно не применять. =)) 
//• Меню выбора действия пользователем можно не реализовывать, используйте заглушку. +
//• Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().  +

//Вариант A. 
//Цветочная композиция. 
//Реализовать приложение, позволяющее создавать цветочные композиции (объект, представляющий собой цветочную композицию). 
//Составляющими цветочной композиции являются цветы и упаковка.
//Вариант B. 
//Подарки. 
//Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой подарок).
//Составляющими целого подарка являются сладости и упаковка.
public class Task5 {
	public static void main(String[] args) {
		//================Клиентский код варианта А================
		   List<Package> packages  = new ArrayList<>();
		   List<Flower> flowers = new ArrayList<>();
		   List<FlowerComposition> flowerCompositions = new ArrayList<>();
		
		//вырастим три розы в оранжерее роз
		   for(int i=0;i<3;i++) {
			   Greenhouse objGreenhouse = getRoseFlowerGreenhouse("Роза");
			   Flower flower = objGreenhouse.createFlower("Роза");
			   flowers.add(flower);
		   }
		 //вырастим две ромашки в оранжерее ромашек
		   for(int i=0;i<2;i++) {
				Greenhouse objGreenhouse = getRoseFlowerGreenhouse("Ромашка");
		        Flower flower = objGreenhouse.createFlower("Ромашка");
		        flowers.add(flower);
				   }
		 //создадим в компании по производству упаковак упаковку синего цвета
        PackingСompany objPackingCompany = getPackingCompany("Синяя упаковка");
        Package objPacking = objPackingCompany.createPackage("Синяя упаковка");
        packages.add(objPacking);
        
        
        
        //создадим цветочную компазицию из всех что у нас есть цветов и назовём её "Весенний восторг"
        FlowerComposition objFlowerCompositions = new FlowerComposition("Весенний восторг",packages,flowers);
        flowerCompositions.add(objFlowerCompositions);
        //посмотрим что получилось
        for (FlowerComposition u : flowerCompositions) {
	    	System.out.println(u);
	    }
      //================Клиентский код варианта Б================
        
        List<PackageSweets> packageSweets  = new ArrayList<>();
        List<Sweetness> sweetness = new ArrayList<>();
		   List<Present> presents = new ArrayList<>();
		
		//произведём три конфеты на заводе Roshen
		   for(int i=0;i<3;i++) {
			   SweetsPlant objSweetsPlant = getSweetsPlant("Конфета");
			   Sweetness objSweetness = objSweetsPlant.createSweetness("Конфета");
			   sweetness.add(objSweetness);
		   }
		 //произведём четыре шоколадки на заводе Nestle
		   for(int i = 0 ; i < 4 ; i++) {
			   SweetsPlant objSweetsPlant = getSweetsPlant("Шоколад");
			   Sweetness objSweetness = objSweetsPlant.createSweetness("Шоколад");
			   sweetness.add(objSweetness);
				   }
		 //создадим в компании по производству упаковак упаковку синего цвета
		   PackingСompanySweets objPackingСompanySweets = getPackageSweets("Красная упаковка");
		   PackageSweets objPackageSweets = objPackingСompanySweets.createPackageSweets("Красная упаковка");
		   packageSweets.add(objPackageSweets);
     
     
     
     //создадим подарок из всех что у нас есть сладостей и назовём её "сладкое наслаждение"
		   Present objPresent = new Present("Сладкое наслаждение",packageSweets,sweetness);
		   presents.add(objPresent);
     //посмотрим что получилось
     for (Present u : presents) {
	    	System.out.println(u);
	    }
        
	}
	//================проверка исключений варианта А================
	public static Greenhouse getRoseFlowerGreenhouse(String greenhouse) { //проверка данных
    	if(greenhouse.equals("Роза"))
		return new RoseFlowerGreenhouse();
    	else if(greenhouse.equals("Ромашка"))
    		return new СhamomileGreenhouse();
    	throw new RuntimeException("Не таких цветов в наличии: "+greenhouse);// исключение
    }
	public static PackingСompany getPackingCompany(String packingCompany) { //проверка данных
    	if(packingCompany.equals("Красная упаковка"))
		return new RedPackingCompany();
    	else if(packingCompany.equals("Синяя упаковка"))
    		return new BluePackingCompany();
    	throw new RuntimeException("Компаний по производству таких упаковак нет : "+packingCompany);
    }
	//================проверка исключений варианта Б================
	public static SweetsPlant getSweetsPlant(String sweetsPlant) { //проверка данных
    	if(sweetsPlant.equals("Конфета"))
		return new RoshenSweetsPlant();
    	else if(sweetsPlant.equals("Шоколад")) 
    		return new NestleSweetsPlant();
    	throw new RuntimeException("Сладостей такого вида не производят: " + sweetsPlant);// исключение
    }
	public static PackingСompanySweets getPackageSweets(String packingСompanySweets) { //проверка данных
    	if(packingСompanySweets.equals("Красная упаковка"))
		return new RedPackingСompanySweets();
    	else if(packingСompanySweets.equals("Синяя упаковка"))
    		return new BluePackingСompanySweets();
    	throw new RuntimeException("Компаний по производству таких упаковак нет : "+packingСompanySweets);
}
}
//Основной класс цветочная композиция ===========================Вариант А=========================================
class FlowerComposition{
	private String name; //композиция имеет название
	private List<Package> packages; //компазиция упакована в одну или несколько упаковак
	private List<Flower> flowers;//в состав цветочной компазиции входят цветы
	
	FlowerComposition(String name, List<Package> packages, List<Flower> flowers){
		this.name=name;
		this.packages=packages;
		this.flowers=flowers;
	}
	
	 @Override
		public String toString() {
			String s="";
			String s2="";
		            s = s + "\r\n   "
		            		+ ""+flowers.toString()+" "
		            						+ " ";
		            s2 = s2 + " \r\n    "
		            		+ ""+packages.toString()+" "
		            						+ " ";
		       
				 return "" +
	            "\r\n Название компазиции :'" + name + '\'' +
	            ",\r\n Цветы композиции : '" + s  + '\'' +
	            ",\r\n Композиция упакована в : '" + s2  + '\'' +
	            '}';
		}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}
	
}
//Шаблоны Java. Фабричный метод (Factory Method) для цветов
interface Flower{ //интерфейс  цветок
	
	void showFlower();
	
}
class RoseFlower implements Flower{ // класс роза
	private String name; //название цветка
	RoseFlower(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showFlower() {
		System.out.println("Роза");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class Сhamomile implements Flower{ // класс ромашка
	private String name;
	Сhamomile(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showFlower() {
		System.out.println("Ромашка");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
interface Greenhouse{ // интерфейс цветная оранжерея для создания цветов
	Flower createFlower(String name);
}
class RoseFlowerGreenhouse implements Greenhouse{ //оранжерея по выращиванию роз
public Flower createFlower(String name) {
	return new RoseFlower(name);
}	
}
class СhamomileGreenhouse implements Greenhouse{  //оражерея по выращиванию Ромашек
public Flower createFlower(String name) {
	return new Сhamomile(name);
}	
}
//Шаблоны Java. Фабричный метод (Factory Method) для упаковак
interface Package{ //интерфейс  упаковка
	void showPackage();
}
class RedPackage implements Package{ // класс красная упаковка
	private String name;
	
	RedPackage(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	
	public void showPackage() {
		System.out.println("Красная упаковка");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class BluePackage implements Package{ // класс синяя упаковка
	private String name;
	BluePackage(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showPackage() {
		System.out.println("Синяя упаковка");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
interface PackingСompany{ // интерфейс компании по созданию упаковак
	Package createPackage(String  name);
}
class RedPackingCompany implements PackingСompany{ //класс компания по созданию красных упаковак
public Package createPackage(String name) {
	return new RedPackage(name);
}	
}
class BluePackingCompany implements PackingСompany{  //класс компания по созданию синих упаковак
public Package createPackage(String name) {
	return new BluePackage(name);
}	
}


//Основной класс подарок ===========================Вариант Б=========================================
class Present{
	private String name; // Подарок имеет название
	private List<PackageSweets> packageSweets; //подарок упакован в одну или несколько упаковак
	private List<Sweetness> sweetness;//в состав подарка входят сладости
	
	Present(String name, List<PackageSweets> packageSweets, List<Sweetness> sweetness){
		this.name=name;
		this.packageSweets=packageSweets;
		this.sweetness=sweetness;
	}
	
	 @Override
		public String toString() {
			String s="";
			String s2="";
		            s = s + "\r\n   "
		            		+ ""+sweetness.toString()+" "
		            						+ " ";
		            s2 = s2 + " \r\n    "
		            		+ ""+packageSweets.toString()+" "
		            						+ " ";
		       
				 return "" +
	            "\r\n Название подарка :'" + name + '\'' +
	            ",\r\n Конфеты в подарке : '" + s  + '\'' +
	            ",\r\n Подарок упакован в : '" + s2  + '\'' +
	            '}';
		}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PackageSweets> getPackageSweets() {
		return packageSweets;
	}

	public void setPackageSweets(List<PackageSweets> packageSweets) {
		this.packageSweets = packageSweets;
	}

	public List<Sweetness> getSweetness() {
		return sweetness;
	}

	public void setSweetness(List<Sweetness> sweetness) {
		this.sweetness = sweetness;
	}
	
}
//Шаблоны Java. Фабричный метод (Factory Method) для сладостей
interface Sweetness{ //интерфейс  сладость
	
	void showSweetness();
	
}
class Candy implements Sweetness{ // класс конфета
	private String name; //название конфеты
	Candy(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showSweetness() {
		System.out.println("Конфета");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


class Сhocolate implements Sweetness{ // класс шоколад
	private String name;
	Сhocolate(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showSweetness() {
		System.out.println("Шоколад");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
} 
interface SweetsPlant{ // завод по производству сладостей
	Sweetness createSweetness(String name);
}
class RoshenSweetsPlant implements SweetsPlant{ //Линия производства компании Roshen
public Sweetness createSweetness(String name) {
	return new Candy(name);
}	
}
class NestleSweetsPlant implements SweetsPlant{  //Линия производства компании Nestle
public Sweetness createSweetness(String name) {
	return new Сhocolate(name);
}	
}
//Шаблоны Java. Фабричный метод (Factory Method) для упаковак сладостей
interface PackageSweets{ //интерфейс  упаковка для сладостей
	void showPackage();
}
class RedPackageSweets implements PackageSweets{ // класс красная упаковка для сладостей
	private String name;
	
	RedPackageSweets(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	
	public void showPackage() {
		System.out.println("Красная упаковка");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class BluePackageSweets implements PackageSweets{ // класс синяя упаковка для сладостей
	private String name;
	BluePackageSweets(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showPackage() {
		System.out.println("Синяя упаковка");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
interface PackingСompanySweets{ // интерфейс компании по созданию упаковак
	PackageSweets createPackageSweets(String  name);
}
class RedPackingСompanySweets implements PackingСompanySweets{ //класс компания по созданию красных упаковак для сладоствей
public PackageSweets createPackageSweets(String name) {
	return new RedPackageSweets(name);
}	
}
class BluePackingСompanySweets implements PackingСompanySweets{  //класс компания по созданию синих упаковак для сладостей
public PackageSweets createPackageSweets(String name) {
	return new BluePackageSweets(name);
}	
}
