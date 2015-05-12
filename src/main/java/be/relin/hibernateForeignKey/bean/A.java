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
@Table(name = "A")
public class A implements java.io.Serializable {
	
	private int id;
	private String nom;
	
	private Set<B> b = new HashSet<B>(0);
	
	public A() {}
	
	public A(int id, String nom, Set<B> b) {
		super();
		this.id = id;
		this.nom = nom;
		this.b = b;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int aaaa_id) {
		this.id = aaaa_id;
	}

	@Column(name = "nom", nullable = false, length = 25)
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ab",
			joinColumns = { @JoinColumn(name = "a_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "b_id", nullable = false, updatable = false) })
	public Set<B> getB() {
		return b;
	}
	public void setB(Set<B> b) {
		this.b = b;
	}
	
}
