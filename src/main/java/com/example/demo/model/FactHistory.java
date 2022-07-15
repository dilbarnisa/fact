package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fact_history")
public class FactHistory {
	@Id
    @GeneratedValue
    @Column(name="id")
    private int id;


    @Column(name="caller_id")
    private String caller_id;
    
    @Column(name="fact")
    private String fact;


	@Override
	public String toString() {
		return "caller_id=" + caller_id + ", fact=" + fact + ", time=" + time + "\n";
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaller_id() {
		return caller_id;
	}

	public void setCaller_id(String caller_id) {
		this.caller_id = caller_id;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public FactHistory( String caller_id, String fact, String time) {
		super();
		this.caller_id = caller_id;
		this.fact = fact;
		this.time = time;
	}

	public FactHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="time")
    private String time;


}
