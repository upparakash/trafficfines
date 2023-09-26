package com.trafficfines.trafficfinesdemo.trafficfinesmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fines")
public class TrafficfinesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "vnum")
	private String vnum;
	@Column(name = "oname")
	private String oname;
	@Column(name = "vtype")
	private String vtype;
	@Column(name = "amount")
	private String amount;
	@Column(name = "date")
	private String date;
	@Column(name = "location")
	private String location;
	
	public TrafficfinesModel() {
		
	}
	public TrafficfinesModel(long id, String vnum, String oname, String vtype, String amount, String date,
			String location) {
		super();
		this.id = id;
		this.vnum = vnum;
		this.oname = oname;
		this.vtype = vtype;
		this.amount = amount;
		this.date = date;
		this.location = location;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVnum() {
		return vnum;
	}
	public void setVnum(String vnum) {
		this.vnum = vnum;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
	
	

	