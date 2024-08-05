package com.emr.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class IcdCategoryModel {

	@Id
	private int id;

   
    private String versionState;

   
    private  Integer refId;

   
    private  Integer originalRefId;

    
    private  String modifiedBy;
    
   
    private  String createdBy;
    
    
    private  Date modifiedDate;
    
  
    private  Date createdDate;
    
	
	private String icdOrder;
	
	
	private String icdCode;
	
	
	private int icdId;
	
	
	private String type;
	
	
	private String shortDesc;
	
	
	private String medDesc;
	
	
	private String longDesc;


	private String retired;
	

	private String retiredOn;
	
	
	private String retiredReason;
	
	private Integer parentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersionState() {
		return versionState;
	}

	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	public Integer getOriginalRefId() {
		return originalRefId;
	}

	public void setOriginalRefId(Integer originalRefId) {
		this.originalRefId = originalRefId;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getIcdOrder() {
		return icdOrder;
	}

	public void setIcdOrder(String icdOrder) {
		this.icdOrder = icdOrder;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public int getIcdId() {
		return icdId;
	}

	public void setIcdId(int icdId) {
		this.icdId = icdId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getMedDesc() {
		return medDesc;
	}

	public void setMedDesc(String medDesc) {
		this.medDesc = medDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getRetired() {
		return retired;
	}

	public void setRetired(String retired) {
		this.retired = retired;
	}

	public String getRetiredOn() {
		return retiredOn;
	}

	public void setRetiredOn(String retiredOn) {
		this.retiredOn = retiredOn;
	}

	public String getRetiredReason() {
		return retiredReason;
	}

	public void setRetiredReason(String retiredReason) {
		this.retiredReason = retiredReason;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
}
