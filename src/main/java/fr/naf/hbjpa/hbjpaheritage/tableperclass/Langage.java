package fr.naf.hbjpa.hbjpaheritage.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Langage {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	
	@Column(nullable=false)
	private String nom;

	public abstract String coder();
	
	public Langage(String nom) {
		super();
		this.nom = nom;
	}

	public Langage() {
		super();		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
