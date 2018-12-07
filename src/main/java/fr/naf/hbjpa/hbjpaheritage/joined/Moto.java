package fr.naf.hbjpa.hbjpaheritage.joined;
import javax.persistence.Entity;

@Entity
public class Moto extends Vehicule {

	private int typeMoteur;

	public int getTypeMoteur() {
		return typeMoteur;
	}

	public void setTypeMoteur(int typeMoteur) {
		this.typeMoteur = typeMoteur;
	}

	

}