package it.polito.tdp.food.db;

public class IngredientiECibi implements Comparable<IngredientiECibi> {
	Condiment c;
	Double numCibi;
	
	public IngredientiECibi(Condiment c, Double numCibi) {
		this.c = c;
		this.numCibi = numCibi;
	}

	@Override
	public String toString() {
		return "IngredientiECibi [c=" + c + " "+c.getCondiment_calories()+ ", numCibi=" + numCibi + "]";
	}

	@Override
	public int compareTo(IngredientiECibi arg0) {
		// TODO Auto-generated method stub
		return -this.c.getCondiment_calories().compareTo(arg0.c.getCondiment_calories());
	}
	
	

}
