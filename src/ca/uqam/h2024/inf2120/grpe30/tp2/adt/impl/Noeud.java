package ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl;

/**
 * UQAM - Hiver 2024
 * INF2120 - Groupe 30 - TP2 
 * 
 * Noeud<T> : représente chacun des noeuds de notre liste simplement chaînée. 
 *            Elle contient un élément (la donnée à stocker) de type T, et la 
 *            référence sur le prochain noeud. 
 * 
 * @author Ismael Doukoure
 * @version 6 mars 2024
 */
public class Noeud<T> {
    private T element;          // référence de l'information contenu dans le noeud
    private Noeud<T> suivant;   // référence vers le noeud suivant
    
    
    /**
     * Crée un objet de type Noeud<T> vide (element et suivant sont null). 
     */ 
     public Noeud () {
        this (null, null); // appel d'un autre constructeur
    } 
     

    /**
     * Crée un objet de type Noeud<T> dont "element" est la référence
     * de la donnée stockée dans le noeud, et "suivant" est null. 
     * 
     * @param element la référence de la donnée stockée dans le noeud 
     */
    public Noeud (T element) {
        this (element, null); // appel d'un autre constructeur
    } 
 
   
    /**
     * Crée un objet de type Noeud<T> dont "element" est la référence
     * de la donnée stockée dans le noeud, et "suivant" est la référence
     * du prochain noeud.
     *  
     * @param element la référence de la donnée stockée dans le noeud
     * @param suivant la référence du prochain noeud
     */
    public Noeud (T element, Noeud<T> suivant) {
        this.element = element;
        this.suivant = suivant;
    }
    
    /**
     * Modifier la référence de la donnée stockée dans le noeud.
     * 
     * @param element la référence de la donnée stockée dans le noeud
     */
    public void setElement (T element) {
        this.element = element;
        
    }
    
    /**
     * Obtenir la référence de la donnée stockée dans le noeud.
     * 
     * @return la référence de la donnée stockée dans le noeud
     */
    public T getElement () {
        return element;    
    } 
    
    /**
     * Modifier la référence du prochain noeud.
     * 
     * @param la référence du prochain noeud 
     */
    public void setSuivant (Noeud<T> unNoeud) {
        suivant = unNoeud;
    } 
    
    /**
     * Obtenir la référence du prochain noeud.
     * 
     * @return la référence du prochain noeud
     */
    public Noeud<T> getSuivant () {
        return suivant;
        
    }   
              
} 