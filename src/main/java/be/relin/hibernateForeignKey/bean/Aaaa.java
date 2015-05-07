package be.relin.hibernateForeignKey.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AAAA")
public class Aaaa implements java.io.Serializable {
	
	private int aaaa_id;
	private String nom;
	
	private Set<Bbbb> bbs = new HashSet<Bbbb>(0);
	
	public Aaaa() {}

	public Aaaa(int aaaa_id, String nom, Set<Bbbb> bbs) {
		super();
		this.aaaa_id = aaaa_id;
		this.nom = nom;
		this.bbs = bbs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AAAA_ID", unique = true, nullable = false)
	public int getAaaa_id() {
		return aaaa_id;
	}

	public void setAaaa_id(int aaaa_id) {
		this.aaaa_id = aaaa_id;
	}

	@Column(name = "NOM", nullable = false, length = 25)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "AABB",
			joinColumns = { @JoinColumn(name = "AA_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "BB_ID", nullable = false, updatable = false) })
	public Set<Bbbb> getBbs() {
		return bbs;
	}

	public void setBbs(Set<Bbbb> bbs) {
		this.bbs = bbs;
	}
	
	

}
