package be.relin.hibernateForeignKey.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "DETAIL")
public class Detail implements java.io.Serializable  {
	
	private int detail_id;
	private String info;
	
	private Personne personne;
	
	public Detail() {}
	
	public Detail(int detail_id, String info, Personne personne) {
		super();
		this.detail_id = detail_id;
		this.info = info;
		this.personne = personne;
	}
	
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personne"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DETAIL_ID", unique = true, nullable = false)
	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}

	@Column(name = "INFO", nullable = false, length = 25)
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	
	
	
}
