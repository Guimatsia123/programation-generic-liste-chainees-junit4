package ca.uqam.h2024.inf2120.grpe30.tp2.adt;

/**
 * UQAM - Hiver 2024
 * INF2120 - Groupe 30 - TP2  
 * 
 * PositionException est une classe pour gérer les exceptions liées à 
 * une position dans un intervalle
 * 
 * @author Ismael Doukoure
 * @version 6 mars 2024
 */
@SuppressWarnings("serial")
public class PositionException extends Exception {
   
   /**
    * Constructeur sans argument
    */   
   public PositionException() {
        super();
    }
   
   /**
    * Ce constructeur permet d'initialiser le message.
    * 
    * @param message le message à afficher
    */
   public PositionException(String message) {
        super(message);
    }

}