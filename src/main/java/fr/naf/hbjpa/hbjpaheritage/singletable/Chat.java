package fr.naf.hbjpa.hbjpaheritage.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHAT")
public class Chat extends Animal {

	@Override
	public String faireBruit() {		
		return "MIAW MIAW";
	}

	
}
