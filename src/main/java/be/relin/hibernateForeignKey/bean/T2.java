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
@Table(name = "T2")
public class T2 implements java.io.Serializable {

	private int t2_id;
	
	private String t2_val;
	
	private Map<T1, T3> T1T3 = new HashMap<>();
	
	public T2() {}

	public T2(int t2_id, String t2_val, Map<T1, T3> t1t3) {
		super();
		this.t2_id = t2_id;
		this.t2_val = t2_val;
		T1T3 = t1t3;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "T2_ID", unique = true, nullable = false)
	public int getT2_id() {
		return t2_id;
	}

	public void setT2_id(int t2_id) {
		this.t2_id = t2_id;
	}

	@Column(name = "NAME", nullable = false, length = 25)
	public String getT2_val() {
		return t2_val;
	}

	public void setT2_val(String t2_val) {
		this.t2_val = t2_val;
	}

	@JoinTable(name = "T1_T2_T3",
	        joinColumns = @JoinColumn(name = "T2_ID"),
	        inverseJoinColumns = @JoinColumn(name = "T1_ID"))
	    @MapKeyJoinColumn(name = "T3_ID")
	    @ElementCollection
	public Map<T1, T3> getT1T3() {
		return T1T3;
	}

	public void setT1T3(Map<T1, T3> t1t3) {
		T1T3 = t1t3;
	}
	
	
}
