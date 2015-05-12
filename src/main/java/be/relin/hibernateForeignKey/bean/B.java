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
@Table(name = "B")
public class B implements java.io.Serializable {
	
	private int id;
	private String info;
	
	private Set<A> a = new HashSet<A>(0);
	
	public B() {}
	
	public B(int id, String info, Set<A> a) {
		super();
		this.id = id;
		this.info = info;
		this.a = a;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "INFO", nullable = false, length = 25)
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "id",
			joinColumns = { @JoinColumn(name = "b_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "a_id", nullable = false, updatable = false) })
	public Set<A> getA() {
		return a;
	}
	public void setA(Set<A> a) {
		this.a = a;
	}

}
