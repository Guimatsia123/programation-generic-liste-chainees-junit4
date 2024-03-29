package ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * UQAM - Hiver 2024 
 * INF2120 - Groupe 30 - TP2
 * @enseignant: Ismael Doukoure
 * EquipeImpl<T> : est une classe qui implemente l'interface EquipeTda et redéfinir 
 * toutes les méthodes de l'interface. 
 *  
 * @author MARIUS GUIMATSIA AKALONG (GUIM27309006)
 * @version 6 mars 2024
 */

import ca.uqam.h2024.inf2120.grpe30.tp2.adt.EquipeTda;
import ca.uqam.h2024.inf2120.grpe30.tp2.adt.PositionException;

public class EquipeImpl<T> implements EquipeTda<T> {
	
	private Noeud<T> uneEquipe;
	private short nbMembres;
	
	public EquipeImpl(){
		this.uneEquipe=null;
		this.nbMembres=0;
	}	

	@Override
	public Iterator<T> iterator() {
		return new EquipeIterateur<T>(this.uneEquipe) ;
	}

	/**
	* Ajoute un membre dans l'équipe courante.
	* 
	* Si le membre n'est pas null, et il n'existe pas dans l'équipe courante, il
	* est ajouté à la fin de l'équipe courante et la méthode retourne vrai, sinon
	* elle retourne faux.
	* 
	* @param membre le membre à ajouter
	* @return true si le membre n'est pas null, il n'existe pas dans l'équipe et
	*         qu'il a été ajouté, sinon false
	 */	
	
	@Override
	public boolean ajouter(T membre) {
		
		boolean estAjouter=false;
		if(membre != null && !estMembre(membre))
		{
			if(this.estVide()) {
				uneEquipe=new Noeud<T>(membre);
				estAjouter=true;
				
			}else {
				Noeud<T> courant=uneEquipe;
				while(courant.getSuivant() != null) {
					courant = courant.getSuivant();
				}
				Noeud<T> unMembre=new Noeud<T>(membre);
				courant.setSuivant(unMembre);
				estAjouter=true;
			}
			
		}
		
		return estAjouter;
	}
	

	 /**
	 * Ajoute un membre dans l'équipe courante à une position donnée .
	 * 
	 * Si la position est dans le bon intervalle (la position est supérieure ou
	 * égale à 0 et inférieure ou égale à la taille de l'équipe courante), le membre
	 * n'est pas null, et il n'existe pas dans l'équipe courante, il est ajouté et
	 * la méthode retourne vrai, sinon elle retourne faux. Le membre doit être
	 * ajouté à la position identifiée en déplaçant le membre courant à la position
	 * suivante (ce qui entraîne le déplacement automatiquement des autres membres
	 * qui viennent après ce membre courant). La position du premier membre de
	 * l'équipe est considérée comme 0.
	 * 
	 * @param position où le membre doit être ajouté
	 * @param membre le membre à ajouter
	 * @throws PositionException si la position n'est pas dans le bon intervalle
	 * @return true si la position est bonne, le membre n'est pas null, il n'existe
	 *         pas dans l'équipe et qu'il est ajouté, sinon false
	 */
	@Override
	public boolean ajouter(int position, T membre) throws PositionException {
		boolean estAjouter = false;
		boolean cibleTrouve = false; 
		
		if(!this.estVide() && membre != null && !this.estMembre(membre)) {
			
			if(position < 0 || position > this.obtenirNbMembres()-1) {
				throw new PositionException("Erreur d'ajout du membre - La postion ne se trouve pas dans le bon interval.");
				
			}else {
				Map<Integer,T> membresPosition = this.obtenirLesMembres();
				Noeud<T> courant=this.uneEquipe;
				Noeud<T> precedent=null;				
				for(Integer i : membresPosition.keySet()) {
					
					if(position == i) {
						
						cibleTrouve=true;
						break;
					}else {
						precedent=courant;
						courant = courant.getSuivant();
					}	
				}
			Noeud<T> unMembre = new  Noeud<T>(membre);
			if(cibleTrouve) {
				if(precedent == null) {
					unMembre.setSuivant(this.uneEquipe);
					this.uneEquipe=unMembre;
					estAjouter = true;
				}else {
					precedent.setSuivant(unMembre);
					unMembre.setSuivant(courant);
					estAjouter = true;
					
				}	
				
			}	
			}
			
		}
		
		return estAjouter;
	}
	/**
	 * Retourne le dernier membre de l'equipe courante
	 * 
	 *  @return membre le dernier noeud de l'equipe courante.
	 * 
	 */
	
	private Noeud<T> retournerDernierElement(){
		Noeud<T> membre = this.uneEquipe;
		
		while(membre.getSuivant() != null) {
			membre = membre.getSuivant();
		}
		return membre;
		
	}

	   /**
	    * Ajoute les membres de l'équipe passée en paramètre dans l'équipe courante.
	    * Les membres sont ajoutés à la fin de l'équipe courante.
	    * 
	    * Tous les membres de l'équipe passée en paramètre sont ajoutés dans l'équipe
	    * courante et retourne un tableau liste des membres de l'équipe passée en
	    * paramètre qui n'ont pas été ajoutés, car ils existent déjà.
	    * 
	    * @param equipe l'équipe dont les membres doivent être ajoutés
	    * @return Le tableau liste (ArrayList<T>) des membres de l'équipe passée en
	    *         paramètre qui n'ont pas été ajoutés, null si tous les membres ont été
	    *         ajoutés ou si l'équipe passée en paramètre est null ou vide
	    */
	@Override
	public List<T> ajouter(EquipeTda<T> equipe) {
		
		List<T> membreNonAjoutes = new ArrayList<T>();
		List<T> membresAjoutes = new ArrayList<T>();
		if(!equipe.estVide()) {
			Iterator<T> it = equipe.iterator();
			
			if(this.estVide()) {
				Noeud<T> uneEquipe=new Noeud<T>(it.next());
				while(it.hasNext()) {
					uneEquipe.setSuivant(new Noeud<T>(it.next()));			
				}
			}else{
				
				Noeud<T> dernierMembre=retournerDernierElement();
				
				while(it.hasNext()) {
					
				Noeud<T> membre = new Noeud<T>(it.next());
				
				if(!estMembre(membre.getElement())) {	
					this.ajouter(membre.getElement());
					dernierMembre.setSuivant(membre);	
					dernierMembre=membre;
				}else {
					membreNonAjoutes.add(membre.getElement());

				}
				
			}	
			}
		}
		if(membreNonAjoutes.isEmpty()) { 
			membreNonAjoutes = null ;
		}
			
		
		return membreNonAjoutes;
	}
	
	   /**
	    * Compare l'équipe courante à celle passée en paramètre.
	    * 
	    * Si l'équipe courante contient tous les membres de celle passée en paramètre,
	    * la méthode retourne null, sinon un tableau liste (ArrayList<T>) est retourné
	    * avec les membres de l'équipe passée en paramètre qui n'existent pas dans
	    * l'équipe courante.
	    *
	    * @param equipe l'équipe à comparer à l'équipe courante
	    * @return null si l'équipe courante contient tous les membres de l'équipe
	    *         passée en paramétre, sinon un tableau liste (ArrayList<T>) des
	    *         membres qui n'existent pas dans l'équipe courante est retourné
	    */

	@Override
	public List<T> comparer(EquipeTda<T> equipe) {
		List<T> membresNonInclus= new ArrayList<>();
		Iterator<T> it = equipe.iterator();
		if(this.estVide() && !equipe.estVide()) {
			
			while(it.hasNext()) {
				membresNonInclus.add(it.next());	
			}
		}else if(!this.estVide() && !equipe.estVide()) {
			// On prend chaque element de la liste passee en parametre et on compare 
			// a la liste courante.
			while(it.hasNext()) {
				Noeud<T> courant= new Noeud<>(it.next());
				if(!this.estMembre(courant.getElement())) {
					membresNonInclus.add(courant.getElement());	
				}		
				
			}
		
		}
		if(membresNonInclus.isEmpty()) {
			membresNonInclus = null;
		}
		
		return membresNonInclus;
	}
	   /**
	    * Vérifie si l'équipe courante contient le membre passé en paramètre.
	    * 
	    * Si l'équipe courante contient le membre passé en paramètre, la methode
	    * retourne vrai, sinon elle retourne faux.
	    * 
	    * @param membre le membre dont l'existence doit être vérifiée
	    * @return vrai si le membre existe, sinon faux
	    */
	@Override
	public boolean estMembre(T membre) {
		boolean estMembre=false;
		
		if(!this.estVide()) {
			Noeud<T> unMembre=uneEquipe;
			
			
			while(unMembre != null && !estMembre) {
				
				if(unMembre.getElement().equals(membre)){
					estMembre=true;
				}else {
					unMembre=unMembre.getSuivant();
					
				}
			}
		}

		return estMembre;
	}
	   /**
	    * Retourne le nombre de membres de l'équipe courante.
	    * 
	    * Le nombre total des membres dans l'équipe courante doit être retourné.
	    * 
	    * @return Le nombre total des membres de l'équipe courante
	    */
	@Override
	public int obtenirNbMembres() {		
		if(!this.estVide()) {
			Noeud<T> membreActuel=this.uneEquipe;
			this.nbMembres=0;
			while(membreActuel != null) {
				this.nbMembres++;
				membreActuel=membreActuel.getSuivant();
		
			}
		}
		return this.nbMembres;
		
	}

	   /**
	    * Retire le membre passé en paramètre de l'équipe courante.
	    * 
	    * Le membre passé en paramètre doit être retiré s'il existe dans l'équipe
	    * courante.
	    * 
	    * @param membre le membre à retirer
	    * @return vrai si le membre est retiré, sinon faux
	    */
	@Override
	public boolean retirer(T membre) {
		boolean estRetirer=false;
		boolean cibleTrouver=false;
		Noeud<T> membrePrecedent=null;
		
		if(!this.estVide()) {
			if(this.estMembre(membre)) {
				Noeud<T> membreActuel=uneEquipe;
				while(membreActuel != null && !cibleTrouver) {
					if(membreActuel.getElement().equals(membre)) {
						cibleTrouver=true;
					}else {
						membrePrecedent=membreActuel;
						membreActuel=membreActuel.getSuivant();
					}
					
				}
			if(cibleTrouver) {
				// Si le precedent est nul alors la cible c'est le premier
				// element de la liste.
				if(membrePrecedent == null) {
					this.uneEquipe=membreActuel.getSuivant();
					estRetirer=true;
				}else {
					membrePrecedent.setSuivant(membreActuel.getSuivant());
					estRetirer=true;				
					
				}
			}
				
			}
		}
		return estRetirer;
	}
	   /**
	    * Retire tous les membres de l'équipe passée en paramètre de l'équipe courante.
	    * 
	    * Tous les membres de l'équipe passée en paramètre doivent être retirés de
	    * l'équipe courante s'ils existent.
	    * 
	    * @param equipe l'équipe dont les membres doivent être retirés
	    * @return Le tableau (ArrayList<T>) des membres de l'équipe passée en paramètre
	    *         qui n'ont pas été retirés, null si tous les membres ont été retirés
	    *         ou si l'équipe passée en paramètre est nulle ou vide.
	    */
	@Override
	public List<T> retirer(EquipeTda<T> equipe) {
	
		List<T> listeMembresNonRetires=new ArrayList<>();

		if(!this.estVide() && !equipe.estVide()) {
			Iterator<T> it = equipe.iterator();
			while(it.hasNext()) {
				T membre = it.next();
				if(this.estMembre(membre)) {
					this.retirer(membre);
				 
				}else {
					listeMembresNonRetires.add(membre);
				}
				
			}
		}
		if(listeMembresNonRetires.isEmpty()) {
			listeMembresNonRetires = null;
		}
		
		return listeMembresNonRetires;
	}

	   /**
	    * Remplace un membre par un autre dans l'équipe courante. Le membre à remplacer
	    * doit exister et le nouveau membre ne doit pas être null. Aucun remplacement
	    * si l'équipe courante contient déjà le nouveau membre.
	    * 
	    * @param membreARemplacer Le membre de l'équipe courante à remplacer
	    * @param nouveauMembre    Le nouveau membre à ajouter
	    * @return vrai si le remplacement a été fait, sinon faux
	    */
	@Override
	public boolean remplacer(T membreARemplacer, T nouveauMembre) {
		boolean estRemplacer=false;
		boolean cibleTrouve=false;
		Noeud<T> nouveauMb=new Noeud<T>(nouveauMembre);
		
		if(this.uneEquipe != null && nouveauMb != null) {
			
			if( this.estMembre(membreARemplacer) && !this.estMembre(nouveauMembre)) {
				Noeud<T> membreActuel=this.uneEquipe;
				Noeud<T> membrePrecedent=null;
				while(membreActuel != null && !cibleTrouve) {
					if(membreARemplacer.equals(membreActuel.getElement())) {
						cibleTrouve=true;
						
					}else {
						membrePrecedent=membreActuel;
						membreActuel=membreActuel.getSuivant();
					}
				}	
			
			if(cibleTrouve) {
				// Si l'element a remplacer est le debut
				// de la liste alors on creer un nouveau noeud qui pointe vers
				// le suivant du premier noeud et ce noeud devient la tete de liste.
				if(membrePrecedent == null) {
					nouveauMb.setSuivant(uneEquipe.getSuivant());
					this.uneEquipe = nouveauMb;
					estRemplacer=true;
					
				}else {
					membrePrecedent.setSuivant(nouveauMb);
					nouveauMb.setSuivant(membreActuel.getSuivant());
					estRemplacer=true;
				}
			}
			}
		}

		return estRemplacer;
	}

	   /**
	    * Retourne tous les membres de l'équipe courante et leurs positions dans un
	    * HashMap<K,T> (HashMap Clé = position de type Integer, HashMap valeur = membre
	    * de type T).
	    *
	    * @return Le HashMap de tous les membres de l'équipe courante et leurs
	    *         positions, null, si l'équipe courante est vide.
	    */
	@Override
	public Map<Integer, T> obtenirLesMembres() {
		HashMap<Integer,T> membresPosition = null;
		if(!this.estVide()) {
			membresPosition=new HashMap<>();
			int position=0;
			Noeud<T> membre=this.uneEquipe;
			while(membre != null ) {
				membresPosition.put(position, membre.getElement());
				membre = membre.getSuivant();
				position++;
			}
		}else {
			membresPosition = null;

		}
		
		
		return membresPosition;
	}

	   /**
	    * Vérifie si l'équipe courante est vide.
	    * 
	    * @return vrai si l'équipe courante est vide, sinon faux.
	    */
	@Override
	public boolean estVide() {
		return this.uneEquipe == null;
	}
	   /**
	    * Vide l'équipe courante en retirant toutes les membres.
	    */
	@Override
	public void vider() {
		
		this.uneEquipe = null;

	}

}
