package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.Arco;
import it.polito.tdp.food.db.Condiment;
import it.polito.tdp.food.db.FoodDao;
import it.polito.tdp.food.db.IngredientiECibi;

public class Model {
FoodDao dao;
List<Condiment> vertici;
List<Arco> archi;
Graph<Condiment, DefaultWeightedEdge> grafo;
Map<Integer, Condiment> idMap;

public Model() {
	dao=new FoodDao();
}

public void creaGrafo(double calorie) {
	idMap=new TreeMap();
	vertici=dao.getIngredienti(calorie);
	grafo=new SimpleWeightedGraph(DefaultWeightedEdge.class);
	for(Condiment c: vertici) {
		grafo.addVertex(c);
		idMap.put(c.getCondiment_id(),c);
	}
	archi=dao.getArchi(idMap);
	for(Arco a: archi) {
		grafo.addEdge(a.getC1(), a.getC2());
		grafo.setEdgeWeight(a.getC1(), a.getC2(), a.getPeso());
	}
	
	
}

public List<IngredientiECibi> getRes(){
	List<IngredientiECibi> res=new ArrayList();
	for(Condiment c: grafo.vertexSet()) {
		double peso=0;
		for(DefaultWeightedEdge d: grafo.edgesOf(c)) {
			peso+=grafo.getEdgeWeight(d);
		}
		res.add(new IngredientiECibi(c,peso));
	}
	Collections.sort(res);
	return res;
}

public void chiamaRicorsione(Condiment c) {
 Ricorsione r=new Ricorsione();
 List<Condiment> lista=new ArrayList(grafo.vertexSet());
 List<Condiment> vuota=new ArrayList();
 r.algRic(lista, 0.0, grafo, vuota);
 System.out.println(r.getSoluzioneDef());
	
}

}
