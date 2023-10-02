package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide "+nom+" et ma potion peut aller d'une force "+effetPotionMin+" à "+effetPotionMax+".");
		
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte +"»");
		
	}
	
	public int preparerPotion() {
		Random random = new Random();
		int force = random.nextInt(11-effetPotionMax);
		force += effetPotionMin;
		if (force > 7) {
			parler("J'ai préparé une super potion de force " + force);
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force "+ force);
		}
		return force;
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void booster(Gaulois g) {
		if (g.getNom()=="Obélix") {
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		} else {

		}
		g.boirePotion(forcePotion);
		
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
		panoramix.preparerPotion();
		panoramix.preparerPotion();
	}
}
