package fr.naf.hbjpa.hbjpaheritage.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHIEN")
public class Chien extends Animal {

	@Override
	public String faireBruit() {		
		return "WOOF WOOF";
	}

	
}
