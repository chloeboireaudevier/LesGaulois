package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois villageois[];
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois g) {
		if (this.nbVillageois < this.villageois.length ) {
			this.villageois[this.nbVillageois] = g;
			this.nbVillageois++;
		}
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return this.villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+this.chef.getNom()+" vivent les légendaires gaulois :");
		for (int i = 0; i < this.nbVillageois; i++) {
			System.out.println("- "+this.villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		// Index out of range : l'indice n'est pas un indice valide du tableau
		Chef Abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(Abraracourcix);
		Gaulois Asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(Asterix);
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//Il n'y a pas de villageois en position 1, on obtient donc le résultat NULL.
		Gaulois Obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(Obelix);
		village.afficherVillageois();
	}
}
