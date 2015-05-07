package be.relin.hibernateForeignKey.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "AUTHEUR")
public class Autheur implements java.io.Serializable {
	
	private int autheur_id;
	private String name;
	
	private Set<Livre> livres = new HashSet<Livre>(0);
	
	public Autheur(){}
	
	public Autheur(int id, String name, Set<Livre> livres) {
		super();
		this.autheur_id = id;
		this.name = name;
		this.livres = livres;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AUTHEUR_ID", unique = true, nullable = false)
	public int getAutheur_id() {
		return autheur_id;
	}

	public void setAutheur_id(int autheur_id) {
		this.autheur_id = autheur_id;
	}

	@Column(name = "NAME", nullable = false, length = 25)
	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fk_auth") //mappedBy prend comme valeur le nom de parametre qui represente cette Autheur dans l'object Livre.
	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	

}
