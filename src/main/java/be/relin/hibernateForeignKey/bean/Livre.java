package be.relin.hibernateForeignKey.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre implements java.io.Serializable {

	private int livre_id;
	private String nom;
	private Autheur fk_auth;
	
	
	public Livre() {}


	public Livre(int id, String nom, Autheur fk_auth) {
		super();
		this.livre_id = id;
		this.nom = nom;
		this.fk_auth = fk_auth;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "LIVRE_ID", unique = true, nullable = false)
	public int getLivre_id() {
		return livre_id;
	}


	public void setLivre_id(int livre_id) {
		this.livre_id = livre_id;
	}


	@Column(name = "NOM", nullable = false, length = 25)
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_AUTH", nullable = false)
	public Autheur getFk_auth() {
		return fk_auth;
	}


	public void setFk_auth(Autheur fk_auth) {
		this.fk_auth = fk_auth;
	}
	
	
	
}
