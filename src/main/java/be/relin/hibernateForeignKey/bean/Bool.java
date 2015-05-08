package be.relin.hibernateForeignKey.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "BOOL")
public class Bool implements java.io.Serializable{

	private int id;
	private boolean truefalse;
	
	public Bool() {}

	public Bool(int id, boolean truefalse) {
		super();
		this.id = id;
		this.truefalse = truefalse;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "truefalse", nullable = false, columnDefinition="boolean default true")
	@Type(type ="org.hibernate.type.BooleanType")
	public boolean isTruefasle() {
		return truefalse;
	}
	public void setTruefasle(boolean truefalse) {
		this.truefalse = truefalse;
	}
	
	
}
