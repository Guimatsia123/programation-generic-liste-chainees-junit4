package ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * UQAM - Hiver 2024 
 * INF2120 - Groupe 30 - TP2
 * 
 * EquipeIterateur<T> : est un itérateur pour parcourir toute classe qui 
 * implémente l'interface EquipeTda<T> afin d'appliquer une opération 
 * spécifique sur chaque membre.
 * 
 * @author Ismael Doukoure
 * @version 6 mars 2024
 */
class EquipeIterateur<T> implements Iterator<T> {

   private Noeud<T> curseur;

   public EquipeIterateur(Noeud<T> curseur) {
      this.curseur = curseur;
   }

   @Override
   public boolean hasNext() {
      return curseur != null;
   }

   @Override
   public T next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      }

      T courant = curseur.getElement();
      curseur = curseur.getSuivant();
      return courant;
   }

}