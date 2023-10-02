package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbtrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte +"»");
		
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force/3)*this.effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesretournes = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesretournes != null && i < tropheesretournes.length; i++, nbtrophees++) {
			this.trophees[nbtrophees] = tropheesretournes[i];
		}
	}

	public void boirePotion(int force) {
		this.effetPotion = force;
		parler("Merci Druide, je sens que ma force est "+force+" fois décuplée.");
	}
	
//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",7);
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour");
		Romain random = new Romain("Random", 5);
		asterix.frapper(random);
		asterix.frapper(random);
		asterix.frapper(random);
	}
}