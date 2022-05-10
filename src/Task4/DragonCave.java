package Task4;

import java.util.List;

import Task4.Treasure;

public class DragonCave {//������ �������
	private String name;//�������� ������
	private List<Treasure> treasures; //��������� � ������
	
	public DragonCave(String name){
		this.name=name;
	}
	
	public DragonCave(String name, List<Treasure> treasures){
		this.name=name;
		this.treasures=treasures;
	}
	@Override
	public String toString() {
		String s="";
		  for (int i=0; i < treasures.size(); i++)
	        {
				  s=s + "\r\n  |+++++| �������� ���������  : "
		            		+ ""+ treasures.get(i).getName() + " "
		            				+ "  |+++++| ���������  : "
		            					+ ""+treasures.get(i).getCost()+" $  "
		            						+ " ";
	         
	        }
			 return "{" +
            " �� �������������� :'" + this.name  + " \r\n "+
            ", ������ �������� : ||'" + s  + '\'' +
            '}';
	}
	//����� ������� ���������
	public int mostExpensive() {
		int x=0;
		for (int i=0; i < treasures.size(); i++)
			if(treasures.get(i).getCost()>x)
				x=treasures.get(i).getCost();
		return x;
	}
	//������� �������� �� �����
	public String treasureSelection(int tS) {
		String x="";
		int temp=0;
		int i=0;
		while(tS>temp+treasures.get(i).getCost()) {
			i++;
		    x = x + treasures.get(i).getName()+" || ";
		    temp=temp+treasures.get(i).getCost(); 
		}
		if (temp==tS)
		return "������� ��������� �� ��������� �����:"+x+" ����� ���������: "+ temp;
		else return "� ��������� �������� �� �������� ����� ���, �� ���� �� ����� ��������: "+
		x+" ����� ���������: "+ temp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}

	public void setTreasures(List<Treasure> treasures) {
		this.treasures = treasures;
	}
	

}
