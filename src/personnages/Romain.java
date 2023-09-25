package personnages;

public class Romain {
	private static final int NB_EQUIPEMENTS = 2;
	
	private String nom;
	private int force;
	private Equipement equipements[];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force >= 0;
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[NB_EQUIPEMENTS];
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte +"»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert this.force >= 0;
		int force_debut = this.force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert force_debut > this.force;
	}
	
	public void equiper(Equipement equipement) {
		this.equipements[this.nbEquipement] = equipement;
		this.nbEquipement++;
		System.out.println("Le soldat "+this.nom+" s'équipe avec un "+equipement.toString()+".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2:
			System.out.println("Le soldat "+this.nom+" est déjà bien protégé !");
			break;
		case 1:
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat "+this.nom+" possède déja un "+equipement.toString()+" !");
			} else {
				equiper(equipement);
			}
			break;
		default:
			equiper(equipement);
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		minus.parler("Bonjour");
		minus.recevoirCoup(3);
		minus.recevoirCoup(3);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
