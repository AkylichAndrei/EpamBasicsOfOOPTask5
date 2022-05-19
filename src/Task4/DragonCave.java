package Task4;

import java.util.List;

public class DragonCave {//пещера дракона
	private String name;//название пещеры
	private List<Treasure> treasures; //сокровища в пещере
	
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
				  s=s + "\r\n  |+++++| Название сокровища  : "
		            		+ ""+ treasures.get(i).getName() + " "
		            				+ "  |+++++| Стоимость  : "
		            					+ ""+treasures.get(i).getCost()+" $  "
		            						+ " ";
	         
	        }
			 return "{" +
            " Вы просматриваете :'" + this.name  + " \r\n "+
            ", Список сокровищ : ||'" + s  + '\'' +
            '}';
	}
	//самое дорогое сокровище
	public int mostExpensive() {
		int x=0;
		for (int i=0; i < treasures.size(); i++)
			if(treasures.get(i).getCost()>x)
				x=treasures.get(i).getCost();
		return x;
	}
	//выборка сокровищ по сумме
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
		return "Найдены сокровища на выбранную сумму:"+x+" Общая стоимость: "+ temp;
		else return "К сожелению сокровищ на заданную сумму нет, но есть на сумму поменьше: "+
		x+" Общая стоимость: "+ temp;
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
