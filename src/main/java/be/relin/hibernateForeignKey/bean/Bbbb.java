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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BBBB")
public class Bbbb implements java.io.Serializable {
	
	private int bbbb_id;
	private String info;
	
	private Set<Aaaa> aas = new HashSet<Aaaa>(0);
	
	public Bbbb() {}

	public Bbbb(int bbbb_id, String info, Set<Aaaa> aas) {
		super();
		this.bbbb_id = bbbb_id;
		this.info = info;
		this.aas = aas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BBBB_ID", unique = true, nullable = false)
	public int getBbbb_id() {
		return bbbb_id;
	}

	public void setBbbb_id(int bbbb_id) {
		this.bbbb_id = bbbb_id;
	}

	@Column(name = "INFO", nullable = false, length = 25)
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "AABB",
			joinColumns = { @JoinColumn(name = "BB_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "AA_ID", nullable = false, updatable = false) })
	public Set<Aaaa> getAas() {
		return aas;
	}

	public void setAas(Set<Aaaa> aas) {
		this.aas = aas;
	}
	
	

}
