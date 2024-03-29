package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ca.uqam.h2024.inf2120.grpe30.tp2.adt.PositionException;
import ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl.EquipeImpl;
import ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl.tests.Membre;

public class TestMembre {


	public static void main(String[] args) {
		
		 Map<Integer,Membre> listePositions = new HashMap<>();

		 EquipeImpl<Membre> equipeCourante = new EquipeImpl<Membre>();
		 EquipeImpl<Membre> equipeTda = new EquipeImpl<Membre>();  
		 
		 Membre membre;
		 Membre membre1;
		 Membre membre2;
		 Membre membre3;
		 Membre membre4;
		 Membre membre5;
		 Membre membreNull;
		
		membre = new Membre("BETA2579","Alpha","Beta");
		membre1 = new Membre("BARN1234","Barry","Noah");
		membre2 = new Membre("JACO4789","Jacques","Omer");
		membre3 = new Membre("KEIN4931","Keita","Nala");
		membre4 = new Membre("COSF2546","Costin","Fred");
		membre5 = new Membre("KANA5906", "Kante", "Albert");
	
		

		
		equipeCourante.ajouter(membre1);
		equipeCourante.ajouter(membre2);
		equipeCourante.ajouter(membre3);
		
		equipeTda.ajouter(membre2);
		equipeTda.ajouter(membre3);
		equipeTda.ajouter(membre4);
		equipeTda.ajouter(membre5);
		List<Membre> list=new ArrayList<>();
		

		list = equipeCourante.comparer(equipeTda);
		int nb=equipeTda.obtenirNbMembres();
		equipeCourante.ajouter(equipeTda);
		//equipeCourante.remplacer(membre1, membre);
		Iterator<Membre> it=equipeCourante.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println(list);

		System.out.println(nb);
		
		System.out.println("\n\n");
		 
		
		 
		 listePositions = equipeCourante.obtenirLesMembres();
		 for(Integer i : listePositions.keySet()) {
			 
			 System.out.println(i+":"+listePositions.get(i)); 
		 }
		 try {
			equipeCourante.ajouter(0, membre);
		} catch (PositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //equipeCourante.retirer(membre1);
		 //equipeCourante.retirer(equipeTda);
		 System.out.println("\n\n"); 
		 listePositions = equipeCourante.obtenirLesMembres();
		 for(Integer i : listePositions.keySet()) {
			 
			 System.out.println(i+":"+listePositions.get(i)); 
		 }
		 

	
	}

}
