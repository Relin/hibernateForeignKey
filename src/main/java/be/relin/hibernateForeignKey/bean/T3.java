package be.relin.hibernateForeignKey.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T3")
public class T3 implements java.io.Serializable {

	private int t3_id;
	
	private String t3_val;
	
	private Map<T1, T2> T1T2 = new HashMap<>();
	
	public T3() {}

	public T3(int t3_id, String t3_val, Map<T1, T2> t1t2) {
		super();
		this.t3_id = t3_id;
		this.t3_val = t3_val;
		T1T2 = t1t2;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "T3_ID", unique = true, nullable = false)
	public int getT3_id() {
		return t3_id;
	}

	public void setT3_id(int t3_id) {
		this.t3_id = t3_id;
	}

	@Column(name = "NAME", nullable = false, length = 25)
	public String getT3_val() {
		return t3_val;
	}

	public void setT3_val(String t3_val) {
		this.t3_val = t3_val;
	}

	@JoinTable(name = "T1_T2_T3",
	        joinColumns = @JoinColumn(name = "T3_ID"),
	        inverseJoinColumns = @JoinColumn(name = "T1_ID"))
	    @MapKeyJoinColumn(name = "T2_ID")
	    @ElementCollection
	public Map<T1, T2> getT1T2() {
		return T1T2;
	}

	public void setT1T2(Map<T1, T2> t1t2) {
		T1T2 = t1t2;
	}
	
	
}
