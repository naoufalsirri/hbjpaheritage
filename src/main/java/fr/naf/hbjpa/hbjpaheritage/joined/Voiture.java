package fr.naf.hbjpa.hbjpaheritage.joined;
import javax.persistence.Entity;

@Entity
public class Voiture extends Vehicule {
 
	private int nbrPortes;

	public int getNbrPortes() {
		return nbrPortes;
	}

	public void setNbrPortes(int nbrPortes) {
		this.nbrPortes = nbrPortes;
	}
 
	
}