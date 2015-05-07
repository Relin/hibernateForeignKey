package be.relin.hibernateForeignKey.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "PERSONNE")
public class Personne implements java.io.Serializable  {
	
	private int personne_id;
	private String nom;
	
	private Detail detail;
	
	public Personne() {}

	public Personne(int personne_id, String nom, Detail detail) {
		super();
		this.personne_id = personne_id;
		this.nom = nom;
		this.detail = detail;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PERSONNE_ID", unique = true, nullable = false)
	public int getPersonne_id() {
		return personne_id;
	}

	public void setPersonne_id(int personne_id) {
		this.personne_id = personne_id;
	}

	@Column(name = "NOM", nullable = false, length = 25)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "personne", cascade = CascadeType.ALL) //mappedBy prend comme valeur le nom de parametre qui represente cette personne dans l'object Detail. 
	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}
	
	
	
	

}
