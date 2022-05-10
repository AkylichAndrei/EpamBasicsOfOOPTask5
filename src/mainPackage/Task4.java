package mainPackage;
//Задача 4.
//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Приложение должно быть объектно-, а не процедурно-ориентированным.
//• Каждый класс должен иметь отражающее смысл название и информативный состав.
//• Наследование должно применяться только тогда, когда это имеет смысл.
//• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//• Классы должны быть грамотно разложены по пакетам.
//• Консольное меню должно быть минимальным.
//• Для хранения данных можно использовать файлы.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Task4.Treasure;
import Task4.DragonCave;
import java.io.*;

//• Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
//• Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ 
//• на заданную сумму.
public class Task4 {

	public static void main(String[] args) throws Exception { //волшебнная фраза (безопасность привыше всего)
														     
	   List<DragonCave> dragonCaves = new ArrayList<>();
	   List<Treasure> treasures = new ArrayList<>();
	  
	  //расположение файла C:\Users\Pc\eclipse-workspace\Basics of OOP (Tasks 5)
	   FileReader fr = new FileReader( "Treasure.txt" );
	   Scanner scan2 = new Scanner(fr);
	   
	   //создадим сокровища
	   while (scan2.hasNextLine()) {
            Treasure objTreasure = new Treasure(scan2.nextLine(), Integer.parseInt(scan2.nextLine()));
            treasures.add(objTreasure);
       }
	   scan2.close();
       fr.close();
       
       Scanner scan = new Scanner(System.in);
       int x = 0;
       String s ="";
       
       //создадим пещеру дракона и поместим туда сокровища
       DragonCave objDragonCave = new DragonCave("Пещера красного дракона ",treasures);
       dragonCaves.add(objDragonCave);
       
       String s1 ="";
       
       while (!"4".equals(s)){
           System.out.println("1. Для просмотра сокровищ введите ==> 1");
           System.out.println("2. Для выбора самого дорогого по стоимости сокровища введите ==> 2");
           System.out.println("3. Для выбора сокровищ на заданную сумму введите ==> 3");
           System.out.println("4. Для выхода введите ==> 4");
           s = scan.next();
           try {
               x = Integer.parseInt(s);
           } catch (NumberFormatException e){
               System.out.println("Неверный ввод");
           }
           switch (x){
               case 1:	
                   // вызов метода 1
               	System.out.println("===== Выбран пункт меню 1 =====");
               	for (DragonCave u : dragonCaves) {
           	    	System.out.println(u);
           	    }
                   break;
               case 2:
                   // вызов метода 2
               	System.out.println("===== Выбран пункт меню 2 =====");
               	System.out.println("Выполняется поиск....");
               	System.out.println(" Найдено самое дорогое сокровище его стоимость " 
               	+ objDragonCave.mostExpensive()+"$ \r\n");	 
                   break;
               case 3:
            	   System.out.println("===== Выбран пункт меню 3 =====");
                   // вызов метода 3
            		System.out.println("Введите сумму сокровищ:");
                   	s1=scan.next();
                   	System.out.println(" " + objDragonCave.treasureSelection(Integer.parseInt(s1)));
                   break;
           }
       }
       System.out.println("До свидания!");
       scan.close();
	}

}
