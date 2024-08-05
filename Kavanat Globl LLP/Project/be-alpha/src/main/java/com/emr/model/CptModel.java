package com.emr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cpt_short")
public class CptModel {
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name ="id")
private int id;

@Column(name ="code")
private String code;

@Column(name ="retired")
private String retired;

@Column(name ="short_name")
private String shortName;

@Column(name ="description")
private String description;

@Column(name ="is_hcpcs")
private int isHCPCS;

@Column(name ="ref_id")
private Integer refId;

@Column(name ="org_ref_id")
private Integer orgRefId;

@Column(name ="version_state")
private String versionState;

  @Column(name ="modified_by")
  private String modifiedBy;
  
  @Column(name ="created_by")
  private String createdBy;

  @UpdateTimestamp
  @Column(name ="modified_date")
  private Date modifiedDate;
  
  @CreationTimestamp
  @Column(name ="created_date")
  private Date createdDate;

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

public String getRetired() {
	return retired;
}

public void setRetired(String retired) {
	this.retired = retired;
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

public int getIsHCPCS() {
	return isHCPCS;
}

public void setIsHCPCS(int isHCPCS) {
	this.isHCPCS = isHCPCS;
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

  
}
