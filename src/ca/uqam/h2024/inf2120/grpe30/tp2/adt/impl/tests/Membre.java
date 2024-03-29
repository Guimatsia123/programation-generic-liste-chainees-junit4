package ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * UQAM - Hiver 2024
 * INF2120 - Groupe 30 - TP2 
 * 
 * Membre : Cette classe correspond à l'élément T et 
 * elle sera utilisée dans les tests unitaires (JUnit tests)
 *    
 * @author Ismael Doukoure
 * @version 6 mars 2024
 */
public class Membre {
   
   // Déclaration des attributs
   private String identifiant;
   private String nom;
   private String prenom;


   /**
    * @param identifiant L'identifiant 
    * @param nom Le nom
    * @param prenom Le prénom
    */
   public Membre(String identifiant, String nom, String prenom) {
      this.identifiant = identifiant;
      this.nom = nom;
      this.prenom = prenom;
   }

   /**
    * @return l'identifiant
    */
   public String getIdentifiant() {
      return identifiant;
   }


   /**
    * @param identifiant l'identifiant à initialiser
    */
   public void setIdentifiant(String identifiant) {
      this.identifiant = identifiant;
   }

   /**
    * @return le nom
    */
   public String getNom() {
      return nom;
   }


   /**
    * @param nom le nom  à initialiser
    */
   public void setNom(String nom) {
      this.nom = nom;
   }

   /**
    * @return le prénom
    */
   public String getPrenom() {
      return prenom;
   }


   /**
    * @param prenom le prénom à initialiser 
    */
   public void setPrenom(String prenom) {
      this.prenom = prenom;
   }

   @Override
   public boolean equals(Object unAutreObjet) {
      
      boolean estEgal = false;
      
      // Si les 2 objets sont identiques, on doit retourner
      // vrai comme résultat.
       if (this == unAutreObjet) {
         estEgal = true;
         
      } else if (unAutreObjet != null && 
               this.getClass() == unAutreObjet.getClass()) {
      
         // Sachant que "unAutreObjet" n'est pas null et que "unAutreObjet"
         // et l'objet courant sont de même type, on peut se permettre
         // la conversion de "UnAutreObjet" en Membre
         Membre unMembre = (Membre)unAutreObjet;
         
         // Tester si les deux (2) objets ont le même identifiant.
         estEgal = (identifiant.equals(unMembre.identifiant));
      }
       
       return estEgal;
       
   }
   //TODO must be deleted after test.
   @Override
   public String toString() {
	   
	   return "("+this.identifiant+","+this.nom+","+this.prenom+")";
   }
   
}