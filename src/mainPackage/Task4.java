package mainPackage;
//������ 4.
//������� ���������� ����������, ��������������� ��������� �����������:
//� ���������� ������ ���� ��������-, � �� ����������-���������������.
//� ������ ����� ������ ����� ���������� ����� �������� � ������������� ������.
//� ������������ ������ ����������� ������ �����, ����� ��� ����� �����.
//� ��� ����������� ������ ���� ������������ ���������� �� ���������� ���� java code convention.
//� ������ ������ ���� �������� ��������� �� �������.
//� ���������� ���� ������ ���� �����������.
//� ��� �������� ������ ����� ������������ �����.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Task4.Treasure;
import Task4.DragonCave;
import java.io.*;

//� ������ � ��� ���������. ������� ���������, ����������� ������������ �������� � 100 ���������� � ������ �������.
//� ����������� ����������� ��������� ��������, ������ ������ �������� �� ��������� ��������� � ������ �������� 
//� �� �������� �����.
public class Task4 {

	public static void main(String[] args) throws Exception { //���������� ����� (������������ ������� �����)
														     
	   List<DragonCave> dragonCaves = new ArrayList<>();
	   List<Treasure> treasures = new ArrayList<>();
	  
	  //������������ ����� C:\Users\Pc\eclipse-workspace\Basics of OOP (Tasks 5)
	   FileReader fr = new FileReader( "Treasure.txt" );
	   Scanner scan2 = new Scanner(fr);
	   
	   //�������� ���������
	   while (scan2.hasNextLine()) {
            Treasure objTreasure = new Treasure(scan2.nextLine(), Integer.parseInt(scan2.nextLine()));
            treasures.add(objTreasure);
       }
	   scan2.close();
       fr.close();
       
       Scanner scan = new Scanner(System.in);
       int x = 0;
       String s ="";
       
       //�������� ������ ������� � �������� ���� ���������
       DragonCave objDragonCave = new DragonCave("������ �������� ������� ",treasures);
       dragonCaves.add(objDragonCave);
       
       String s1 ="";
       
       while (!"4".equals(s)){
           System.out.println("1. ��� ��������� �������� ������� ==> 1");
           System.out.println("2. ��� ������ ������ �������� �� ��������� ��������� ������� ==> 2");
           System.out.println("3. ��� ������ �������� �� �������� ����� ������� ==> 3");
           System.out.println("4. ��� ������ ������� ==> 4");
           s = scan.next();
           try {
               x = Integer.parseInt(s);
           } catch (NumberFormatException e){
               System.out.println("�������� ����");
           }
           switch (x){
               case 1:	
                   // ����� ������ 1
               	System.out.println("===== ������ ����� ���� 1 =====");
               	for (DragonCave u : dragonCaves) {
           	    	System.out.println(u);
           	    }
                   break;
               case 2:
                   // ����� ������ 2
               	System.out.println("===== ������ ����� ���� 2 =====");
               	System.out.println("����������� �����....");
               	System.out.println(" ������� ����� ������� ��������� ��� ��������� " 
               	+ objDragonCave.mostExpensive()+"$ \r\n");	 
                   break;
               case 3:
            	   System.out.println("===== ������ ����� ���� 3 =====");
                   // ����� ������ 3
            		System.out.println("������� ����� ��������:");
                   	s1=scan.next();
                   	System.out.println(" " + objDragonCave.treasureSelection(Integer.parseInt(s1)));
                   break;
           }
       }
       System.out.println("�� ��������!");
       scan.close();
	}

}
