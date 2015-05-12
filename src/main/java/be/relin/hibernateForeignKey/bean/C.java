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
@Table(name = "C")
public class C implements java.io.Serializable {

	private int id;
	private String info;
	
	private A a;
	
	public C() {}

	public C(int id, String info, A a) {
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "a", nullable = false)
	public A getA() {
		return a;
	}
	public void setA(A a) {
		this.a = a;
	}
	
	
}
