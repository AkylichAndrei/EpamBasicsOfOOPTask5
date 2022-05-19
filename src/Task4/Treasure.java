package Task4;

public class Treasure { //сокровище дракона
private String name; //название сокровища
private int cost; // стоимость сокровища

public Treasure(String name, int cost){
	this.name=name;
	this.cost=cost;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getCost() {
	return cost;
}

public void setCost(int cost) {
	this.cost = cost;
}
}
