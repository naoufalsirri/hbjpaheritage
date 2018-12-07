package fr.naf.hbjpa.hbjpaheritage.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Csharp extends Langage {

	@Override
	public String coder() {
		// TODO Auto-generated method stub
		return "je suis c#";
	}


	
}
