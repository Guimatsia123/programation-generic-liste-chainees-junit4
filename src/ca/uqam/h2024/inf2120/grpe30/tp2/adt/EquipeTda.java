package ca.uqam.h2024.inf2120.grpe30.tp2.adt;

import java.util.List;
import java.util.Map;

/**
 * UQAM - Hiver 2024 
 * INF2120 - Groupe 30 - TP2
 * 
 * EquipeTda<T> : est une interface qui définie les opérations de base pour la
 * gestion des membres d'une équipe donnée. Le type T est la représentation
 * générique de nos futurs membres.
 * 
 * @author Ismael Doukoure
 * @version 6 mars 2024
 */
public interface EquipeTda<T> extends Iterable<T> {

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
   public boolean ajouter(T membre);

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
   public boolean ajouter(int position, T membre) throws PositionException;

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
   public List<T> ajouter(EquipeTda<T> equipe);

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
   public List<T> comparer(EquipeTda<T> equipe);

   /**
    * Vérifie si l'équipe courante contient le membre passé en paramètre.
    * 
    * Si l'équipe courante contient le membre passé en paramètre, la methode
    * retourne vrai, sinon elle retourne faux.
    * 
    * @param membre le membre dont l'existence doit être vérifiée
    * @return vrai si le membre existe, sinon faux
    */
   public boolean estMembre(T membre);

   /**
    * Retourne le nombre de membres de l'équipe courante.
    * 
    * Le nombre total des membres dans l'équipe courante doit être retourné.
    * 
    * @return Le nombre total des membres de l'équipe courante
    */
   public int obtenirNbMembres();

   /**
    * Retire le membre passé en paramètre de l'équipe courante.
    * 
    * Le membre passé en paramètre doit être retiré s'il existe dans l'équipe
    * courante.
    * 
    * @param membre le membre à retirer
    * @return vrai si le membre est retiré, sinon faux
    */

   public boolean retirer(T membre);

   /**
    * Retire tous les membres de l'équipe passée en paramètre de l'équipe courante.
    * 
    * Tous les membres de l'équipe passée en paramètre doivent être retirés de
    * l'équipe courante s'ils existent.
    * 
    * @param equipe l'équipe dont les membres doivent être retirés
    * @return Le tableau (ArrayList<T>) des membres de l'équipe passée en paramètre
    *         qui n'ont pas été retirés, null si tous les membres ont été retirés
    *         ou si l'équipe passée en paramètre est nulle ou vide
    */
   public List<T> retirer(EquipeTda<T> equipe);

   /**
    * Remplace un membre par un autre dans l'équipe courante. Le membre à remplacer
    * doit exister et le nouveau membre ne doit pas être null. Aucun remplacement
    * si l'équipe courante contient déjà le nouveau membre.
    * 
    * @param membreARemplacer Le membre de l'équipe courante à remplacer
    * @param nouveauMembre    Le nouveau membre à ajouter
    * @return vrai si le remplacement a été fait, sinon faux
    */
   public boolean remplacer(T membreARemplacer, T nouveauMembre);

   /**
    * Retourne tous les membres de l'équipe courante et leurs positions dans un
    * HashMap<K,T> (HashMap Clé = position de type Integer, HashMap valeur = membre
    * de type T).
    *
    * @return Le HashMap de tous les membres de l'équipe courante et leurs
    *         positions, null, si l'équipe courante est vide.
    */
   public Map<Integer, T> obtenirLesMembres();

   /**
    * Vérifie si l'équipe courante est vide.
    * 
    * @return vrai si l'équipe courante est vide, sinon faux.
    */
   public boolean estVide();

   /**
    * Vide l'équipe courante en retirant toutes les membres.
    */
   public void vider();

}