package com.springrest.hibernate;

import java.util.Date;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stuId;
	
	@Column(name="stu_name")
	private String stuName;
	
	@Column(name="is_Eligible")
	private boolean isEligible;
	
	@Column(name="stu_image")
	@Lob
	private byte[] stuImage;
	
	@Column(name="stu_doy")
	@Temporal(TemporalType.DATE)
	private Date stuDob;
	
	
	private int x;
	
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Address(String stuName, boolean isEligible, byte[] stuImage, Date stuDob, int x) {
		super();
		this.stuName = stuName;
		this.isEligible = isEligible;
		this.stuImage = stuImage;
		this.stuDob = stuDob;
		this.x = x;
	}



	public int getStuId() {
		return stuId;
	}



	public void setStuId(int stuId) {
		this.stuId = stuId;
	}



	public String getStuName() {
		return stuName;
	}



	public void setStuName(String stuName) {
		this.stuName = stuName;
	}



	public boolean isEligible() {
		return isEligible;
	}



	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}



	public byte[] getStuImage() {
		return stuImage;
	}



	public void setStuImage(byte[] stuImage) {
		this.stuImage = stuImage;
	}



	public Date getStuDob() {
		return stuDob;
	}



	public void setStuDob(Date stuDob) {
		this.stuDob = stuDob;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	@Override
	public String toString() {
		return "Address [stuId=" + stuId + ", stuName=" + stuName + ", isEligible=" + isEligible + ", stuImage="
				+ stuImage.toString() + ", stuDob=" + stuDob + ", x=" + x + "]";
	}
	
	
}

