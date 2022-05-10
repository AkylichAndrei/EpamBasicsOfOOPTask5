package mainPackage;

import java.util.ArrayList;
import java.util.List;

//������� ���������� ����������, ��������������� ��������� �����������:
//� ��������� ������������� � ���������� ���������� ������� ������.  +
//� ��� �������� �������� �� �������� ������� ���������� ����������� ������������� ����������� �������� ��������������. +
//� ���������� �������� ������, �������� �������������, �� �� �� ������� �������. +
//� ��� �������� ������������ ���������� ������ ����� ��������� ���������� ���������, � ����� �� ���������. =)) 
//� ���� ������ �������� ������������� ����� �� �������������, ����������� ��������. +
//� ������ �������: ��������������, ��� ����������, ������ toString(), equals() � hashCode().  +

//������� A. 
//��������� ����������. 
//����������� ����������, ����������� ��������� ��������� ���������� (������, �������������� ����� ��������� ����������). 
//������������� ��������� ���������� �������� ����� � ��������.
//������� B. 
//�������. 
//����������� ����������, ����������� ��������� ������� (������, �������������� ����� �������).
//������������� ������ ������� �������� �������� � ��������.
public class Task5 {
	public static void main(String[] args) {
		//================���������� ��� �������� �================
		   List<Package> packages  = new ArrayList<>();
		   List<Flower> flowers = new ArrayList<>();
		   List<FlowerComposition> flowerCompositions = new ArrayList<>();
		
		//�������� ��� ���� � ��������� ���
		   for(int i=0;i<3;i++) {
			   Greenhouse objGreenhouse = getRoseFlowerGreenhouse("����");
			   Flower flower = objGreenhouse.createFlower("����");
			   flowers.add(flower);
		   }
		 //�������� ��� ������� � ��������� �������
		   for(int i=0;i<2;i++) {
				Greenhouse objGreenhouse = getRoseFlowerGreenhouse("�������");
		        Flower flower = objGreenhouse.createFlower("�������");
		        flowers.add(flower);
				   }
		 //�������� � �������� �� ������������ �������� �������� ������ �����
        Packing�ompany objPackingCompany = getPackingCompany("����� ��������");
        Package objPacking = objPackingCompany.createPackage("����� ��������");
        packages.add(objPacking);
        
        
        
        //�������� ��������� ���������� �� ���� ��� � ��� ���� ������ � ������ � "�������� �������"
        FlowerComposition objFlowerCompositions = new FlowerComposition("�������� �������",packages,flowers);
        flowerCompositions.add(objFlowerCompositions);
        //��������� ��� ����������
        for (FlowerComposition u : flowerCompositions) {
	    	System.out.println(u);
	    }
      //================���������� ��� �������� �================
        
        List<PackageSweets> packageSweets  = new ArrayList<>();
        List<Sweetness> sweetness = new ArrayList<>();
		   List<Present> presents = new ArrayList<>();
		
		//��������� ��� ������� �� ������ Roshen
		   for(int i=0;i<3;i++) {
			   SweetsPlant objSweetsPlant = getSweetsPlant("�������");
			   Sweetness objSweetness = objSweetsPlant.createSweetness("�������");
			   sweetness.add(objSweetness);
		   }
		 //��������� ������ ��������� �� ������ Nestle
		   for(int i = 0 ; i < 4 ; i++) {
			   SweetsPlant objSweetsPlant = getSweetsPlant("�������");
			   Sweetness objSweetness = objSweetsPlant.createSweetness("�������");
			   sweetness.add(objSweetness);
				   }
		 //�������� � �������� �� ������������ �������� �������� ������ �����
		   Packing�ompanySweets objPacking�ompanySweets = getPackageSweets("������� ��������");
		   PackageSweets objPackageSweets = objPacking�ompanySweets.createPackageSweets("������� ��������");
		   packageSweets.add(objPackageSweets);
     
     
     
     //�������� ������� �� ���� ��� � ��� ���� ��������� � ������ � "������� �����������"
		   Present objPresent = new Present("������� �����������",packageSweets,sweetness);
		   presents.add(objPresent);
     //��������� ��� ����������
     for (Present u : presents) {
	    	System.out.println(u);
	    }
        
	}
	//================�������� ���������� �������� �================
	public static Greenhouse getRoseFlowerGreenhouse(String greenhouse) { //�������� ������
    	if(greenhouse.equals("����"))
		return new RoseFlowerGreenhouse();
    	else if(greenhouse.equals("�������"))
    		return new �hamomileGreenhouse();
    	throw new RuntimeException("�� ����� ������ � �������: "+greenhouse);// ����������
    }
	public static Packing�ompany getPackingCompany(String packingCompany) { //�������� ������
    	if(packingCompany.equals("������� ��������"))
		return new RedPackingCompany();
    	else if(packingCompany.equals("����� ��������"))
    		return new BluePackingCompany();
    	throw new RuntimeException("�������� �� ������������ ����� �������� ��� : "+packingCompany);
    }
	//================�������� ���������� �������� �================
	public static SweetsPlant getSweetsPlant(String sweetsPlant) { //�������� ������
    	if(sweetsPlant.equals("�������"))
		return new RoshenSweetsPlant();
    	else if(sweetsPlant.equals("�������")) 
    		return new NestleSweetsPlant();
    	throw new RuntimeException("��������� ������ ���� �� ����������: " + sweetsPlant);// ����������
    }
	public static Packing�ompanySweets getPackageSweets(String packing�ompanySweets) { //�������� ������
    	if(packing�ompanySweets.equals("������� ��������"))
		return new RedPacking�ompanySweets();
    	else if(packing�ompanySweets.equals("����� ��������"))
    		return new BluePacking�ompanySweets();
    	throw new RuntimeException("�������� �� ������������ ����� �������� ��� : "+packing�ompanySweets);
}
}
//�������� ����� ��������� ���������� ===========================������� �=========================================
class FlowerComposition{
	private String name; //���������� ����� ��������
	private List<Package> packages; //���������� ��������� � ���� ��� ��������� ��������
	private List<Flower> flowers;//� ������ ��������� ���������� ������ �����
	
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
	            "\r\n �������� ���������� :'" + name + '\'' +
	            ",\r\n ����� ���������� : '" + s  + '\'' +
	            ",\r\n ���������� ��������� � : '" + s2  + '\'' +
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
//������� Java. ��������� ����� (Factory Method) ��� ������
interface Flower{ //���������  ������
	
	void showFlower();
	
}
class RoseFlower implements Flower{ // ����� ����
	private String name; //�������� ������
	RoseFlower(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showFlower() {
		System.out.println("����");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class �hamomile implements Flower{ // ����� �������
	private String name;
	�hamomile(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showFlower() {
		System.out.println("�������");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
interface Greenhouse{ // ��������� ������� ��������� ��� �������� ������
	Flower createFlower(String name);
}
class RoseFlowerGreenhouse implements Greenhouse{ //��������� �� ����������� ���
public Flower createFlower(String name) {
	return new RoseFlower(name);
}	
}
class �hamomileGreenhouse implements Greenhouse{  //�������� �� ����������� �������
public Flower createFlower(String name) {
	return new �hamomile(name);
}	
}
//������� Java. ��������� ����� (Factory Method) ��� ��������
interface Package{ //���������  ��������
	void showPackage();
}
class RedPackage implements Package{ // ����� ������� ��������
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
		System.out.println("������� ��������");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class BluePackage implements Package{ // ����� ����� ��������
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
		System.out.println("����� ��������");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
interface Packing�ompany{ // ��������� �������� �� �������� ��������
	Package createPackage(String  name);
}
class RedPackingCompany implements Packing�ompany{ //����� �������� �� �������� ������� ��������
public Package createPackage(String name) {
	return new RedPackage(name);
}	
}
class BluePackingCompany implements Packing�ompany{  //����� �������� �� �������� ����� ��������
public Package createPackage(String name) {
	return new BluePackage(name);
}	
}


//�������� ����� ������� ===========================������� �=========================================
class Present{
	private String name; // ������� ����� ��������
	private List<PackageSweets> packageSweets; //������� �������� � ���� ��� ��������� ��������
	private List<Sweetness> sweetness;//� ������ ������� ������ ��������
	
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
	            "\r\n �������� ������� :'" + name + '\'' +
	            ",\r\n ������� � ������� : '" + s  + '\'' +
	            ",\r\n ������� �������� � : '" + s2  + '\'' +
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
//������� Java. ��������� ����� (Factory Method) ��� ���������
interface Sweetness{ //���������  ��������
	
	void showSweetness();
	
}
class Candy implements Sweetness{ // ����� �������
	private String name; //�������� �������
	Candy(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showSweetness() {
		System.out.println("�������");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


class �hocolate implements Sweetness{ // ����� �������
	private String name;
	�hocolate(String name){
		this.name=name;
	}
	 @Override
		public String toString() {
		 String s=this.name;
		 return s;
	 }
	public void showSweetness() {
		System.out.println("�������");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
} 
interface SweetsPlant{ // ����� �� ������������ ���������
	Sweetness createSweetness(String name);
}
class RoshenSweetsPlant implements SweetsPlant{ //����� ������������ �������� Roshen
public Sweetness createSweetness(String name) {
	return new Candy(name);
}	
}
class NestleSweetsPlant implements SweetsPlant{  //����� ������������ �������� Nestle
public Sweetness createSweetness(String name) {
	return new �hocolate(name);
}	
}
//������� Java. ��������� ����� (Factory Method) ��� �������� ���������
interface PackageSweets{ //���������  �������� ��� ���������
	void showPackage();
}
class RedPackageSweets implements PackageSweets{ // ����� ������� �������� ��� ���������
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
		System.out.println("������� ��������");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class BluePackageSweets implements PackageSweets{ // ����� ����� �������� ��� ���������
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
		System.out.println("����� ��������");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
interface Packing�ompanySweets{ // ��������� �������� �� �������� ��������
	PackageSweets createPackageSweets(String  name);
}
class RedPacking�ompanySweets implements Packing�ompanySweets{ //����� �������� �� �������� ������� �������� ��� ����������
public PackageSweets createPackageSweets(String name) {
	return new RedPackageSweets(name);
}	
}
class BluePacking�ompanySweets implements Packing�ompanySweets{  //����� �������� �� �������� ����� �������� ��� ���������
public PackageSweets createPackageSweets(String name) {
	return new BluePackageSweets(name);
}	
}
