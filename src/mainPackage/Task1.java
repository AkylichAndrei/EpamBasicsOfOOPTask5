package mainPackage;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




// ������� ������ ������ ��������� ����, 
// ��������� ������ ����, ����������.
// ������: �������, �������������, ������� �� ������� ����������, ���������, �������.
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
		            s = s + " |+++++| �������� ����� : "
		            		+ ""+files.get(i).getName()+" "
		            				+ "|| ���������� �����: "
								      	+ ""+files.get(i).getContent()+" |+++++|"
		            						+ " ";
		        }
				 return "{" +
	            "�������� ��������������� ����� :'" + name + '\'' +
	            ", ������ ��������� ������ � �� ���������� : ||'" + s  + '\'' +
	            '}';
		}
	void create(List<File> files) {
		this.files=files;
	}
	void rename(String s1, String s2) {
		for (int i=0; i < files.size(); i++)
			if(files.get(i).getName().equals(s1)==true)//��������� 
				{
				files.get(i).setName(s2);
				System.out.println("�������������� ���������!");
				}
	}
	void addText(String s1, String s2) {
		for (int i=0; i < files.size(); i++)
			if(files.get(i).getName().equals(s1)==true)//��������� 
				{
				//s2.concat(files.get(i).getContent()); //����������� ���������� �� ��� ���������
				s2= files.get(i).getContent() + s2 ;
				files.get(i).setContent(s2);
				System.out.println("����� ��������!");
				}
	}
	void delete(String s1){
		for (int i=0; i < files.size(); i++)
			if(files.get(i).getName().equals(s1)==true)//��������� 
				{
				files.remove(i);
				System.out.println("���� ������� �����!");
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
        Directory objDirectory = new Directory("����� �����",null);
        folders.add(objDirectory);
        while (!"6".equals(s)){
            System.out.println("1. ��� �������� ���������� ����� ������� ==> 1");
            System.out.println("2. ��� ���������������� ����� ������� ==> 2");
            System.out.println("3. ��� ���� ����� ������� �� ������� ������� ==> 3");
            System.out.println("4. ��� ���������� ���������� ����� ������� ==> 4");
            System.out.println("5. ��� �������� ���������� ����� ������� ==> 5");
            System.out.println("5. ��� ������ ������� ==> 6");
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
                	System.out.println("������� �������� �����:");
                	s1=scan.next();
                	scan.nextLine();
                	System.out.println("������� ���������� �����:");
                	s2=scan.nextLine();
                	File objFile1 = new File(s1,s2); 
            		files.add(objFile1);
                	objDirectory.create(files);
                    break;
                case 2:
                    // ����� ������ 2
                	System.out.println("===== ������ ����� ���� 2 =====");
                	System.out.println("������� �������� ����� ��� ��������������:");
                	s1=scan.next();
                	scan.nextLine();
                	System.out.println("������� ����� ���:");
                	s2=scan.nextLine();
                	objDirectory.rename(s1,s2);            	    
                    break;
                case 3:
                    // ����� ������ 3
                	System.out.println("===== ������ ����� ���� 3 =====");
            	 	System.out.println("===== ������ �����");
            	    for (Directory u : folders) {
            	    	System.out.println(u);
            	    }
            	    
                    break;
                case 4:
                    // ����� ������ 4
                	System.out.println("===== ������ ����� ���� 4 =====");
                	System.out.println("������� �������� ����� ��� ����������:");
                	s1=scan.next();
                	scan.nextLine();
                	System.out.println("������� ����� ��� ����������:");
                	s2=scan.nextLine();
                	objDirectory.addText(s1,s2);  
                    break;
                case 5:
                    // ����� ������ 5
                	System.out.println("===== ������ ����� ���� 5 =====");
                	System.out.println("������� �������� ����� ��� ��������:");
                	s1=scan.next();
                	objDirectory.delete(s1);  
                    break;
               
            }
        }
        System.out.println("�� ��������!");
        scan.close();
	}

}
