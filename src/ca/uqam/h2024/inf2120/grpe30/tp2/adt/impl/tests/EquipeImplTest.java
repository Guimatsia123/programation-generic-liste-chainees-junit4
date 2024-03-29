package ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl.tests;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uqam.h2024.inf2120.grpe30.tp2.adt.PositionException;
import ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl.EquipeImpl;
//import ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl.EquipeIterateur;
/**
 * UQAM - Hiver 2024 
 * INF2120 - Groupe 30 - TP2
 * @enseignant: Ismael Doukoure
 * EquipeImplTest : est une classe de test qui permet de faire des tests unitaires
 * sur les methodes de la classe EquipeImpl<T>
 *  
 * @author MARIUS GUIMATSIA AKALONG (GUIM27309006)
 * @version 6 mars 2024
 */
public class EquipeImplTest {

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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		membre = new Membre("BETA2579","Alpha","Beta");
		membre1 = new Membre("BARN1234","Barry","Noah");
		membre2 = new Membre("JACO4789","Jacques","Omer");
		membre3 = new Membre("KEIN4931","Keita","Nala");
		membre4 = new Membre("COSF2546","Costin","Fred");
		membre5 = new Membre("KANA5906", "Kante", "Albert");
		membreNull =  null;
	
		
		listePositions.put(0,membre1);
		listePositions.put(1, membre2);
		listePositions.put(2, membre3);
		
		equipeCourante.ajouter(membre1);
		equipeCourante.ajouter(membre2);
		equipeCourante.ajouter(membre3);
		
		equipeTda.ajouter(membre2);
		equipeTda.ajouter(membre3);
		equipeTda.ajouter(membre4);
		equipeTda.ajouter(membre5);
		

	}

	@After
	public void tearDown() throws Exception {	
		membre = null;
		membreNull = null;
		membre1 = null;
		membre2 = null;
		membre3 = null;
		membre4 = null;
		membre5 = null;
	
		listePositions = null;
		equipeCourante = null;
		equipeTda = null;
				
	}

	@Test
	public void test1Iterator() {
		
		
		assertNotEquals(equipeTda.iterator(),equipeCourante.iterator());
	}
	/**
	 *Test d'ajout d'un membre dans une equipe vide. 
	 *Mehode tester ajouter(T membre)
	 *
	 */
	@Test
	public void test1AjouterMembre() {
		
		EquipeImpl<Membre> equipe = new EquipeImpl<Membre>();

		assertTrue(equipe.ajouter(membre));
		
	}
	
	/**
	 *Test d'ajout d'un membre dans une equipe non vide. 
	 *Mehode tester ajouter(T membre)
	 *
	 */
	@Test
	public void test2AjouterMembre() {
		
		assertTrue(equipeCourante.ajouter(membre));
		
	}
	/**
	 *Test d'ajout d'un membre existant deja dans l'equipe courante
	 *On s'attend a ce que la methode retourne false.
	 *Mehode tester: ajouter(T membre)
	 *
	 */
	@Test
	public void test3AjouterMembre() {
		
		assertFalse(equipeCourante.ajouter(membre1));
		
	}
	/**
	 *Test d'ajout d'un membre null dans une liste
	 *On s'attend a ce que la methode retourne false.
	 *Mehode tester: ajouter(T membre)
	 *
	 */
	@Test
	public void test4AjouterMembre() {
		
		assertFalse(equipeCourante.ajouter(membreNull));
		
	}
	/**
	 *Test d'ajout d'un membre a une position donner. 
	 *Mehode tester ajouter(int position, T membre)
	 *
	 */
	@Test
	public void test1AjouterIntT() throws PositionException {
		
		assertTrue(equipeCourante.ajouter(1, membre));
		
		
	}
	/**
	 *Test d'ajout d'un membre a une position qui n'est pas dans l'intervalle. 
	 *Mehode tester ajouter(int position, T membre)
	 *
	 *On va juste s'assurer le l'exception PositionException est produite
	 *lorsqu'on essaie d'ajouter un membre a une position qui n'est pas dans 
	 *le bon intervalle.
	 */
	@Test(expected = PositionException.class)
	public void test2AjouterIntT() throws PositionException {
		
		equipeCourante.ajouter(4, membre);
		
	}
	
	/**
	 *Test d'ajout d'un membre null a une position donner. 
	 *On s'attend a ce que la methode retourne false
	 *Mehode tester ajouter(int position, T membre)
	 *
	 */
	@Test
	public void test3AjouterIntT() throws PositionException {
		
		assertFalse(equipeCourante.ajouter(1, membreNull));
		
		
	}
	
	/**
	 *Test d'ajout d'une equipe Tda a l'equipe courante
	 *Mehode tester ajouter(EquipeTda equipe)
	 *
	 */
	@Test
	public void test1AjouterEquipeTdaOfT() {

		
		List<Membre> listeMembresNonAjoutes = new ArrayList<Membre>(Arrays.asList(membre2,membre3));
		
		assertEquals(listeMembresNonAjoutes.toString(), equipeCourante.ajouter(equipeTda).toString());
		
	}
	/**
	 *Test d'ajout d'une equipe Tda vide a equipeCourante.
	 *la liste retourner devra etre nul.
	 * 
	 *Mehode tester: ajouter(EquipeTda equipe)
	 *
	 */
	@Test
	public void test2AjouterEquipeTdaOfT() {

		 EquipeImpl<Membre> equipe = new EquipeImpl<Membre>();
		 
		List<Membre> listeMembresNonAjoutes = null;
		
		assertEquals(listeMembresNonAjoutes, equipeCourante.ajouter(equipe));
		
	}

	/**
	 *Test d'ajout d'une equipe Tda a l'equipe courante
	 *Ici on va passer en parametre des membres qui ne font pas
	 *partir de l'equipe courante. Ainsi la liste retourner devra 
	 *etre nul.
	 *Mehode tester ajouter(EquipeTda equipe)
	 *
	 */
	@Test
	public void test3AjouterEquipeTdaOfT() {

		 EquipeImpl<Membre> equipe = new EquipeImpl<Membre>();
		 equipe.ajouter(membre4);
		 equipe.ajouter(membre5);

		List<Membre> listeMembresNonAjoutes = null;
		
		assertEquals(listeMembresNonAjoutes, equipeCourante.ajouter(equipe));
		
	}

	/**
	 *Test de comparaison de deux equipes differentes
	 *On compare deux equipes et on renvoie la liste
	 *des elements  de l'equipe passer en parametre qui ne font 
	 *pas partir de l'equipe courante dans un ArrayList.
	 *Mehode tester comparer(EquipeTda equipe)
	 *
	 */
	@Test
	public void test1Comparer() {
		
		List<Membre> listeMembresNonInclus = new ArrayList<Membre>(Arrays.asList(membre4,membre5));
		
		assertEquals(listeMembresNonInclus.toString(), equipeCourante.comparer(equipeTda).toString());
	}
	
	/**
	 *Test de comparaison de deux equipes identique
	 *On compare deux equipes identique et on renvoie un ArrayList null.
	 *Mehode tester comparer(EquipeTda equipe)
	 *
	 */
	@Test
	public void test2Comparer() {
		
		List<Membre> listeMembresNonInclus = null;
		
		assertEquals(listeMembresNonInclus,equipeCourante.comparer(equipeCourante));
	}

	/**
	 *Test pour verifier si un membre appartient a l'equipe courante.
	 *Dans ce test on passe en parametre un membre qui appartient a l'equipe
	 *et on s'attend a ce que la methode retourne true.
	 *Mehode tester comparer(EquipeTda equipe)
	 *
	 */
	@Test
	public void test1EstMembre() {

		assertTrue(equipeCourante.estMembre(membre1));
	}
	
	/**
	 *Test pour verifier si un membre appartient a l'equipe courante.
	 *Dans ce test on passe en parametre un membre qui n'appartient a l'equipe courante
	 *et on s'attend a ce que la methode retourne false.
	 *Mehode tester comparer(EquipeTda equipe)
	 *
	 */
	@Test
	public void test2EstMembre() {

		assertFalse(equipeCourante.estMembre(membre4));
	}
	
	/**
	 *Test pour verifier si un membre null appartient a l'equipe courante.
	 *Dans ce test on passe en parametre un membre null
	 *et on s'attend a ce que la methode retourne false.
	 *Mehode tester comparer(EquipeTda equipe)
	 *
	 */
	@Test
	public void test3EstMembre() {

		assertFalse(equipeCourante.estMembre(membreNull));
	}

	/**
	 *Test pour savoir le nombre total des membres d'une equipe.
	 *On passe en parametre une equipe avec des membres et on retourne le 
	 *nombre total de membre de cette equipe
	 *Mehode tester obtenirNbMembres()
	 *
	 */
	@Test
	public void test1ObtenirNbMembres() {

		assertEquals(3,equipeCourante.obtenirNbMembres());

	}
	/**
	 *Test pour savoir le nombre total des membres d'une equipe.
	 *On passe en parametre une equipe vide on s'attend a ce que le 
	 *nombre total de membre retourner soit 0.
	 *Mehode tester obtenirNbMembres()
	 *
	 */
	@Test
	public void test2ObtenirNbMembres() {
		 EquipeImpl<Membre> equipe = new EquipeImpl<Membre>();

		assertEquals(0,equipe.obtenirNbMembres());

	}

	/**
	 *Test pour retirer un membre dans une equipe
	 *On passe parametre un membre de l'equipe courante 
	 *On s'attend a ce que la methode retourne true pour dire
	 *que le membre a bel et bien ete retirer.
	 *Mehode tester retirer(T membre)
	 *
	 */
	@Test
	public void test1RetirerT() {

		
		assertTrue(equipeCourante.retirer(membre2));
	}

	/**
	 *Test pour retirer un membre dans une equipe
	 *On passe parametre un membre qui n'appartient pas a  l'equipe courante 
	 *On s'attend a ce que la methode retourne false.
	 *Mehode tester retirer(T membre)
	 *
	 */
	@Test
	public void test2RetirerT() {

		
		assertFalse(equipeCourante.retirer(membre));
	}

	/**
	 *Test pour retirer tous les membres d'une equipe passe en parametre.
	 *On passe parametre une equipe Tda et on s'attend a ce que la methode nous 
	 *retourne un ArrayList des membres non ajoutes.
	 *Mehode tester retirer(EquipeTda equipe)
	 *
	 */
	@Test
	public void testRetirerEquipeTdaOfT() {
		
		List<Membre> listeMembresNonRetires = new ArrayList<Membre>(Arrays.asList(membre4,membre5));
		
		assertEquals(listeMembresNonRetires.toString(), equipeCourante.retirer(equipeTda).toString());
		
	}
	
	/**
	 *Test pour retirer tous les membres d'une equipe passe en parametre.
	 *On passe parametre une vide et on s'attend a ce que la methode nous 
	 *retoune un ArrayList null
	 *Mehode tester retirer(EquipeTda equipe)
	 *
	 */
	@Test
	public void test2RetirerEquipeTdaOfT() {
		 EquipeImpl<Membre> equipe = new EquipeImpl<Membre>();
		List<Membre> listeMembresNonRetires = null;
		
		
		assertEquals(listeMembresNonRetires, equipeCourante.retirer(equipe));
		
	}

	/**
	 *Test pour retirer tous les membres d'une equipe passe en parametre.
	 *On passe parametre une equipe identique a celle de la liste courante et on s
	 *s'attend a ce que la methode nous retoune un ArrayList null
	 *Mehode tester retirer(EquipeTda equipe)
	 *
	 */
	@Test
	public void test3RetirerEquipeTdaOfT() {
		List<Membre> listeMembresNonRetires = null;	
		
		assertEquals(listeMembresNonRetires, equipeCourante.retirer(equipeCourante));
		
	}

	/**
	 *Test pour remplacer un membre par un autre.
	 *On remplace un membre dans l'equipe courante par un autre membre
	 *On s'attend a retourner true si le membre a bel et bien ete remplacer.
	 *Mehode tester: remplacer(T ancienMembre, T nouveauMembre)
	 *
	 */
	@Test
	public void test1Remplacer() {
				
		assertTrue(equipeCourante.remplacer(membre2, membre));
		
		
	}
	/**
	 *Test pour remplacer un membre par un autre.
	 *On remplace un membre par une autre membre existant deja dans la liste 
	 *On s'attend a ce que la methode retourne false. car le membre existe deja.
	 *Mehode tester: remplacer(T ancienMembre, T nouveauMembre)
	 */
	@Test
	public void test2Remplacer() {
				
		assertFalse(equipeCourante.remplacer(membre2, membre1));
		
		
	}

	/**
	 *Test pour obtenir tous les membres d'une equipe et leur position.
	 *La methode doit retourner liste de membre avec leur position dans
	 *une structure de donnees HashMap<postion,Membre>.
	 *Mehode tester: obtenirLesMembres()
	 *
	 */
	@Test
	public void test1ObtenirLesMembres() {

		assertEquals(listePositions,equipeCourante.obtenirLesMembres());
	}

	/**
	 *Test pour obtenir tous les membres d'une equipe et leur position.
	 *Dans ce test on essaie d'avoir les postions des membres d'une equipe 
	 *On s'attend a ce que la methode retourne un HasMap null.
	 *Mehode tester: obtenirLesMembres()
	 *
	 */
	@Test
	public void test2ObtenirLesMembres() {
	   EquipeImpl<Membre> equipe = new EquipeImpl<Membre>();
	   Map<Integer,Membre> listePositionsVide = null;


		assertEquals(listePositionsVide,equipe.obtenirLesMembres());
	}

	/**
	 *Test pour verifier si une equipe est vide ou pas
	 *On passe une equipe vide et on s'attend a ce que la methode retourne true.
	 *Mehode tester: estVide()
	 *
	 */
	@Test
	public void test1EstVide() {

		EquipeImpl<Membre> equipe = new EquipeImpl<Membre>();
		assertTrue(equipe.estVide());
	}
	/**
	 *Test pour verifier si une equipe est vide ou pas
	 *On passe une equipe qui n'est pas vide et on s'attend a ce que la methode retourne False.
	 *Mehode tester: estVide()
	 *
	 */
	@Test
	public void test2EstVide() {
		

		assertFalse(equipeCourante.estVide());
	}
	/**
	 *Test pour vider une equipe.
	 *On vide l'equipe  en l'affectant la valeur null.
	 *Mehode tester: Vider()
	 *
	 */

	@Test
	public void testVider() {
		equipeCourante.vider();
		assertTrue(equipeCourante.estVide());
	}

	

}
