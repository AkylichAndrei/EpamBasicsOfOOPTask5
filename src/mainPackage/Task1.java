package mainPackage;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




// Создать объект класса Текстовый файл, 
// используя классы Файл, Директория.
// Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
class Directory{
	private String name;
	private List<File> files;
	Directory(String name, List<File> files){
		this.setName(name);
		this.files = files;
	}
	 @Override
		public String toString() {
			String s="";
			  for (int i=0; i < files.size(); i++)
		        {
		            s = s + " |+++++| Название файла : "
		            		+ ""+files.get(i).getName()+" "
		            				+ "|| Содержимое файла: "
								      	+ ""+files.get(i).getContent()+" |+++++|"
		            						+ " ";
		        }
				 return "{" +
	            "Название просматриваемой папки :'" + name + '\'' +
	            ", Список доступных файлов и их содержимое : ||'" + s  + '\'' +
	            '}';
		}
	void create(List<File> files) {
		this.files=files;
	}
	void rename(String s1, String s2) {
		for (int i=0; i < files.size(); i++)
			if(files.get(i).getName().equals(s1)==true)//сравнение 
				{
				files.get(i).setName(s2);
				System.out.println("Переименование завершено!");
				}
	}
	void addText(String s1, String s2) {
		for (int i=0; i < files.size(); i++)
			if(files.get(i).getName().equals(s1)==true)//сравнение 
				{
				//s2.concat(files.get(i).getContent()); //накладывает содержимое на уже имеющееся
				s2= files.get(i).getContent() + s2 ;
				files.get(i).setContent(s2);
				System.out.println("Текст добавлен!");
				}
	}
	void delete(String s1){
		for (int i=0; i < files.size(); i++)
			if(files.get(i).getName().equals(s1)==true)//сравнение 
				{
				files.remove(i);
				System.out.println("Файл успешно удалён!");
				}
	}
	public List<File> getFiles() {
		return files;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class File{
	private String name;
    private String content;
    File(String name, String content){
    	this.setName(name);
    	this.setContent(content);
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
public class Task1 {
	public static void main(String[] args) {
		 List<Directory> folders = new ArrayList<>();
	     List<File> files = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
        int x = 0;
        String s ="";
        String s1 ="";
        String s2 ="";
        Directory objDirectory = new Directory("Новая папка",null);
        folders.add(objDirectory);
        while (!"6".equals(s)){
            System.out.println("1. Для создания текстового файла введите ==> 1");
            System.out.println("2. Для переименовывания файла введите ==> 2");
            System.out.println("3. Для того чтобы вывести на консоль введите ==> 3");
            System.out.println("4. Для дополнения текстового файла введите ==> 4");
            System.out.println("5. Для удаления текстового файла введите ==> 5");
            System.out.println("5. Для выхода введите ==> 6");
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
                	System.out.println("Введите название файла:");
                	s1=scan.next();
                	scan.nextLine();
                	System.out.println("Введите содержимое файла:");
                	s2=scan.nextLine();
                	File objFile1 = new File(s1,s2); 
            		files.add(objFile1);
                	objDirectory.create(files);
                    break;
                case 2:
                    // вызов метода 2
                	System.out.println("===== Выбран пункт меню 2 =====");
                	System.out.println("Введите название файла для переимонавания:");
                	s1=scan.next();
                	scan.nextLine();
                	System.out.println("Введите новое имя:");
                	s2=scan.nextLine();
                	objDirectory.rename(s1,s2);            	    
                    break;
                case 3:
                    // вызов метода 3
                	System.out.println("===== Выбран пункт меню 3 =====");
            	 	System.out.println("===== Список папок");
            	    for (Directory u : folders) {
            	    	System.out.println(u);
            	    }
            	    
                    break;
                case 4:
                    // вызов метода 4
                	System.out.println("===== Выбран пункт меню 4 =====");
                	System.out.println("Введите название файла для дополнения:");
                	s1=scan.next();
                	scan.nextLine();
                	System.out.println("Введите тескт для дополнения:");
                	s2=scan.nextLine();
                	objDirectory.addText(s1,s2);  
                    break;
                case 5:
                    // вызов метода 5
                	System.out.println("===== Выбран пункт меню 5 =====");
                	System.out.println("Введите название файла для удаления:");
                	s1=scan.next();
                	objDirectory.delete(s1);  
                    break;
               
            }
        }
        System.out.println("До свидания!");
        scan.close();
	}

}
