package be.relin.hibernateForeignKey.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T1")
public class T1 implements java.io.Serializable {

	private int t1_id;
	
	private String t1_val;
	
	private Map<T2, T3> T2T3 = new HashMap<>();
	// maybe need a segond Map
	//private Map<T3, T2> T3T2 = new HashMap<>();
	//need inspection on it.
	
	public T1() {}
	
	public T1(int t1_id, String t1_val, Map<T2, T3> t2t3) {
		super();
		this.t1_id = t1_id;
		this.t1_val = t1_val;
		T2T3 = t2t3;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "T1_ID", unique = true, nullable = false)
	public int getT1_id() {
		return t1_id;
	}

	public void setT1_id(int t1_id) {
		this.t1_id = t1_id;
	}

	@Column(name = "NAME", nullable = false, length = 25)
	public String getT1_val() {
		return t1_val;
	}

	public void setT1_val(String t1_val) {
		this.t1_val = t1_val;
	}

	@JoinTable(name = "T1_T2_T3",
	        joinColumns = @JoinColumn(name = "T1_ID"),
	        inverseJoinColumns = @JoinColumn(name = "T2_ID"))
	    @MapKeyJoinColumn(name = "T3_ID")
	    @ElementCollection
	public Map<T2, T3> getT2T3() {
		return T2T3;
	}

	public void setT2T3(Map<T2, T3> t2t3) {
		T2T3 = t2t3;
	}
	
}
