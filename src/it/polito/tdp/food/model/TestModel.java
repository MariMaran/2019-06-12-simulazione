package it.polito.tdp.food.model;

public class TestModel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m=new Model();
		m.creaGrafo(20);
		System.out.println(m.grafo.edgeSet().size());
		System.out.println(m.getRes());
		m.chiamaRicorsione(null);

	}
}
