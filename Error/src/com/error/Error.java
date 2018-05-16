package com.error;

/**
 * A Error Class Representing a real world entity of a errors;
 * 
 * */
public class Error {

	private Integer eid;
	private String category;
	private String descri;
	private java.sql.Time tme;
	private java.sql.Date dte;
	
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDescription(String descri) {
		this.descri = descri;
	}
	public void setTime(java.sql.Time Tme ) {
		this.tme = Tme;
	}
	public void setDate(java.sql.Date Dte) {
		this.dte = Dte;
	}
	
	public Integer getEid() {
		return this.eid;
	}
	public String getCategory() {
		return this.category;
	}
	public String getDescri() {
		return this.descri;
	}
	public String getDate() {
		return this.dte.toString();
	}
	public String getTime() {
		return this.tme.toString();
	}
	
}

