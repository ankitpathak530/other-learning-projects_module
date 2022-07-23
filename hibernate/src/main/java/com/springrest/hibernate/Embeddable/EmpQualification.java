package com.springrest.hibernate.Embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class EmpQualification {

	private boolean isIntermediate;
	private boolean isGraduate;
	
	
	public boolean isIntermediate() {
		return isIntermediate;
	}
	public void setIntermediate(boolean isIntermediate) {
		this.isIntermediate = isIntermediate;
	}
	public boolean isGraduate() {
		return isGraduate;
	}
	public void setGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	public EmpQualification(boolean isIntermediate, boolean isGraduate) {
		super();
		this.isIntermediate = isIntermediate;
		this.isGraduate = isGraduate;
	}
	public EmpQualification() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmpQualification [isIntermediate=" + isIntermediate + ", isGraduate=" + isGraduate + "]";
	}
	
}
