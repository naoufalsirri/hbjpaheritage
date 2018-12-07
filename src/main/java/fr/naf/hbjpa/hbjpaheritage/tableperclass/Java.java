package fr.naf.hbjpa.hbjpaheritage.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Java extends Langage {

	@Override
	public String coder() {		
		return "je ss java";
	}

	
}
