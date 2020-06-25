package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.food.db.Condiment;

public class Ricorsione {
	
	Double pesoMax;
	List<Condiment> soluzioneDef;
	
	public Double getPesoMax() {
		return pesoMax;
	}



	public List<Condiment> getSoluzioneDef() {
		return soluzioneDef;
	}



	public void setPesoMax(Double pesoMax) {
		this.pesoMax = pesoMax;
	}



	public void setSoluzioneDef(List<Condiment> soluzioneDef) {
		this.soluzioneDef = soluzioneDef;
	}



	public Ricorsione() {
		pesoMax=0.0;

	}

	
	
	public void algRic(List<Condiment> lista, double peso, Graph<Condiment, DefaultWeightedEdge> grafo, List<Condiment> soluzione) {
		
		if(peso>pesoMax) {
			pesoMax=peso;
			soluzioneDef=new ArrayList(soluzione);
		}
		
		
		for(Condiment c: lista) {
			List<Condiment> daRimuovere=new ArrayList();
			for(DefaultWeightedEdge d: grafo.edgesOf(c)) {
				daRimuovere.add(Graphs.getOppositeVertex(grafo, d, c));
			}
			soluzione.add(c);
			List<Condiment> lista2=new ArrayList(lista);
			lista2.removeAll(daRimuovere);
			lista2.remove(c);
			algRic(lista2, peso+c.getCondiment_calories(), grafo, soluzione);
			soluzione.remove(c);
		}
	}
}
