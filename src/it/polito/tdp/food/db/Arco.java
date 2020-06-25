package it.polito.tdp.food.db;

public class Arco {
	Condiment c1;
	Condiment c2;
	Integer peso;
	public Condiment getC1() {
		return c1;
	}
	public Condiment getC2() {
		return c2;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setC1(Condiment c1) {
		this.c1 = c1;
	}
	public void setC2(Condiment c2) {
		this.c2 = c2;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public Arco(Condiment c1, Condiment c2, Integer peso) {
		this.c1 = c1;
		this.c2 = c2;
		this.peso = peso;
	}
	

}
