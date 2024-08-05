package com.emr.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class CptCategoryModel {
	

@javax.persistence.Id
private int id;

private String code;


private String shortName;


private String description;


private int isHcpcs;


private Integer refId;


private Integer orgRefId;


private String versionState;

 
  private String modifiedBy;
  
 
  private String createdBy;

  
 
  private Date modifiedDate;
  
  
  private Date createdDate;

  private String cptMajorCategory;
  
  private String cptMinorCategory;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getShortName() {
	return shortName;
}

public void setShortName(String shortName) {
	this.shortName = shortName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getIsHcpcs() {
	return isHcpcs;
}

public void setIsHcpcs(int isHcpcs) {
	this.isHcpcs = isHcpcs;
}

public Integer getRefId() {
	return refId;
}

public void setRefId(Integer refId) {
	this.refId = refId;
}

public Integer getOrgRefId() {
	return orgRefId;
}

public void setOrgRefId(Integer orgRefId) {
	this.orgRefId = orgRefId;
}

public String getVersionState() {
	return versionState;
}

public void setVersionState(String versionState) {
	this.versionState = versionState;
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

public String getCptMajorCategory() {
	return cptMajorCategory;
}

public void setCptMajorCategory(String cptMajorCategory) {
	this.cptMajorCategory = cptMajorCategory;
}

public String getCptMinorCategory() {
	return cptMinorCategory;
}

public void setCptMinorCategory(String cptMinorCategory) {
	this.cptMinorCategory = cptMinorCategory;
}
  



	
}
